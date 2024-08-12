package com.medLAB.services;

import com.medLAB.dtos.LoginRequest;
import com.medLAB.dtos.UsuarioRequest;
import com.medLAB.entities.PerfilEntity;
import com.medLAB.entities.Usuario;
import com.medLAB.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;

    public static void logar(UsuarioRequest usuarioRequest) {
    }

    public void cadastrarUsuario(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.findByUsername(usuarioRequest.getUsername()).isPresent()){
            //todo erro

        }
        PerfilEntity perfil = perfilService.validarPerfil(usuarioRequest.getUsername());

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));

        usuarioRepository.save(usuario);
    }

    public Usuario validarUsuario(LoginRequest loginRequest){
        Usuario usuario = (Usuario) usuarioRepository
                .findByUsername(loginRequest.username())
                .orElseThrow(
                        ()->new RuntimeException("Usuário não existe com o nome "
                                +loginRequest.username())
                );
        if(!passwordEncoder.matches(loginRequest.password(),usuario.getPassword())){
            throw new RuntimeException("Senha errada para usuario com nome "
                    + loginRequest.username());
        }
        return usuario;
    }


}
