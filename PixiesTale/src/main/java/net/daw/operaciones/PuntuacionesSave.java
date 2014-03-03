/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.PuntuacionesBean;
import net.daw.dao.PuntuacionesDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;

/**
 *
 * @author al037342
 */
public class PuntuacionesSave implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            PuntuacionesDao oPuntuacionesDAO = new PuntuacionesDao(Conexion.getConection());
            PuntuacionesBean oPuntuaciones = new PuntuacionesBean();
            Gson gson=  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oPuntuaciones = gson.fromJson(jason, oPuntuaciones.getClass());
            Map<String, String> data = new HashMap<>();
            if (oPuntuaciones != null) {
                oPuntuacionesDAO.set(oPuntuaciones);
                data.put("status", "200");
                data.put("message", Integer.toString(oPuntuaciones.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("PuntuacionesSaveJson: View Error: " + e.getMessage());
        }
    }
}

