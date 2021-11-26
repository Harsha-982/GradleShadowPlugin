
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Server server =new Server(8080);

        /* working perfect with 8080

        ServletHandler  servletHandler=new ServletHandler();
        servletHandler.addServletWithMapping(HelloWorld.class,"/*" );
        server.setHandler(servletHandler);

        */

        WebAppContext context=new WebAppContext();
        context.setContextPath("/");
        URL url=MainClass.class.getClassLoader().getResource("META-INF/resources");
        context.setResourceBase(url.toURI().toString());
        server.setHandler(context);

        Configuration.ClassList classList=new Configuration.ClassList();
        Configuration.ClassList classList1 =classList.setServerDefault(server);

        classList1.addBefore("org.eclipse.jetty.webapp.WebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");

        System.out.println("Main Class");

        server.start();
        server.join();
    }
}
