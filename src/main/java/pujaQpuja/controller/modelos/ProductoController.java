package pujaQpuja.controller.modelos;

import pujaQpuja.model.entities.Producto;
import pujaQpuja.model.repository.ProductoRepository;

public class ProductoController {

    ProductoRepository productoRepository;

    public ProductoController() {
        productoRepository = new ProductoRepository();
    }

    public Producto buscarPorID(long idProducto) {
        return productoRepository.buscarPorID(idProducto);
    }
    
    public void crear(Producto producto){
        productoRepository.crear(producto);
    }
}
