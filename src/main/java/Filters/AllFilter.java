package Filters;

import model.User;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/*")
public class AllFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession httpSession = request.getSession();
        servletRequest.setCharacterEncoding("UTF-8");

        if (httpSession.getAttribute("user") == null) {
            Cookie[] cookies = request.getCookies();
            String username = null;
            String userId = null;
            int counter = 0;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("saved")) {
                        username = cookie.getValue();
                        counter++;
                    }
                    if (cookie.getName().equals("user_id")) {
                        userId = cookie.getValue();
                        counter++;
                    }
                    if (counter == 2) {
                        break;
                    }
                }
            }

            if (username != null && userId != null) {
                UserRepository userDB = new UserRepositoryImpl();
                User user = userDB.getUserByName(username);
                if (user != null) {
                    if (user.getId() == Integer.parseInt(userId)) {
                        httpSession.setAttribute("username", user.getUsername());
                        httpSession.setAttribute("buttonValue", user.getUsername());
                        httpSession.setAttribute("user_id", user.getId());
                    }
                }
            } else {
                String buttonValue = (String) httpSession.getAttribute("buttonValue");
                httpSession.setAttribute("buttonValue", Objects.requireNonNullElse(buttonValue, "Войти"));
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
