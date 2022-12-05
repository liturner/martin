package de.turnertech.martin;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Application {

    private static final Logger log = Logger.getLogger("turnertech.martin");

    public static void main(String[] args) {
        final Server jettyServer = new Server();

        HttpConfiguration httpConfig = new HttpConfiguration();
        try (ServerConnector http = new ServerConnector(jettyServer, new HttpConnectionFactory(httpConfig))) {
            http.setPort(Integer.getInteger("jetty.port", 8080));
            http.setAcceptQueueSize(100);
            http.setIdleTimeout(1000 * 60 * 60);
            jettyServer.setConnectors(new Connector[] {http});

            jettyServer.start();
            log.info("GeoServer startup complete");

        } catch (Exception e) {
            log.log(Level.SEVERE, e, () -> "Could not start the Jetty server: " + e.getMessage());
            try {
                jettyServer.stop();
            } catch (Exception e1) {
                log.log(Level.SEVERE, e1, () -> "Unable to stop the " + "Jetty server:" + e1.getMessage());
            }
        }
    }
}
