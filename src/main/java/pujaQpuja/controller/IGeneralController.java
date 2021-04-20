package pujaQpuja.controller;

import java.util.List;

import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.Usuario;

public interface IGeneralController {

    //----------------------------------------------------------
    //---------------- Autenticacion y Sesión ------------------
    //----------------------------------------------------------

    public boolean iniciarSesion(String correo, String password);

    //----------------------------------------------------------
    //----------------------- Catálogo -------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //---------------------- Categoría -------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //------------------------- Chat ---------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //----------------------- Mensaje --------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //----------------------- Producto -------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //------------------------- Puja ---------------------------
    //----------------------------------------------------------

    //----------------------------------------------------------
    //------------------------ Usuario -------------------------
    //----------------------------------------------------------

/*
    public Puja getTemporalVisualizada();
    public void setTemporalVisualizada(Puja temporalVisualizada);
    public GeneralController temporalVisualizada(Puja temporalVisualizada);
*/
    public List<Puja> getPujasActivas();
    public void setPujasActivas(List<Puja> pujasActivas);
    public GeneralController pujasActivas(List<Puja> pujasActivas);

    public Usuario getAutenticado();
    public void setAutenticado(Usuario autenticado);
    public GeneralController autenticado(Usuario autenticado);

}
