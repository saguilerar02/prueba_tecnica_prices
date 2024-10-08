package com.prueba.inditex.prices.infraestructure.dtos;


import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceResponseDTO {
    private Long productId;
    private Long brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
}
