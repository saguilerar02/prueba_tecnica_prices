package com.prueba.inditex.prices.domain.ports.in;

import com.prueba.inditex.prices.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface RetrieveFinalPriceUseCase {

    Optional<Price> retrieveFinalPriceUseCase (Long brandId,Long productId, LocalDateTime applicationDate);
}
