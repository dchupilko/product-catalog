package com.dchupilko.product.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "models")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Accessors(chain = true)
public class ProductModel {

    @Id
    private String id;
    private String brand;
    private String name;
}
