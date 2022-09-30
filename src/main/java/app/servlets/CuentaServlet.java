
package app.servlets;

import app.models.CuentaBancaria;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/transferencia"})
public class CuentaServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        
        req.setAttribute("cuentas", CuentaBancaria.getCuentas());
        req.getRequestDispatcher("/WEB-INF/views/transferencia/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
             Map<String, String[]> parametros = req.getParameterMap();
             CuentaBancaria.transferir(parametros);
             req.setAttribute("origen", req.getAttribute("origen"));
             req.setAttribute("destino", req.getAttribute("destino"));
             req.setAttribute("origen", req.getAttribute("monto"));
             req.setAttribute("parametros", parametros);
             req.getRequestDispatcher("/WEB-INF/views/transferencia/deposito.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("/WEB-INF/views/transferencia/index.jsp").forward(req, resp);
        }
    }
    
    
    
}
