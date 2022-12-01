package solution.question4;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(HttpServletResponse.SC_OK);
        out.println("<html>");
        out.println("<body>");

        // Get the session, and check for the "name" attribute of the session
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        // System.out.println(name);
        if (name != null) {
            out.println("Welcome, " + name);
            out.println("</body>");
            out.println("</html>");
        }
        else {
           // Show the form
            out.println("<p>Please fill out this form </p>");
            out.println("<form action = \"welcome\" method = \"post\">");
            out.println("<input type = \"text\" name = \"name\">");
            out.println("<input type = \"submit\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
       String name = request.getParameter("name");
       System.out.println("doPost" + name);
       String cleanName = StringEscapeUtils.escapeHtml4(name);
       HttpSession session = request.getSession();
       session.setAttribute("name", cleanName);

       // Store the name in the database
       SimpleDatabaseHandler dbHandler = SimpleDatabaseHandler.getInstance();
       dbHandler.storeNameInDatabase(cleanName);
       response.sendRedirect(request.getServletPath());
    } // doPost
} // WelcomeServlet class
