package pujaQpuja.controller;

import pujaQpuja.controller.modelos.UsuarioController;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.Usuario;

public class GeneralController {

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
    private UsuarioController usuarioController;
    private Puja temporalVisualizada;


    // ----------------------------------------------------------
    // ---------------------- Constructor -----------------------
    // ----------------------------------------------------------

    public GeneralController() {
        usuarioController = new UsuarioController();
    }

    // ----------------------------------------------------------
    // ---------------- Autenticacion y Sesión ------------------
    // ----------------------------------------------------------

    public boolean iniciarSesion(String correo, String password) {
        Usuario temp = new Usuario();
        temp.setCorreo(correo);

        if (usuarioController.buscarPorCorreo(temp)) {
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

    public Puja getTemporalVisualizada() {
        return this.temporalVisualizada;
    }

    public void setTemporalVisualizada(Puja temporalVisualizada) {
        this.temporalVisualizada = temporalVisualizada;
    }

    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

}
