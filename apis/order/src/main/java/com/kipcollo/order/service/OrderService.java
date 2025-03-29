package com.kipcollo.order.service;

import java.util.List;
import java.util.stream.Collectors;

import com.kipcollo.order.payment.PaymentClient;
import com.kipcollo.order.payment.PaymentRequest;
import org.springframework.stereotype.Service;

import com.kipcollo.order.customer.CustomerClient;
import com.kipcollo.order.dto.OrderRequest;
import com.kipcollo.order.dto.OrderResponse;
import com.kipcollo.order.dto.PurchaseRequest;
import com.kipcollo.order.exceptions.BusinessException;
import com.kipcollo.order.kafka.OrderConfirmation;
import com.kipcollo.order.kafka.OrderProducer;
import com.kipcollo.order.orderline.OrderLineRequest;
import com.kipcollo.order.orderline.OrderLineService;
import com.kipcollo.order.product.ProductClient;
import com.kipcollo.order.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repo;
    private final OrderMapper mapper;
    private final OrderLineService service;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {

        //check the customer -->OpenFeign
        var customer = this.customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exists with provided ID:: " + request.getCustomerId()));

        //purchase the product
        var purchasedProducts = this.productClient.purchaseProducts(request.getProducts());

        //persist order
        var order = repo.save(mapper.toOrder(request));

        //persist order lines
        for(PurchaseRequest purchaseRequest:request.getProducts()){
            service.saveOrderLine(
                new OrderLineRequest(
                    0, 
                    order.getOrderId(), 
                    purchaseRequest.getProductId(), 
                    purchaseRequest.getQuantity())
            );
        }
        
        // start payment process
        var paymentRequest = new PaymentRequest(
                request.getTotalAmount(),
                request.getPaymentMethod(),
                order.getOrderId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //send order confirmation to notification
        orderProducer.sendOrderConfirmation(
            new OrderConfirmation(
                request.getReference(),
                request.getTotalAmount(),
                request.getPaymentMethod(),
                customer,
                purchasedProducts
            )
        );

        return order.getOrderId();

    }
    public List<OrderResponse> findAll(){
        return repo.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(int orderId){
        return repo.findById(orderId)
            .map(mapper::fromOrder)
            .orElseThrow(
                ()->new EntityNotFoundException(String.format("No order found with provided ID: %d",orderId))
            );
    }

}
