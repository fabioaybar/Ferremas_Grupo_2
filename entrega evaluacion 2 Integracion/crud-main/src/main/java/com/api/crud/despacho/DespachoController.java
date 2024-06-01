package com.api.crud.despacho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/despachos")
public class DespachoController {
    private final DespachoService despachoService;

    @Autowired
    public DespachoController(DespachoService despachoService) {
        this.despachoService = despachoService;
    }

    @GetMapping
    public List<Despacho> getDespachos() {
        return despachoService.getDespacho();
    }

    @PostMapping
    public ResponseEntity<Object> registrarDespachado(@RequestBody Despacho despacho) {
        return this.despachoService.newDespacho(despacho);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarDespachado(@RequestBody Despacho despacho) {
        return this.despachoService.newDespacho(despacho);
    }

    @DeleteMapping(path = "{despachoId}")
    public ResponseEntity<Object> eliminar(@PathVariable("despachoId") Long id) {
        return this.despachoService.deleteDespacho(id);
    }
}
