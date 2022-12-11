package com.etiya.ecommercedemopair3.repository.abstracts;

import com.etiya.ecommercedemopair3.entities.concrets.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    @Query("Select p from Product as p WHERE name=:name")
    Product findByName(String name);
}
