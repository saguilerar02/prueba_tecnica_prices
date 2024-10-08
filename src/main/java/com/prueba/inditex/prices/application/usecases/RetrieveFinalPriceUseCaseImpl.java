package com.prueba.inditex.prices.application.usecases;

import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.domain.ports.in.RetrieveFinalPriceUseCase;
import com.prueba.inditex.prices.domain.ports.out.PriceRepositoryPort;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RetrieveFinalPriceUseCaseImpl implements RetrieveFinalPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Optional<Price> retrieveFinalPriceUseCase(Long brandId, Long productId,LocalDateTime applicationDate) {

        return this.priceRepositoryPort.findPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);
    }
}
