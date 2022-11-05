package com.dchupilko.product.dto.mapper;

import com.dchupilko.product.dto.model.ProductModelDto;
import com.dchupilko.product.dto.model.SmartphoneDto;
import com.dchupilko.product.model.ProductModel;
import com.dchupilko.product.model.Smartphone;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SmartphoneMapper.class})
public interface ProductModelMapper {

    @SubclassMapping(source = Smartphone.class, target = SmartphoneDto.class)
    ProductModelDto toProductModelDto(ProductModel model);

    List<ProductModelDto> toProductModelDtos(List<ProductModel> models);

    @SubclassMapping(source = SmartphoneDto.class, target = Smartphone.class)
    ProductModel toProductModel(ProductModelDto modelDto);
}
