package com.asuajeyeison.ApiRest.service;

import com.asuajeyeison.ApiRest.model.Producto;
import com.asuajeyeison.ApiRest.repositorie.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
     return productoRepository.findAll();
    }
    public void guardarProducto(Producto producto){
        productoRepository.save(producto);
    }
    public Producto obtenerProductoPorId( Integer id){
        return productoRepository.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }
}
