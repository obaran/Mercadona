package com.onur.mercadona.repository;

import com.onur.mercadona.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product,Long> {
}
