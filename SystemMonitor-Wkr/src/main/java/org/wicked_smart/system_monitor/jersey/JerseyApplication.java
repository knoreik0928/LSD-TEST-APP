package org.wicked_smart.system_monitor.jersey;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.wicked_smart.system_monitor.controller.HealthCheckController;
import org.wicked_smart.system_monitor.controller.ManifestController;

@ApplicationPath("/services")
public class JerseyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> resources = new HashSet<Class<?>>();
	
    /**
     * Register JAX-RS application components.
     */
    public JerseyApplication() {
    	
    	singletons.add(new HealthCheckController());
        singletons.add(new ManifestController());
    	resources.add(RequestContextFilter.class);
    }
    
    @Override
    public Set<Class<?>> getClasses() {
       return resources;
    }
    
    @Override
    public Set<Object> getSingletons() {
       return singletons;
    }
}