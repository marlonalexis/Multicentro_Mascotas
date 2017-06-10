/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.controller;

import com.desarrollo.multicentro_mascotas.dominio.Usuarios;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mplua
 */
@ManagedBean(name = "plantillaMB")
@ViewScoped
public class PlantillaController implements Serializable{
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuarios usu = (Usuarios) context.getExternalContext().getSessionMap().get("Usuarios");
            if (usu == null) {
                context.getExternalContext().redirect("./../principal/permisos.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
