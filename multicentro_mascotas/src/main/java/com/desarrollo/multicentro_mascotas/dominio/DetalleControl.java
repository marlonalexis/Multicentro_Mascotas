/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.dominio;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mplua
 */
@Entity
@Table(name = "detalle_control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleControl.findAll", query = "SELECT d FROM DetalleControl d")
    , @NamedQuery(name = "DetalleControl.findByIdDetontrol", query = "SELECT d FROM DetalleControl d WHERE d.idDetontrol = :idDetontrol")
    , @NamedQuery(name = "DetalleControl.findByDiagnostico", query = "SELECT d FROM DetalleControl d WHERE d.diagnostico = :diagnostico")
    , @NamedQuery(name = "DetalleControl.findByFechaRegistro", query = "SELECT d FROM DetalleControl d WHERE d.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "DetalleControl.findByDetalleReceta", query = "SELECT d FROM DetalleControl d WHERE d.detalleReceta = :detalleReceta")
    , @NamedQuery(name = "DetalleControl.findByServicios", query = "SELECT d FROM DetalleControl d WHERE d.servicios = :servicios")})
public class DetalleControl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detontrol")
    private Integer idDetontrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "detalle_receta")
    private String detalleReceta;
    @Size(max = 255)
    @Column(name = "servicios")
    private String servicios;
    @JoinColumn(name = "id_control", referencedColumnName = "id_control")
    @ManyToOne(optional = false)
    private Control idControl;

    public DetalleControl() {
    }

    public DetalleControl(Integer idDetontrol) {
        this.idDetontrol = idDetontrol;
    }

    public DetalleControl(Integer idDetontrol, String diagnostico, Date fechaRegistro, String detalleReceta) {
        this.idDetontrol = idDetontrol;
        this.diagnostico = diagnostico;
        this.fechaRegistro = fechaRegistro;
        this.detalleReceta = detalleReceta;
    }

    public Integer getIdDetontrol() {
        return idDetontrol;
    }

    public void setIdDetontrol(Integer idDetontrol) {
        this.idDetontrol = idDetontrol;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDetalleReceta() {
        return detalleReceta;
    }

    public void setDetalleReceta(String detalleReceta) {
        this.detalleReceta = detalleReceta;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public Control getIdControl() {
        return idControl;
    }

    public void setIdControl(Control idControl) {
        this.idControl = idControl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetontrol != null ? idDetontrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleControl)) {
            return false;
        }
        DetalleControl other = (DetalleControl) object;
        if ((this.idDetontrol == null && other.idDetontrol != null) || (this.idDetontrol != null && !this.idDetontrol.equals(other.idDetontrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.desarrollo.multicentro_mascotas.dominio.DetalleControl[ idDetontrol=" + idDetontrol + " ]";
    }
    
}
