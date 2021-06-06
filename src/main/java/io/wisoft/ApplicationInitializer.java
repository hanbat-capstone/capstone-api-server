package io.wisoft;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ApplicationInitializer {
  public static void main(String[] args) {
    final ServletContextHandler context =
      new ServletContextHandler(ServletContextHandler.NO_SESSIONS); //세션정보를 가지고 있지 않기때문에
    context.setContextPath("/");

    final ResourceConfig resourceConfig = new ResourceConfig();
    resourceConfig.packages(ApplicationInitializer.class.getName());

    final Server server = new Server(8080);
    server.setHandler(context);

    final ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
    servletHolder.setInitOrder(1);
    servletHolder.setInitParameter("jersey.config.server.provider.packages", "io.wisoft");

    try{
      server.start();
      server.join();
    }catch (final Exception ex){
      System.err.println("Exception: "+ex);
    }finally {
      server.destroy();
    }
  }
}
