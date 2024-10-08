package com.prueba.inditex.prices.units.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.prueba.inditex.prices.application.usecases.RetrieveFinalPriceUseCaseImpl;
import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.domain.ports.out.PriceRepositoryPort;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RetrieveFinalPriceUseCaseImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private RetrieveFinalPriceUseCaseImpl priceUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveFinalPriceUseCase_Success() {
        Long brandId = 1L;
        Long productId = 100L;
        LocalDateTime applicationDate = LocalDateTime.now();

        Price expectedPrice = Price.builder().build();

        when(priceRepositoryPort.findPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> result = priceUseCase.retrieveFinalPriceUseCase(brandId, productId, applicationDate);

        assertTrue(result.isPresent());
        assertEquals(expectedPrice, result.get());

        verify(priceRepositoryPort, times(1))
                .findPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);
    }

    @Test
    public void testRetrieveFinalPriceUseCase_PriceNotFound() {
        Long brandId = 1L;
        Long productId = 100L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(priceRepositoryPort.findPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate))
                .thenReturn(Optional.empty());

        Optional<Price> result = priceUseCase.retrieveFinalPriceUseCase(brandId, productId, applicationDate);

        assertFalse(result.isPresent());

        verify(priceRepositoryPort, times(1))
                .findPriceByBrandIdAndProductIdAndApplicationDate(brandId, productId, applicationDate);
    }
}
