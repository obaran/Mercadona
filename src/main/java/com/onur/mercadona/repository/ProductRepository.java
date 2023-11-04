package com.onur.mercadona.repository;

import com.onur.mercadona.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
