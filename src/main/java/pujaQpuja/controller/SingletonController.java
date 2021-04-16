package pujaQpuja.controller;


public  class SingletonController {
    
    private static SingletonController conexion=null;
    //private Usuario autenticado; 
    private ControllerGeneral controlador;

    private SingletonController() {

        controlador = new ControllerGeneral();
    
    }

    public static SingletonController getControllerAplication() {
        if(conexion==null)
        {
            conexion = new SingletonController();
        }
        return conexion;
    }

/*
    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }
*/



    public ControllerGeneral getControlador() {
        return controlador;
    }

}
