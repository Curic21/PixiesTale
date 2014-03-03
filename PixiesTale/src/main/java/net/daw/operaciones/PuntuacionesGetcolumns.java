/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.dao.PuntuacionesDao;
import net.daw.helper.Conexion;

/**
 *
 * @author al037342
 */
public class PuntuacionesGetcolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<String> alColumns = null;
        try {
            PuntuacionesDao oPuntuacionesDAO = new PuntuacionesDao(Conexion.getConection());
            alColumns = oPuntuacionesDAO.getColumnsNames();
            String data = new Gson().toJson(alColumns);
            data = "{\"data\":" + data + "}";
            return data;
        } catch (Exception e) {
            throw new ServletException("PuntuacionesGetcolumnsJson: View Error: " + e.getMessage());
        }
    }
}
