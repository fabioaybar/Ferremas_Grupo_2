package com.api.crud.despacho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DespachoService {

    HashMap<String, Object> datos;

    private final DespachoRepository despachoRepository;

    @Autowired
    public DespachoService(DespachoRepository despachoRepository) {
        this.despachoRepository = despachoRepository;
    }

    public List<Despacho> getDespacho() {
        return this.despachoRepository.findAll();
    }

    public ResponseEntity<Object> newDespacho(Despacho despacho) {
        datos = new HashMap<>();

        Optional<Despacho> res = despachoRepository.findByIdClienteAndFechaEntrega(despacho.getIdCliente(), despacho.getFechaEntrega());

      /*  if (res.isPresent() && despacho.getId() == null) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "DESPACHO YA EXISTE PARA ESTE CLIENTE Y FECHA");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }*/

        if (despacho.getId() != null) {
            datos.put("MESSAGE", "ACTUALIZADO");
        }

        despachoRepository.save(despacho);
        datos.put("data", despacho);
        datos.put("MESSAGE", "Se guardó con éxito");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateDespacho(Despacho despacho) {
        datos = new HashMap<>();

        if (!despachoRepository.existsById(despacho.getId())) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "DESPACHO NO EXISTE");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        despachoRepository.save(despacho);
        datos.put("data", despacho);
        datos.put("MESSAGE", "ACTUALIZADO CON ÉXITO");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteDespacho(Long id) {
        datos = new HashMap<>();

        boolean existe = this.despachoRepository.existsById(id);
        if (!existe) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "ESTE PRODUCTO NO EXISTE");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        despachoRepository.deleteById(id);
        datos.put("data", "despacho eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}

