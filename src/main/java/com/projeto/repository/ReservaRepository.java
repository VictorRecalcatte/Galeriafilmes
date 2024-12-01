package com.projeto.repository;

import com.projeto.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    @Query("SELECT r FROM Reserva r WHERE r.id_usuario = :idUsuario")
    List<Reserva> findByIdUsuario(@Param("idUsuario") Long idUsuario);
}
