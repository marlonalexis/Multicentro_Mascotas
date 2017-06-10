/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mplua
 */
@Entity
@Table(name = "opciones_roles")
public class OpcionesRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcionRol")
    private Integer idopcionRol;
    @Column(name = "estado")
    private String estado;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_opcion", nullable = false)
    @ManyToOne
    private Opciones idOpcion;
    @JoinColumn(name = "id_rol", nullable = false)
    @ManyToOne
    private Rol idRol;

    public Integer getIdopcionRol() {
        return idopcionRol;
    }

    public void setIdopcionRol(Integer idopcionRol) {
        this.idopcionRol = idopcionRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Opciones getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Opciones idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

}
