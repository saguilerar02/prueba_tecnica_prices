package com.prueba.inditex.prices.infraestructure.exceptions;

public class PriceNotFoundException extends  RuntimeException {

    public PriceNotFoundException(String message) {
        super(message);
    }
}
