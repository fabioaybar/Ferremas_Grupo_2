package com.api.crud.despacho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Long> {
    // Ejemplo de método de consulta adicional
    Optional<Despacho> findByIdClienteAndFechaEntrega(Long idCliente, LocalDate fechaEntrega);
}

