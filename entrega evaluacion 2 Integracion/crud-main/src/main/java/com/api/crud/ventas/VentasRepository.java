package com.api.crud.ventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
    // Ejemplo de método de consulta adicional
    Optional<Ventas> findByIdClienteAndFecha(Long idCliente, LocalDate fecha);
}

