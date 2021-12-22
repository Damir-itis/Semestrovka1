package Servlets;

import repositories.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/signInPage")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cookieCheck = req.getParameter("radio");
        HttpSession session = req.getSession();

        UserRepositoryImpl users = new UserRepositoryImpl();

        if(username.equals("") || password.equals("")) {
            req.getServletContext().getRequestDispatcher("/signInPage.html").forward(req, resp);
        } else {
            if (users.userIsExist(username, password)) {
                int int_helper = users.getUserId(username);
                if (int_helper != Integer.MIN_VALUE) {
                    session.setAttribute("user_id", int_helper);
                }
                HelpServicesForServlet.saveCookies(resp, username, cookieCheck, int_helper);
                session.setAttribute("buttonValue", username);
                session.setAttribute("username", username);
                resp.sendRedirect("/homePage");
            } else {
                resp.sendRedirect("/ErrorSignInPage");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/signInPage.html").forward(req, resp);
    }

}
