/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.controller;

import com.desarrollo.multicentro_mascotas.dominio.Menu;
import com.desarrollo.multicentro_mascotas.dominio.Usuarios;
import com.desarrollo.multicentro_mascotas.ebj.MenuFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author mpluas
 */
@Named
@SessionScoped
public class menuController implements Serializable{
    
    @EJB
    private MenuFacadeLocal MenuEJB;
    private List<Menu> lista;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        this.listarMenu();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }
    public void listarMenu(){
        try {
            lista = MenuEJB.findAll();
        } catch (Exception e) {
            //mensaje jsf
        }   
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    
    public void establecerPermisos(){
        Usuarios usu = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuarios");
        
        DefaultMenuItem menItm = new DefaultMenuItem("Principal");
        menItm.setIcon("icon-home-outline");
        menItm.setTitle("Pagina Principal");
        menItm.setOutcome("/principal/principal");
        menItm.setPartialSubmit(true);
        menItm.setProcess("@this");
        menItm.setContainerStyleClass("layout-menubar-active");
        model.addElement(menItm);
        for (Menu m : lista) {
            System.out.println("rol " + usu.getIdRol().getIdRol());
            System.out.println("rol " + m.getIdRol().getIdRol());
            if (m.getTipo().equals("S") && m.getIdRol().getIdRol().equals(usu.getIdRol().getIdRol())) {
                DefaultSubMenu firsSubMenu = new DefaultSubMenu(m.getOpcion());
                firsSubMenu.setIcon(m.getRutaImagen());
                for (Menu i : lista) {
                    Menu submenu = i.getMenuPadre();
                    if (submenu != null) {
                        if (submenu.getIdMenu() == m.getIdMenu()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getOpcion());
                            item.setIcon(i.getRutaImagen());
                            firsSubMenu.addElement(item);
                        }
                    }
                }
                model.addElement(firsSubMenu);
            }else{
                if (m.getMenuPadre() == null && m.getIdRol().getIdRol().equals(usu.getIdRol().getIdRol())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getOpcion());
                    item.setIcon(m.getRutaImagen());
                    model.addElement(item);
                }

            }
        }
    }
}
