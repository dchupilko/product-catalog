package com.dchupilko.product.data;

import com.dchupilko.product.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductModelRepository extends MongoRepository<ProductModel, String> {

    ProductModel findByBrandAndName(String brand, String name);
}
