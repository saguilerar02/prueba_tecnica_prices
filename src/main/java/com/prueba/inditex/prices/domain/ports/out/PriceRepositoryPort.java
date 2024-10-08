package com.prueba.inditex.prices.domain.ports.out;

import com.prueba.inditex.prices.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPriceByBrandIdAndProductIdAndApplicationDate(Long brandId, Long productId, LocalDateTime applicationDate);
}
