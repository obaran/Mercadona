package com.onur.mercadona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onur.mercadona.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    // Vous pouvez ajouter ici des méthodes de requête personnalisées si nécessaire
}
