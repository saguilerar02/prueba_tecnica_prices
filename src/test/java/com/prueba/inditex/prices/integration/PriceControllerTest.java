package com.prueba.inditex.prices.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.prueba.inditex.prices.PricesApplication;
import com.prueba.inditex.prices.infraestructure.repositories.JpaPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = PricesApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
@ContextConfiguration(classes = {JpaPriceRepository.class})
@ComponentScan(basePackages = "com.pruebas.inditex.prices")
public class PriceControllerTest {

    //Prueba End To End
    @Autowired
    private MockMvc mockMvc;

    // Test 1: Petición a las 10:00 del día 14 de junio del producto 35455 para la marca 1 (ZARA)
    @Test
    public void testGetPriceAt10AMOnJune14() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Test 2: Petición a las 16:00 del día 14 de junio del producto 35455 para la marca 1 (ZARA)
    @Test
    public void testGetPriceAt4PMOnJune14() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14 16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    // Test 3: Petición a las 21:00 del día 14 de junio del producto 35455 para la marca 1 (ZARA)
    @Test
    public void testGetPriceAt9PMOnJune14() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-14 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    // Test 4: Petición a las 10:00 del día 15 de junio del producto 35455 para la marca 1 (ZARA)
    @Test
    public void testGetPriceAt10AMOnJune15() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-15 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    // Test 5: Petición a las 21:00 del día 16 de junio del producto 35455 para la marca 1 (ZARA)
    @Test
    public void testGetPriceAt9PMOnJune16() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("applicationDate", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }

    @Test
    void testPriceNotFoundException() throws Exception {

        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "36455")
                        .param("applicationDate", "2020-06-14T10:00:00"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No price found for product 36455 " +
                        "and brand 1 on date 2020-06-14T10:00"));
    }
}
