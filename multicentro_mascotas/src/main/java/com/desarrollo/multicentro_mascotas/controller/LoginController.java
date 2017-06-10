/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.controller;

import com.desarrollo.multicentro_mascotas.configuracion.UtilCryptography;
import com.desarrollo.multicentro_mascotas.dominio.Usuarios;
import com.desarrollo.multicentro_mascotas.ebj.UsuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author mpluas
 */
@ManagedBean(name = "loginFinal")
@ViewScoped
public class LoginController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //Con inject no hay necesidad de declarar en el init
    @Inject
    private Usuarios usuarios;
    @Inject
    private Usuarios usu;
    
    @EJB
    private UsuariosFacadeLocal  usuarioEBJ;
    
    @PostConstruct
    protected void init() {
        //usuarios = new Usuarios();
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUsu() {
        return usu;
    }

    public void setUsu(Usuarios usu) {
        this.usu = usu;
    }

    public UsuariosFacadeLocal getUsuarioEBJ() {
        return usuarioEBJ;
    }

    public void setUsuarioEBJ(UsuariosFacadeLocal usuarioEBJ) {
        this.usuarioEBJ = usuarioEBJ;
    }

    public String autenticar() {
        String redireccion = null;
        try {
            usu = usuarioEBJ.autenticar(usuarios);
            if (usu != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuarios", usu);
                redireccion = "/principal/principal?faces-redirect=true";
            }else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "USUARIO/CLAVE Invalidos")); 
            } 
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }
       
    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }  
}
