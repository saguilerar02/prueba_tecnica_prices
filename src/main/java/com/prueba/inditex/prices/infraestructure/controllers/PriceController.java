package com.prueba.inditex.prices.infraestructure.controllers;


import com.prueba.inditex.prices.application.services.PriceService;
import com.prueba.inditex.prices.domain.model.Price;
import com.prueba.inditex.prices.infraestructure.dtos.PriceResponseDTO;
import com.prueba.inditex.prices.infraestructure.mapper.PriceToPriceResponseDtoMapper;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final PriceToPriceResponseDtoMapper dtoAdapter;

    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  LocalDateTime applicationDate) {

        Price price = priceService.retrieveFinalPriceUseCase(brandId,productId, applicationDate);

        PriceResponseDTO responseDTO = dtoAdapter.fromPriceToPriceResponseDto(price);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}