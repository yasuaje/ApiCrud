package com.asuajeyeison.ApiRest.controller;

import com.asuajeyeison.ApiRest.model.Producto;
import com.asuajeyeison.ApiRest.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id){
        try {
            Producto producto = productoService.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/productos")
    public void guardarProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoActual = productoService.obtenerProductoPorId(id);

            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());

            productoService.guardarProducto(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }

}
