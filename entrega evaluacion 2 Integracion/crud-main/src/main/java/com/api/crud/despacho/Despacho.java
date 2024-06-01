package com.api.crud.despacho;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Despacho {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;
    @Column
    private Long idCliente;
    private String direccion;
    private LocalDate fechaEntrega;
    private Long idProducto;
    private int cantidad;
    private float totalNeto;
    private float iva;
    private float total;

    public Despacho() {
    }

    public Despacho(Long id, Long idCliente, String direccion, LocalDate fechaEntrega, Long idProducto, int cantidad, float totalNeto, float iva, float total) {
        this.id = id;
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.fechaEntrega = fechaEntrega;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
    }

    public Despacho(Long idCliente, String direccion, LocalDate fechaEntrega, Long idProducto, int cantidad, float totalNeto, float iva, float total) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.fechaEntrega = fechaEntrega;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(float totalNeto) {
        this.totalNeto = totalNeto;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
