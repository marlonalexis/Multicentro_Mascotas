/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.ebj;

import com.desarrollo.multicentro_mascotas.configuracion.UtilCryptography;
import com.desarrollo.multicentro_mascotas.dominio.Usuarios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mpluas
 * Uso de Stateless es recomendable en los EJB, Invoca a la unidad de persistencia.(DB)
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "multicentro_mascotas")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios autenticar(Usuarios usu){
        Usuarios usuarios = null;
        String consulta;
        try {
            consulta = "FROM Usuarios u WHERE u.username = ?1 AND u.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usu.getUsername());
            query.setParameter(2, UtilCryptography.encriptar(usu.getPassword()));
            System.out.println("contra"+UtilCryptography.encriptar(usu.getPassword()));
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuarios = lista.get(0);
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(UsuariosFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }
}
