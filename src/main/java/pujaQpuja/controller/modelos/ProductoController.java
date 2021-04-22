package pujaQpuja.controller.modelos;

import java.sql.SQLException;

import pujaQpuja.model.entities.Producto;
import pujaQpuja.model.repository.ProductoRepository;

public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController() {
        productoRepository = new ProductoRepository();
    }

    public Producto buscarPorId(long idProducto) {
        return productoRepository.buscarProductoPorId(idProducto);
    }

    public boolean crear(Producto producto, String rutaImagen) {
        return productoRepository.crear(producto, rutaImagen);
    }
}
