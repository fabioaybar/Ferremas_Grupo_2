package com.api.crud.ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VentasService {

    HashMap<String, Object> datos;

    private final VentasRepository ventasRepository;

    @Autowired
    public VentasService(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    public List<Ventas> getVentas() {
        return this.ventasRepository.findAll();
    }

    public ResponseEntity<Object> newVentas(Ventas ventas) {
        datos = new HashMap<>();

      //  Optional<Ventas> res = ventasRepository.findByIdClienteAndFecha(ventas.getIdCliente(), ventas.getFechaEntrega());

       /*  if (res.isPresent() && ventas.getId() == null) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "DESPACHO YA EXISTE PARA ESTE CLIENTE Y FECHA");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }*/

        if (ventas.getId() != null) {
            datos.put("MESSAGE", "ACTUALIZADO");
        }

        ventasRepository.save(ventas);
        datos.put("data", ventas);
        datos.put("MESSAGE", "Se guardó con éxito");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateVentas(Ventas ventas) {
        datos = new HashMap<>();

        if (!ventasRepository.existsById(ventas.getId())) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "DESPACHO NO EXISTE");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }

        ventasRepository.save(ventas);
        datos.put("data", ventas);
        datos.put("MESSAGE", "ACTUALIZADO CON ÉXITO");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteVentas(Long id) {
        datos = new HashMap<>();

        boolean existe = this.ventasRepository.existsById(id);
        if (!existe) {
            datos.put("ERROR", true);
            datos.put("MESSAGE", "ESTE PRODUCTO NO EXISTE");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        }

        ventasRepository.deleteById(id);
        datos.put("data", "venta eliminado");
        return new ResponseEntity<>(datos, HttpStatus.ACCEPTED);
    }
}

