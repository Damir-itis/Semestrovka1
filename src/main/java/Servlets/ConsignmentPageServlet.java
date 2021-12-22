package Servlets;

import model.Comment;
import repositories.CommentRepository;
import repositories.CommentRepositoryImpl;
import model.Consignment;
import repositories.ConsignmentRepository;
import repositories.ConsignmentRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ConsignmentPage")
public class ConsignmentPageServlet extends HttpServlet {

    private final CommentRepository commentDB = new CommentRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        int id = (int) session.getAttribute("lastIdPage");
        String username = (String) session.getAttribute("username");
        String text = req.getParameter("comment");

        if (username != null && session.getAttribute("user_id") != null) {
            int user_id = (int) session.getAttribute("user_id");
            if (!text.equals("")) {
                if (commentDB.saveComment(text, username, id, user_id)) {
                    resp.sendRedirect("/ConsignmentPage?id=" + id);
                }
            }
        } else {
            resp.sendRedirect("/signInPage");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        List<Comment> comments = commentDB.getListCommentsByConsignmentsId(id);

        ConsignmentRepository consignmentDB = new ConsignmentRepositoryImpl();
        Consignment consignment = consignmentDB.getConsignmentById(id);

        req.setAttribute("comments", comments);
        req.setAttribute("name", consignment.getName());
        req.setAttribute("consignmentDescription", consignment.getText());
        req.setAttribute("leaderPicture", consignment.getLeaderImage());
        req.setAttribute("consignmentPicture", consignment.getImage());

        HttpSession session = req.getSession();
        session.setAttribute("lastIdPage", id);

        req.getServletContext().getRequestDispatcher("/ConsignmentPage.jsp").forward(req, resp);
    }
}
