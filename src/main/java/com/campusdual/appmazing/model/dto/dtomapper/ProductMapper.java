package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDTO(Product product);

    List<ProductDto> toDTOList(List<Product> products);

    Product toEntity(ProductDto productdto);
}
