import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/get")

public class ParametrosGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // declaración de variables.
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");
        //declaración de flujo
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("            <title>Parámetros</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("   <h3>Saludo: " + saludo + "</h3>");
        out.println("   <h3> " + nombre +"</h3>");
        out.println("   </body>");
        out.println("</html>");
        out.close();

    }
}
