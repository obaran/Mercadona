package com.onur.mercadona.Service;

import com.onur.mercadona.model.Product;
import com.onur.mercadona.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product putProductInPromotion(Long id, LocalDate startDate, LocalDate endDate, double discountPercentage) {
        // Implémentez la logique pour mettre un produit en promotion
        // Vous pouvez utiliser le productRepository pour accéder à la base de données
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            // Mettez en œuvre la logique pour mettre le produit en promotion ici
            // Assurez-vous de mettre à jour les dates de début et de fin, ainsi que le pourcentage de remise
            product.setStartDate(startDate);
            product.setEndDate(endDate);
            product.setDiscountPercentage(discountPercentage);
            return productRepository.save(product);
        }
        return null; // Gérer le cas où le produit n'est pas trouvé
    }
}