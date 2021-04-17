package pujaQpuja.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//////

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pujaQpuja.model.Categoría;
import pujaQpuja.model.CompradorXpuja;

///



import pujaQpuja.model.EstadoPuja;
import pujaQpuja.model.Producto;
import pujaQpuja.model.Puja;
import pujaQpuja.model.Usuario;


public class ControllerGeneral {


    private Usuario autenticado;
    private List<Puja> pujasActivas;
    private Puja temporalVisualizada;


    public ControllerGeneral(Usuario autenticado, List<Puja> pujasActivas, Puja temporalVisualizada) {
        this.autenticado = autenticado;
        this.pujasActivas = pujasActivas;
        this.temporalVisualizada = temporalVisualizada;
    }

    public Puja getTemporalVisualizada() {
        return this.temporalVisualizada;
    }

    public void setTemporalVisualizada(Puja temporalVisualizada) {
        this.temporalVisualizada = temporalVisualizada;
    }

    public ControllerGeneral temporalVisualizada(Puja temporalVisualizada) {
        setTemporalVisualizada(temporalVisualizada);
        return this;
    }

    
    public ControllerGeneral() {
        pujasActivas= new ArrayList<Puja>();
        for(int i=0;i<10;i++){
            Puja puj = new Puja();
            Producto producto = new Producto();
            producto.insertarCategoria(Categoría.CALZADO);
            producto.insertarCategoria(Categoría.DEPORTE);
            producto.setNombre("Pantalon talla 30");
            producto.setDescripcion("buen estado talla 30 color azul xd");
            ImageView image1 = new ImageView(new Image("file:" +"src/main/resources/images/logo.png",118,118,false,false));
   
            //ImageView image = new Image (imagen);
            producto.insertarFoto(image1);

            puj.setListaCompradores(new ArrayList<CompradorXpuja>());
            puj.setPrecioFinal(200);
            puj.setFecha(null);
            puj.setListaCompradores(null);
            puj.setProducto(producto);
            puj.setVendedor(autenticado);
            puj.setEstado(EstadoPuja.ACTIVO);
            pujasActivas.add(puj);
          
        }
            
           
            

 

    }




    public ControllerGeneral(Usuario autenticado,List< Puja> pujasActivas) {
        this.autenticado = autenticado;
       this.pujasActivas=pujasActivas;
    }


    public List<Puja> getPujasActivas() {
        return this.pujasActivas;
    }

    public void setPujasActivas(List<Puja> pujasActivas) {
        this.pujasActivas = pujasActivas;
    }

    public ControllerGeneral pujasActivas(List<Puja> pujasActivas) {
        setPujasActivas(pujasActivas);
        return this;
    }
 

   


    public ControllerGeneral(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public ControllerGeneral autenticado(Usuario autenticado) {
        setAutenticado(autenticado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ControllerGeneral)) {
            return false;
        }
        ControllerGeneral controllerGeneral = (ControllerGeneral) o;
        return Objects.equals(autenticado, controllerGeneral.autenticado);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(autenticado);
    }

    @Override
    public String toString() {
        return "{" +
            " autenticado='" + getAutenticado() + "'" +
            "}";
    }
    public Puja buscarPuja(Long id)
    {
                for (Puja puja : pujasActivas) {
                    if(puja.getIdentificador()==id)
                    {
                        return puja;
                    }
                }
                return null;
    }
    
}
