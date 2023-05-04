package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
@Lazy
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public ProductDto queryProduct(ProductDto productdto) {
        Product product = ProductMapper.INSTANCE.toEntity(productdto);
        return ProductMapper.INSTANCE.toDTO(productDao.getReferenceById(product.getId()));
    }

    @Override
    public List<ProductDto> queryAllProducts() {
        return ProductMapper.INSTANCE.toDTOList(productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDto productdto) {
        Product product = ProductMapper.INSTANCE.toEntity(productdto);
        productDao.saveAndFlush(product);
        return product.getId();
    }

    @Override
    public int updateProduct(ProductDto productdto) {
        return insertProduct(productdto);
    }

    @Override
    public int deleteProduct(ProductDto productdto) {
        Product product = ProductMapper.INSTANCE.toEntity(productdto);
        productDao.delete(product);
        return product.getId();
    }
}
