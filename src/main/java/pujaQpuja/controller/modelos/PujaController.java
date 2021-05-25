package pujaQpuja.controller.modelos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javafx.scene.image.ImageView;
import pujaQpuja.model.entities.*;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.model.repository.PujaRepository;
import pujaQpuja.controller.pantallas.PantallaSeleccionarCategoriaController;

public class PujaController {

    private PujaRepository pujaRepository;
    private PantallaSeleccionarCategoriaController seleccionarCategoriaController;
    private AutenticacionController autenticacionController;

    private Puja seleccionada;

    public PujaController() {
        pujaRepository = new PujaRepository();
        seleccionarCategoriaController = new PantallaSeleccionarCategoriaController();
        autenticacionController = AutenticacionController.getInstance();
    }

    public void crear(Producto producto) {
        Puja puja = new Puja();
        puja.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
        puja.setPrecioFinal(producto.getPrecioInicial());
        long idUsuario = autenticacionController.getAutenticado().getId();
        puja.setVendedor(autenticacionController.getAutenticado());
        pujaRepository.crear(puja, idUsuario, producto.getId());
    }

    public List<TablaCatalogoTemporal> getPujasActivasItems() {
        return getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja.ACTIVO, null);
    }

    public List<TablaCatalogoTemporal> getPujasActivaByCategoria(Categoria categoria) {
        return getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja.ACTIVO, categoria);
    }

    public List<TablaCatalogoTemporal> getPujasActivasByEstadoPujaYCategoriaProducto(EstadoPuja estado, Categoria filtro) {
        List<TablaCatalogoTemporal> datos = new ArrayList<>();

        for (Puja actual : pujaRepository.getPujasActivasByEstadoPujaYCategoriaProducto(estado, filtro)) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripci�n:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            temp.setDesc(dtemp.toString());
            datos.add(temp);
        }
        return datos;
    }

    public List<TablaCatalogoTemporal> getPujasPropiasA() {
        return getPujasPropias(null);
    }

    public List<TablaCatalogoTemporal> getPujasPropias(Categoria filtro) {
        List<TablaCatalogoTemporal> datos = new ArrayList<>();

        for (Puja actual : pujaRepository.getPujasPropiasDB(filtro, autenticacionController.getAutenticado().getId())) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripcion:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            temp.setDesc(dtemp.toString());
            temp.setEstado(actual.getEstado().toString());
            datos.add(temp);
        }
        return datos;
    }

    public Puja pujaVisualizada(Puja temp) {
        System.out.println(temp.getId());
        seleccionada = this.pujaRepository.buscarPujaPorId(temp.getId());
        return seleccionada;
    }

    public int obtenerNumeroPujantesPorPujaId(Long id) {
        return this.pujaRepository.getNumeroPujantesPorPujaId(id);
    }

    public boolean insertarComprador(Long idPuja, Long idComprador, Double precioPujado) {
        return this.pujaRepository.agregarPujante(idPuja, idComprador, precioPujado);
    }

    public boolean actualizarPrecio(Long idPuja, Double nuevoprecio) {
        return this.pujaRepository.actualizarPrecio(nuevoprecio, idPuja);
    }

    public boolean reanudarPuja(long idPuja) {
        return this.pujaRepository.reanudarPujaPorPuja(idPuja);
    }

    public boolean pausarPuja(long idPuja) {
        return this.pujaRepository.pausarPuja(idPuja);
    }

    public boolean eliminarPuja(Long idPuja) {
        boolean eliminado = this.pujaRepository.eliminarPujaPorId(idPuja);
        return eliminado;
    }

    public List<TablaCatalogoTemporal> getPujasGanadasA() {
        return getPujasGanadas(null);
    }

    public List<TablaCatalogoTemporal> getPujasGanadas(Categoria filtro) {
        List<TablaCatalogoTemporal> datos = new ArrayList<>();
        for (Puja actual : pujaRepository.getPujasGanadasDB(filtro, autenticacionController.getAutenticado().getId())) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripcion:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            temp.setDesc(dtemp.toString());
            temp.setEstado(actual.getEstado().toString());
            datos.add(temp);
        }
        return datos;
    }

    public List<TablaCatalogoTemporal> getPujasMasPopulares(Categoria selectedItem) {
        List<TablaCatalogoTemporal> datos = new ArrayList<>();

        for (Puja actual : pujaRepository.getPujasMasPopularesDB()) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripcion:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            temp.setDesc(dtemp.toString());
            datos.add(temp);
        }
        return datos;
    }

    public void ganadorPuja() {
        //obtenerPujantesMayores
        Map<Long, Long> compradoresXPuja = pujaRepository.obtenerPujantesMayores();

        for (Map.Entry<Long, Long> cXp : compradoresXPuja.entrySet()) {
            //actualizarPujasFinalizadas
            pujaRepository.actualizarPujasFinalizadas(cXp.getKey(), cXp.getValue());
        }
    }

    public List<TablaCatalogoTemporal> obtenerNotificaciones() {
        Long id = autenticacionController.getAutenticado().getId();

        //List<Puja> pujas = new ArrayList<>();
        //pujas.addAll(pujaRepository.obtenerNotificacionesComprador(id));
        //pujas.addAll(pujaRepository.obtenerNotificacionesVendedor(id));

        List<TablaCatalogoTemporal> datos = new ArrayList<>();

        for (Puja actual : pujaRepository.obtenerNotificacionesComprador(id)) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            //StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripcion:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            //temp.setDesc(dtemp.toString());
            //temp.setEstado(actual.getEstado().toString());
            temp.setMensajeNotificacion("Se ha terminado la puja del producto " + actual.getProducto().getNombre() + " y el producto es suyo, " + "continue con la realización pago.");
            datos.add(temp);
        }

        for (Puja actual : pujaRepository.obtenerNotificacionesVendedor(id)) {
            TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
            temp.setPuja(actual);
            if (actual.getProducto() != null) {
                if (actual.getProducto().getFoto() != null) {
                    temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                }
            }
            //StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n" + "Descripcion:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ " + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: " + actual.getProducto().getCategoria());
            //temp.setDesc(dtemp.toString());
            //temp.setEstado(actual.getEstado().toString());
            temp.setMensajeNotificacion("Se ha terminado la puja del producto " + actual.getProducto().getNombre() + " con éxito");
            datos.add(temp);
        }
        return datos;
    }

    public boolean actualizarPuja(Puja puja) {
        Long id = autenticacionController.getAutenticado().getId();
        if(puja.getComprador().getId() == id) {
            return pujaRepository.actualizarNotificacionesComprador(puja.getId());
        }
        else {
            return pujaRepository.actualizarNotificacionesVendedor(puja.getId());
        }
    }
}