package com.example.demojpag6.Repositery;

import com.example.demojpag6.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepositery extends JpaRepository<Produit,Long> {
    @Query("SELECT p FROM Produit p WHERE p.Price > :price")
    List<Produit> findProductsByPriceGreaterThan(@Param("price") double price);

}
