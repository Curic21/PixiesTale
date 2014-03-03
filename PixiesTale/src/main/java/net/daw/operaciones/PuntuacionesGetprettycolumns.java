/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author al037342
 */
public class PuntuacionesGetprettycolumns implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String data = "{\"data\": [\"Nombre\", \"Score\", \"Date\"]}";
            return data;
        } catch (Exception e) {
            throw new ServletException("PuntuacionesGetpagesJson: View Error: " + e.getMessage());
        }
    }
}
