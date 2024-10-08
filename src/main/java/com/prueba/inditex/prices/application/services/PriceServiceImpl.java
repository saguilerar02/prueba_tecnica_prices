package com.prueba.inditex.prices.application.services;

import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.domain.ports.in.RetrieveFinalPriceUseCase;
import com.prueba.inditex.prices.infraestructure.exceptions.PriceNotFoundException;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final RetrieveFinalPriceUseCase retrieveFinalPriceUseCase;

    @Override
    public Price retrieveFinalPriceUseCase(Long brandId,Long productId,  LocalDateTime applicationDate) {

        return this.retrieveFinalPriceUseCase.retrieveFinalPriceUseCase(brandId, productId, applicationDate)
               .orElseThrow(
                       () -> new PriceNotFoundException(
                               "No price found for product " + productId +
                               " and brand " + brandId +
                               " on date " + applicationDate)
               );
    }
}
