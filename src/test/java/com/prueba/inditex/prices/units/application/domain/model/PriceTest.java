package com.prueba.inditex.prices.units.application.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.prueba.inditex.prices.domain.model.Price;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test
    public void testPriceBuilderAndGetters() {
        Long brandId = 1L;
        Long priceList = 2L;
        Long productId = 100L;
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        Integer priority = 1;
        Double price = 99.99;
        String currency = "EUR";

        Price priceObject = Price.builder()
                .brandId(brandId)
                .priceList(priceList)
                .productId(productId)
                .startDate(startDate)
                .endDate(endDate)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();

        assertEquals(brandId, priceObject.getBrandId());
        assertEquals(priceList, priceObject.getPriceList());
        assertEquals(productId, priceObject.getProductId());
        assertEquals(startDate, priceObject.getStartDate());
        assertEquals(endDate, priceObject.getEndDate());
        assertEquals(priority, priceObject.getPriority());
        assertEquals(price, priceObject.getPrice());
        assertEquals(currency, priceObject.getCurrency());
    }

    @Test
    public void testPriceBuilderWithNullValues() {
        Price priceObject = Price.builder()
                .brandId(null)
                .priceList(null)
                .productId(null)
                .startDate(null)
                .endDate(null)
                .priority(null)
                .price(null)
                .currency(null)
                .build();

        assertNull(priceObject.getBrandId());
        assertNull(priceObject.getPriceList());
        assertNull(priceObject.getProductId());
        assertNull(priceObject.getStartDate());
        assertNull(priceObject.getEndDate());
        assertNull(priceObject.getPriority());
        assertNull(priceObject.getPrice());
        assertNull(priceObject.getCurrency());
    }

    @Test
    public void testPriceBuilderEquality() {
        Long brandId = 1L;
        Long priceList = 2L;
        Long productId = 100L;
        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now().plusDays(1);
        Integer priority = 1;
        Double price = 99.99;
        String currency = "EUR";

        Price priceObject1 = Price.builder()
                .brandId(brandId)
                .priceList(priceList)
                .productId(productId)
                .startDate(startDate)
                .endDate(endDate)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();

        Price priceObject2 = Price.builder()
                .brandId(brandId)
                .priceList(priceList)
                .productId(productId)
                .startDate(startDate)
                .endDate(endDate)
                .priority(priority)
                .price(price)
                .currency(currency)
                .build();

        assertEquals(priceObject1.toString(), priceObject2.toString());
    }
}
