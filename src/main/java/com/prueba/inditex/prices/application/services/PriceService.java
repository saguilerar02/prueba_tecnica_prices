package com.prueba.inditex.prices.application.services;

import com.prueba.inditex.prices.domain.model.Price;
import java.time.LocalDateTime;

public interface PriceService {

    Price retrieveFinalPriceUseCase (Long brandId,Long productId, LocalDateTime applicationDate);
}
