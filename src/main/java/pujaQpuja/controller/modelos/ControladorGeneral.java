package pujaQpuja.controller.modelos;

public class ControladorGeneral {
    public AutenticacionController autenticacionController;
    public ChatController chatController;
    public MensajeController mensajeController;
    public ProductoController productoController;
    public PujaController pujaController;
    public UsuarioController usuarioController;

    public ControladorGeneral() {
        this.autenticacionController = AutenticacionController.getInstance();
        this.chatController = new ChatController();
        this.mensajeController = new MensajeController();
        this.productoController = new ProductoController();
        this.pujaController = new PujaController();
        this.usuarioController = new UsuarioController();
    }

}
