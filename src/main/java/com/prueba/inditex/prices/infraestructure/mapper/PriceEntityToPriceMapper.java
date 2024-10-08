package com.prueba.inditex.prices.infraestructure.mapper;

import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.infraestructure.entities.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceEntityToPriceMapper {

    public Price fromPriceEntityToPriceModel(PriceEntity priceEntity){
        return Price.builder()
                .brandId(priceEntity.getBrandId())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .priceList(priceEntity.getPriceList())
                .productId(priceEntity.getProductId())
                .priority(priceEntity.getPriority())
                .price(priceEntity.getPrice())
                .currency(priceEntity.getCurrency())
                .build();
    }

}
