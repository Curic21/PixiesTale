/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.PuntuacionesBean;
import net.daw.helper.Conexion;

/**
 *
 * @author al037342
 */
public class PuntuacionesDao extends GenericDaoImplementation<PuntuacionesBean> {

    public PuntuacionesDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "puntuaciones");
    }

}
