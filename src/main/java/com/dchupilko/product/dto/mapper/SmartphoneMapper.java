package com.dchupilko.product.dto.mapper;

import com.dchupilko.product.dto.model.SmartphoneDto;
import com.dchupilko.product.model.Smartphone;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SmartphoneMapper {

    SmartphoneDto toSmartphoneDto(Smartphone model);

    List<SmartphoneDto> toSmartphoneDtos(List<Smartphone> models);

    @InheritConfiguration(name="toProductModel")
    Smartphone toSmartphone(SmartphoneDto modelDto);
}
