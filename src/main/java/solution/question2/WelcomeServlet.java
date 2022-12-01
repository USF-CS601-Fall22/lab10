package solution.question2;

import org.apache.commons.text.StringEscapeUtils;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);

        out.println("<html>");
        out.println("<body>");

        Cookie[] cookies = request.getCookies();
        String name = null;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("name")) {
                    name = c.getValue();
                    //System.out.println("Found cookie: " + name);
                    out.println("Welcome, " + name);
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
            }
        }
        out.println("<p>Please fill out this form </p>");
        out.println("<form action = \"welcome\" method = \"post\">");
        out.println("<input type = \"text\" name = \"name\">");
        out.println("<input type = \"submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        String name = request.getParameter("name");
        String cleanName = StringEscapeUtils.escapeHtml4(name);

        response.addCookie(new Cookie("name", cleanName));
        response.setStatus(HttpServletResponse.SC_OK);

        response.sendRedirect(request.getServletPath());
    } // doPost
} // WelcomeServlet class
