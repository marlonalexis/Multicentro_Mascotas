/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.ebj;

import com.desarrollo.multicentro_mascotas.dominio.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mpluas
 * Interfaz para poder acceder a los metodos.
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios autenticar(Usuarios usu);
}
