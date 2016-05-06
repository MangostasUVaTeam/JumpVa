package server.api;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author vich
 */
@javax.ws.rs.ApplicationPath("api")
public class APIConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(server.api.AuthenticationEndpoint.class);
        resources.add(server.api.AuthenticationFilter.class);
        resources.add(server.api.HelloWorld.class);
    }
    
}