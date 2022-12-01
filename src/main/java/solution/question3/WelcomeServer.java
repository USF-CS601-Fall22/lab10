package solution.question3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import solution.question3.WelcomeServlet;

public class WelcomeServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(WelcomeServlet.class, "/welcome");
        server.setHandler(handler);

        server.start();
        server.join();
    }

}
