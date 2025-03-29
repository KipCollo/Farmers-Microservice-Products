package com.kipcollo.order.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class EntityNotFoundException extends RuntimeException{

    private final String message;
}
