package com.prueba.inditex.prices.infraestructure.mapper;

import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.infraestructure.dtos.PriceResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PriceToPriceResponseDtoMapper {

    public PriceResponseDTO fromPriceToPriceResponseDto (Price model){
        return PriceResponseDTO.builder()
                .productId(model.getProductId())
                .brandId(model.getBrandId())
                .price(model.getPrice())
                .startDate(model.getStartDate())
                .endDate(model.getEndDate())
                .priceList(model.getPriceList())
                .build();
    }

}
