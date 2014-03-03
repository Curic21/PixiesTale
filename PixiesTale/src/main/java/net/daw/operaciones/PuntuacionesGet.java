/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.PuntuacionesBean;
import net.daw.dao.PuntuacionesDao;
import net.daw.helper.Conexion;

/**
 *
 * @author al037342
 */
public class PuntuacionesGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                PuntuacionesDao oPuntuacionesDAO = new PuntuacionesDao(Conexion.getConection());
                PuntuacionesBean oPuntuaciones = new PuntuacionesBean();
                oPuntuaciones.setId(Integer.parseInt(request.getParameter("id")));
                oPuntuacionesDAO.get(oPuntuaciones);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oPuntuaciones);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("PuntuacionesGetJson: View Error: " + e.getMessage());
        }
    }
    
}
