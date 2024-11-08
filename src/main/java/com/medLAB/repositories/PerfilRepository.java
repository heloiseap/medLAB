package com.medLAB.repositories;

import com.medLAB.entities.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity,Long> {
    Optional<PerfilEntity> findByNomePerfil(String nomePerfil);
}
