package com.dchupilko.product.dto.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SmartphoneDto extends ProductModelDto {

    private String color;
    private String capacity;
}
