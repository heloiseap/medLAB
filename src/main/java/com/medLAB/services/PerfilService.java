package com.medLAB.services;

import com.medLAB.dtos.PerfilRequest;
import com.medLAB.entities.PerfilEntity;
import com.medLAB.repositories.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfilService {
    private final PerfilRepository repository;

    public void cadastrarPerfil(PerfilRequest perfilRequest) {
        if (repository.findByNomePerfil(perfilRequest.nomePerfil()).isPresent()){
            //todo error
        }
            PerfilEntity perfil = new PerfilEntity();
            perfil.setNomePerfil(perfilRequest.nomePerfil());
            repository.save(perfil);
        }

        public PerfilEntity validarPerfil(String nomePerfil){
            PerfilEntity perfil = repository.findByNomePerfil(nomePerfil).get();
            return perfil;
        }
}
