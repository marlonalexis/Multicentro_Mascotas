/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mplua
 */
@Entity
@Table(name = "opciones")
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Integer idOpcion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "accion")
    private String accion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "opcion")
    private String opcion;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "modulo_padre", nullable = false)
    @ManyToOne
    private Opciones moduloPadre;

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Opciones getModuloPadre() {
        return moduloPadre;
    }

    public void setModuloPadre(Opciones moduloPadre) {
        this.moduloPadre = moduloPadre;
    }
    
}
