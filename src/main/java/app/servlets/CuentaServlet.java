package app.servlets;

import app.models.CuentaBancaria;
import app.models.FormException;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/transferencia"})
public class CuentaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CuentaBancaria.cuentas.isEmpty()) {
            CuentaBancaria.setCuentas();
            req.setAttribute("cuentas", CuentaBancaria.getCuentas());
        } else {
            req.setAttribute("cuentas", CuentaBancaria.getCuentas());
        }
        req.getRequestDispatcher("/WEB-INF/views/transferencia/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CuentaBancaria cuenta = new CuentaBancaria();
        try {
            Map<String, String[]> parametros = req.getParameterMap();
            cuenta.transferir(parametros);
            req.setAttribute("origen", parametros.get("origen")[0]);
            req.setAttribute("destino", parametros.get("destino")[0]);
            req.setAttribute("monto", parametros.get("monto")[0]);
            
            req.getRequestDispatcher("/WEB-INF/views/transferencia/deposito.jsp").forward(req, resp);
        } catch (FormException e) {
            req.setAttribute("errores", cuenta.getErrores());
            req.getRequestDispatcher("/WEB-INF/views/errores.jsp").forward(req, resp);
        }
    }

}
