

# Way of Working

**Download everything you need locally.**

Geoserver is ver techy, and very open source. They are not in the business of managing brilliant instructions online. If you will be working with Geoserver, the first thing you should do is to download the runtime, source, javadoc and manual all to a folder on your PC. Not to work with, but rather to use as reference while you work. The Java API is not well documented online, you will have to figure it out yourself.

# Useful Links

## Javadoc

The Javadoc is available as a zip to download alongside each release. For example [the 2.22 download page here](https://geoserver.org/release/2.22.0/).

# Crumb Trail for Starting Out

1. \src\web\app\src\main\webapp\WEB-INF\web.xml -> The listeners point to some classes which appear to be the main software
2. <!-- general initializer, should be first thing to execute -->
    <listener>
      <listener-class>org.geoserver.GeoserverInitStartupListener</listener-class>
    </listener>
    
    <!-- logging initializer, should execute before spring context startup -->
    <listener>
      <listener-class>org.geoserver.logging.LoggingStartupContextListener</listener-class>
    </listener>
  
    <!--  spring context loader -->
    <listener>
      <listener-class>org.geoserver.platform.GeoServerContextLoaderListener</listener-class>
    </listener>
    
    <!--  http session listener proxy -->
    <listener>
      <listener-class>org.geoserver.platform.GeoServerHttpSessionListenerProxy</listener-class>
    </listener>

	<!-- request context listener for session-scoped beans -->
	<listener>
		<listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
	</listener>

# Dependency Layers

gs-web-app (we dont want this, or we want to minimize it)

gs-main (this seems to be the core Java stuff)

gs-ows, gs-platform