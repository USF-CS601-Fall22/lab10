package question2;

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
        out.println("<html>");
        out.println("<body>");
        boolean foundCookie = false;
        // FILL IN CODE: search for the name cookie
        if (foundCookie) {
            // FILL IN CODE
        }
       else {
           // Show the form
            out.println("<p>Please fill out this form </p>");
            out.println("<form >"); // Add attributes to the form
            out.println("<input type = \"text\" "); // modify as needed
            // Add a button too

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
       // FILL IN CODE to process the form

    } // doPost
} // WelcomeServlet class
