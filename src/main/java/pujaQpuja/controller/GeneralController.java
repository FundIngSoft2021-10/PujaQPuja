package pujaQpuja.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.Producto;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.Usuario;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.repository.UsuarioRepository;

public class GeneralController implements IGeneralController {

    // ----------------------------------------------------------
    // ----------------------- Singleton ------------------------
    // ----------------------------------------------------------

    private static GeneralController conexion = null;

    public static GeneralController getControllerAplication() {
        if (conexion == null) {
            conexion = new GeneralController();
        }
        return conexion;
    }

    // ----------------------------------------------------------
    // ------------------ Variables Globales --------------------
    // ----------------------------------------------------------

    private Usuario autenticado;

    private List<Puja> pujasActivas;
    private Puja temporalVisualizada;

    private int contID;

    // ----------------------------------------------------------
    // ---------------------- Constructor -----------------------
    // ----------------------------------------------------------

    public GeneralController() {
        //Eliminar la linea de abajo
        obtenerPujas();
    }

    // ----------------------------------------------------------
    // ---------------- Autenticacion y Sesión ------------------
    // ----------------------------------------------------------

    public boolean iniciarSesion(String correo, String password) {
        Usuario temp = new Usuario();
        temp.setCorreo(correo);

        if (UsuarioRepository.buscarPorCorreo(temp)) {
            if (temp.getPassword().equals(password)) {
                autenticado = temp;
                System.out.println("ENTRASTE CORRECTAMENTE");
                return true;
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Correo incorrecto");
        }
        return false;
    }

    // ----------------------------------------------------------
    // ------------------------- Otros --------------------------
    // ----------------------------------------------------------

    public void obtenerPujas() {
        // TODO hacerlo mirando la base de datos
        pujasActivas = new ArrayList<Puja>();
        for (int i = 0; i < 10; i++) {
            Puja puj = new Puja();
            Producto producto = new Producto();
            producto.setCategoria(Categoria.CALZADO);
            producto.setNombre("Pantalon talla 30");
            producto.setDescripcion("buen estado talla 30 color azul xd");
            Image image1 = new Image("file:" + "src/main/resources/images/logo.png", 118, 118, false, false);

            // ImageView image = new Image (imagen);
            producto.setFoto(image1);

            puj.setPrecioFinal(200);
            puj.setFecha(null);
            puj.setListaCompradores(null);
            puj.setProducto(producto);
            puj.setVendedor(autenticado);
            puj.setEstado(EstadoPuja.ACTIVO);
            pujasActivas.add(puj);

        }

    }

    public Puja getTemporalVisualizada() {
        return this.temporalVisualizada;
    }

    public void setTemporalVisualizada(Puja temporalVisualizada) {
        this.temporalVisualizada = temporalVisualizada;
    }

    public GeneralController temporalVisualizada(Puja temporalVisualizada) {
        setTemporalVisualizada(temporalVisualizada);
        return this;
    }

    public GeneralController(Usuario autenticado, List<Puja> pujasActivas) {
        this.autenticado = autenticado;
        this.pujasActivas = pujasActivas;
    }

    public List<Puja> getPujasActivas() {
        return this.pujasActivas;
    }

    public void setPujasActivas(List<Puja> pujasActivas) {
        this.pujasActivas = pujasActivas;
    }

    public GeneralController pujasActivas(List<Puja> pujasActivas) {
        setPujasActivas(pujasActivas);
        return this;
    }

    public GeneralController(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public GeneralController autenticado(Usuario autenticado) {
        setAutenticado(autenticado);
        return this;
    }

    public Puja buscarPuja(Long id) {
        // TODO hacerlo mirando la base de datos
        for (Puja puja : pujasActivas) {
            if (puja.getId() == id) {
                return puja;
            }
        }
        return null;
    }

    public void setActualizarUsuario(Usuario usuario) {
        UsuarioRepository.modificar(usuario);
    }

    public boolean usuarioRegistradoCorreo(String correo) {
        return UsuarioRepository.buscarUsuarioCorreo(correo);
    }

    public void crear(Usuario usuario) {
        UsuarioRepository.crear(usuario);
    }


    public void agregarPujaActiva(Puja pujaActiva){
        this.pujasActivas.add(pujaActiva);
    }

    public int getContID() {
        return this.contID;
    }

    public void setContID(int contID) {
        this.contID = contID;
    }

    public void incrementarId(){
        this.contID++;
    }


}
