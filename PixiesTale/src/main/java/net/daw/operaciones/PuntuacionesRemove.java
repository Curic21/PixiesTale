/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
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
public class PuntuacionesRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            PuntuacionesDao oPuntuacionesDAO = new PuntuacionesDao(Conexion.getConection());
            PuntuacionesBean oPuntuaciones = new PuntuacionesBean();                                           
            oPuntuaciones.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oPuntuaciones != null) {
                oPuntuacionesDAO.remove(oPuntuaciones);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oPuntuaciones.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("PuntuacionesRemoveJson: View Error: " + e.getMessage());
        }
    }
}