package com.dchupilko.product.controller;

import com.dchupilko.product.data.ProductModelRepository;
import com.dchupilko.product.dto.mapper.ProductModelMapper;
import com.dchupilko.product.dto.model.ProductModelDto;
import com.dchupilko.product.exception.ProductModelNotFoundException;
import com.dchupilko.product.model.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductCatalogController {

    private final ProductModelMapper modelMapper;
    private final ProductModelRepository modelRepository;

    @GetMapping
    public ResponseEntity<List<ProductModelDto>> getModels() {
        return new ResponseEntity<>(
                modelMapper.toProductModelDtos(modelRepository.findAll()),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModelDto> getModel(@PathVariable String id) {
        return new ResponseEntity<>(
                modelMapper.toProductModelDto(getModelSafe(id)),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ProductModelDto> createModel(@RequestBody ProductModelDto modelDto) {
        ProductModel model = modelRepository.save(
                modelMapper.toProductModel(modelDto)
        );
        return new ResponseEntity<>(
                modelMapper.toProductModelDto(model),
                HttpStatus.CREATED);
    }

    private ProductModel getModelSafe(String id) {
        return modelRepository.findById(id).orElseThrow(
                () -> new ProductModelNotFoundException(id)
        );
    }
}
