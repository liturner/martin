

# Way of Working

**Download everything you need locally.**

Geoserver is ver techy, and very open source. They are not in the business of managing brilliant instructions online. If you will be working with Geoserver, the first thing you should do is to download the runtime, source, javadoc and manual all to a folder on your PC. Not to work with, but rather to use as reference while you work. The Java API is not well documented online, you will have to figure it out yourself.

# Useful Links

## Javadoc

The Javadoc is available as a zip to download alongside each release. For example [the 2.22 download page here](https://geoserver.org/release/2.22.0/).

# Crumb Trail for Starting Out

1. \src\web\app\src\main\webapp\WEB-INF\web.xml -> The listeners point to some classes which appear to be the main software
      org.geoserver.GeoserverInitStartupListener
      org.geoserver.logging.LoggingStartupContextListener
      org.geoserver.platform.GeoServerContextLoaderListener
      org.geoserver.platform.GeoServerHttpSessionListenerProxy
      org.springframework.web.context.request.RequestContextListener

2. gs-wfs seems to be the actuall implementation of WFS. \src\wfs\src\main\java\org\geoserver\wfs\WebFeatureService.java should be a good place to trace back from

3. Following Classes seem to be core elements:
      org.geoserver.catalog.Catalog; (Holds all the data)
      org.geoserver.config.GeoServer; (Geoserver Configuration)

4. From WFSTestSupport.java
    protected WFSInfo getWFS() {
        return getGeoServer().getService(WFSInfo.class);
    }

5. **IMPORTANT** https://stackoverflow.com/questions/30825612/geoserver-develop-or-use-how-can-i-integrate-with-geoserver 

6. **IMPORTANT** Check out GeoTools. It is mentioned as a good way to have a data backend

7. Nice hint about Catalog here: https://docs.geotools.org/latest/userguide/welcome/geoserver.html

8. Geotools / WebCahche here: https://docs.geoserver.org/stable/en/developer/quickstart/intellij.html

# Dependency Layers

gs-web-app (we dont want this, or we want to minimize it)

gs-wfs (This could be the servlet we need!!!!!)

gs-main (this seems to be the core Java stuff)

gs-ows, gs-platform

# Our Contribution

- https://stackoverflow.com/questions/74688117/how-can-i-run-geoserver-without-the-web-frontend