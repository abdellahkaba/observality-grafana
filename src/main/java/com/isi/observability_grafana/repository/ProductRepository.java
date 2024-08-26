package com.isi.observability_grafana.repository;

import com.isi.observability_grafana.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
