package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
