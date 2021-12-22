package Servlets;

import model.User;
import repositories.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profilePage")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            UserRepositoryImpl dataBase = new UserRepositoryImpl();

            String username = (String) session.getAttribute("username");
            User user = dataBase.getUserByName(username);
            session.setAttribute("createDateTime", user.getCreateDateTime());

            req.getServletContext().getRequestDispatcher("/profilePage.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/homePage");
        }
    }

}
