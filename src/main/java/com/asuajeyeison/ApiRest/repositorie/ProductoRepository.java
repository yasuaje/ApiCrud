package com.asuajeyeison.ApiRest.repositorie;

import com.asuajeyeison.ApiRest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}