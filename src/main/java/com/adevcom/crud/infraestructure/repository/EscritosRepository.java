package com.adevcom.crud.infraestructure.repository;

import com.adevcom.crud.infraestructure.persistence.EscritosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscritosRepository extends JpaRepository<EscritosEntity, Long> {
}
