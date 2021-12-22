package Servlets;

import repositories.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signUpPage")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("radio");
        HttpSession session = req.getSession();

        UserRepositoryImpl dataBase = new UserRepositoryImpl();
        if (dataBase.userIsExist(username, password)) {
            resp.sendRedirect("/ErrorSignInPage");
        } else {
            if (dataBase.saveUser(username, password)) {
                session.setAttribute("username", username);
                int int_helper = dataBase.getUserId("username");
                if (int_helper != Integer.MIN_VALUE) {
                    session.setAttribute("user_id", int_helper);
                }
                int_helper = dataBase.getUserId(username);
                if (int_helper != Integer.MIN_VALUE) {
                    session.setAttribute("user_id", int_helper);
                }
                session.setAttribute("buttonValue", username);
                HelpServicesForServlet.saveCookies(resp, username, cookieCheck, int_helper);
                resp.sendRedirect("/homePage");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/signUpPage.html").forward(req, resp);
    }

}
