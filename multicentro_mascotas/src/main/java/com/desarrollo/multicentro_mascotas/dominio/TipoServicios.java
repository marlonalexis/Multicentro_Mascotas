/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mplua
 */
@Entity
@Table(name = "tipo_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicios.findAll", query = "SELECT t FROM TipoServicios t")
    , @NamedQuery(name = "TipoServicios.findByIdtipoServicio", query = "SELECT t FROM TipoServicios t WHERE t.idtipoServicio = :idtipoServicio")
    , @NamedQuery(name = "TipoServicios.findByDescripcion", query = "SELECT t FROM TipoServicios t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoServicios.findByEstado", query = "SELECT t FROM TipoServicios t WHERE t.estado = :estado")})
public class TipoServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipoServicio")
    private Integer idtipoServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoServicio")
    private List<Servicios> serviciosList;

    public TipoServicios() {
    }

    public TipoServicios(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public TipoServicios(Integer idtipoServicio, String descripcion, String estado) {
        this.idtipoServicio = idtipoServicio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdtipoServicio() {
        return idtipoServicio;
    }

    public void setIdtipoServicio(Integer idtipoServicio) {
        this.idtipoServicio = idtipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Servicios> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(List<Servicios> serviciosList) {
        this.serviciosList = serviciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoServicio != null ? idtipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicios)) {
            return false;
        }
        TipoServicios other = (TipoServicios) object;
        if ((this.idtipoServicio == null && other.idtipoServicio != null) || (this.idtipoServicio != null && !this.idtipoServicio.equals(other.idtipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.desarrollo.multicentro_mascotas.dominio.TipoServicios[ idtipoServicio=" + idtipoServicio + " ]";
    }
    
}
