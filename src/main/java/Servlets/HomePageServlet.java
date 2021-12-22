package Servlets;

import model.News;
import repositories.NewsRepository;
import repositories.NewsRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/homePage")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsRepository newsDB = new NewsRepositoryImpl();
        List<News> news;
        if (req.getParameter("id") == null) {
            news= newsDB.getAllNews();
        } else {
            news = newsDB.getNewsByConsignmentId(Integer.parseInt(req.getParameter("id")));
        }


        req.setAttribute("news", news);
        req.getServletContext().getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }

}
