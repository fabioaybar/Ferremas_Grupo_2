package com.api.crud.ventas;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Ventas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;
    @Column
    private Long idCliente;
    private String condicion_de_pago ;
    private LocalDate fecha;
    private Long idProducto;
    private int cantidad;
    private float totalNeto;
    private float iva;
    private float total;

    public Ventas() {
    }

    public Ventas(Long id, Long idCliente, String condicion_de_pago , LocalDate fecha, Long idProducto, int cantidad, float totalNeto, float iva, float total) {
        this.id = id;
        this.idCliente = idCliente;
        this.condicion_de_pago  = condicion_de_pago ;
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
    }

    public Ventas(Long idCliente, String condicion_de_pago , LocalDate fecha, Long idProducto, int cantidad, float totalNeto, float iva, float total) {
        this.idCliente = idCliente;
        this.condicion_de_pago  = condicion_de_pago ;
        this.fecha = fecha;
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
        return condicion_de_pago ;
    }

    public void setDireccion(String condicion_de_pago ) {
        this.condicion_de_pago  = condicion_de_pago ;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
