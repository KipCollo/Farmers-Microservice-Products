package  com.kipcollo.order.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.kipcollo.order.customer.CustomerResponse;
import com.kipcollo.order.dto.PurchaseResponse;
import com.kipcollo.order.model.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderConfirmation {

    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMthod;
    private CustomerResponse customer;
    List<PurchaseResponse> products;
}
