package com.neo.product.mapper;

import com.neo.product.dto.ProductDTO;
import com.neo.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target="id", ignore = true)
    Product toEntity(ProductDTO dto);
    ProductDTO toDto(Product entity);

    List<Product> toListEntity(List<ProductDTO> productDTOS);
}
