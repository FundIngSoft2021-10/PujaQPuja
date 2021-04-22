package pujaQpuja.model.entities;

public enum EstadoPuja {
    ACTIVO, INACTIVO, PAUSADO;

    public String getActivo() {
        return "Activo";
    }

    public String getInactivo() {
        return "Inactivo";
    }

    public String getPausado() {
        return "Pausado";
    }

}
