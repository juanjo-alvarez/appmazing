package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDto;

import java.util.List;

public interface IProductService {
    ProductDto queryProduct(ProductDto productdto);

    List<ProductDto> queryAllProducts();

    int insertProduct(ProductDto productdto);

    int updateProduct(ProductDto productdto);

    int deleteProduct(ProductDto productdto);
}
