package com.empresa.microserviceProductManagement.Repository;

import com.empresa.microserviceProductManagement.Entities.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Products, Long> {

}
