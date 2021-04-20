package pujaQpuja.controller.modelos;

import pujaQpuja.model.entities.Usuario;
import pujaQpuja.model.repository.UsuarioRepository;

public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController() {
        usuarioRepository = new UsuarioRepository();
    }

    public boolean crear(Usuario usuario) {
        return usuarioRepository.crear(usuario);
    }

    public boolean buscarPorCorreo(Usuario usuario) {
        return usuarioRepository.buscarPorCorreo(usuario);
    }

    public boolean modificar(Usuario usuario) {
        return usuarioRepository.modificar(usuario);
    }
}
