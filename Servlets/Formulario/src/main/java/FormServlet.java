import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/registro")

public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       String email = req.getParameter("email");
       String pais = req.getParameter("pais");
       Map<String, String> errores = new HashMap<String, String>();
       if (username == null || username.isEmpty()) {
           errores.put("username", "Debe ingresar un usuario válido");
       }
       if (password == null || password.isEmpty()) {
           errores.put("password", "Debe ingresar una contraseña válida");
       }
       if (email == null || email.isEmpty() || !email.contains("@")) {

           errores.put("email", "Debe ingresar un email válido");
       }
       if (pais == null || pais.isEmpty() || pais.equals("") || pais.equals(" ")) {
           errores.put("pais", "Debe seleccionar un país de la lista");
       }
    }
}
