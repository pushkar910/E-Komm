package com.pushkar.ekomm.product.repository;

import com.pushkar.ekomm.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
