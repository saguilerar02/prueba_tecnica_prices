package com.prueba.inditex.prices.units.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.prueba.inditex.prices.application.services.PriceServiceImpl;
import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.domain.ports.in.RetrieveFinalPriceUseCase;
import com.prueba.inditex.prices.infraestructure.exceptions.PriceNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PriceServiceImplTest {

    @Mock
    private RetrieveFinalPriceUseCase retrieveFinalPriceUseCase;

    @InjectMocks
    private PriceServiceImpl priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    public void testRetrieveFinalPriceUseCase_Success() {
        Long brandId = 1L;
        Long productId = 100L;
        LocalDateTime applicationDate = LocalDateTime.now();

        Price expectedPrice = Price.builder().build();

        when(retrieveFinalPriceUseCase.retrieveFinalPriceUseCase(brandId, productId, applicationDate))
                .thenReturn(Optional.of(expectedPrice));

        Price result = priceService.retrieveFinalPriceUseCase(brandId, productId, applicationDate);

        assertNotNull(result);
        assertEquals(expectedPrice, result);

        verify(retrieveFinalPriceUseCase, times(1))
                .retrieveFinalPriceUseCase(brandId, productId, applicationDate);
    }

    @Test
    public void testRetrieveFinalPriceUseCase_PriceNotFound() {
        Long brandId = 1L;
        Long productId = 100L;
        LocalDateTime applicationDate = LocalDateTime.now();

        when(retrieveFinalPriceUseCase.retrieveFinalPriceUseCase(brandId, productId, applicationDate))
                .thenReturn(Optional.empty());

        PriceNotFoundException exception = assertThrows(
                PriceNotFoundException.class,
                () -> priceService.retrieveFinalPriceUseCase(brandId, productId, applicationDate)
        );

        assertEquals("No price found for product 100 and brand 1 on date " + applicationDate, exception.getMessage());

        verify(retrieveFinalPriceUseCase, times(1))
                .retrieveFinalPriceUseCase(brandId, productId, applicationDate);
    }
}
