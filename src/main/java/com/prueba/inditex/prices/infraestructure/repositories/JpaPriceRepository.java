package com.prueba.inditex.prices.infraestructure.repositories;

import com.prueba.inditex.prices.infraestructure.entities.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("FROM PriceEntity p " +
            "WHERE p.brandId = :brandId AND p.productId = :productId AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findPrioritizedPriceByBrandIdAndProductIdAndApplicationDate(Long brandId, Long productId, LocalDateTime applicationDate);
}
