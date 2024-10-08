package com.prueba.inditex.prices.infraestructure.repositories;

import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.domain.ports.out.PriceRepositoryPort;
import com.prueba.inditex.prices.infraestructure.mapper.PriceEntityToPriceMapper;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;
    private final PriceEntityToPriceMapper toModelAdapter;

    @Override
    public Optional<Price> findPriceByBrandIdAndProductIdAndApplicationDate(Long brandId, Long productId, LocalDateTime applicationDate) {
        return  jpaPriceRepository
                .findPrioritizedPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate)
                .map(toModelAdapter::fromPriceEntityToPriceModel);

    }
}
