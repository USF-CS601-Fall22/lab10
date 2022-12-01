package solution.question2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class WelcomeServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new Server(PORT);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(WelcomeServlet.class, "/welcome");
        server.setHandler(handler);

        server.start();
        server.join();
    }

}
