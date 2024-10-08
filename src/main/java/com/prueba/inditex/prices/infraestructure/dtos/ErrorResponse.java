package com.prueba.inditex.prices.infraestructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private int statusCode;
    private String message;
}

