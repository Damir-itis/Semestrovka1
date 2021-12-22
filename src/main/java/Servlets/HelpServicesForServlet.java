package Servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class HelpServicesForServlet {

    static void saveCookies(HttpServletResponse resp, String username, String cookieCheck, int int_helper) {
        if (cookieCheck != null && cookieCheck.equals("true")) {
            Cookie cookie = new Cookie("saved", username);
            cookie.setMaxAge(100);
            resp.addCookie(cookie);
            cookie = new Cookie("user_id", Integer.toString(int_helper));
            cookie.setMaxAge(100);
            resp.addCookie(cookie);
        }
    }
}
