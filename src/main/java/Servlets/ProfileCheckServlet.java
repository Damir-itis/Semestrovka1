package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ProfileServlet")
public class ProfileCheckServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            response.sendRedirect("/profilePage");
            return;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("saved")) {
                session.setAttribute("username", cookie.getValue());
                session.setAttribute("buttonValue", cookie.getValue());
                response.sendRedirect("/profilePage");
            }
        }

        response.sendRedirect("/signInPage");
    }
}
