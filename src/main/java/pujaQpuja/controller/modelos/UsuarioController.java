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

    public Usuario buscarPorId(long usuario) {
        return usuarioRepository.buscarPorIdUsuario(usuario);
    }

    public boolean modificar(Usuario usuario) {
        return usuarioRepository.modificar(usuario);
    }

    public double obtenerCalificacionV(long id) {
        return usuarioRepository.getCalificacionV(id);
    }

    public boolean calificarV(double calificacion, long id) {
        if(obtenerCalificacionV(id)!=0.0){
            calificacion=(calificacion+obtenerCalificacionV(id))/2;
            return usuarioRepository.calificarVendedor(calificacion,id);
        } else
            return usuarioRepository.calificarVendedor(calificacion,id);
    }
}
