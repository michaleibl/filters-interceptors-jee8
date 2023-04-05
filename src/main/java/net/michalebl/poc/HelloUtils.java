package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import java.lang.annotation.Annotation;
import java.util.Arrays;

public class HelloUtils {
    static void checkResourceInfo(ResourceInfo resourceInfo, ContainerRequestContext context, Logger logger) {

        if ( resourceInfo == null) {
            logger.fatal("No Resource Info available!");
            return;
        }

        Class<?> resourceClass = resourceInfo.getResourceClass();

        if ( resourceClass == null ) {
            logger.warn("You're looking for a not existing resource! URI: " + context.getUriInfo().getPath());
            return;
        }

        String className = resourceClass.getName();
        String methodName = resourceInfo.getResourceMethod().getName();
        Annotation[] annotations = resourceInfo.getResourceMethod().getAnnotations();

        logger.infof("Calling: %s#%s retrieved from ResourceInfo instance", className, methodName);
        logger.infof("Its list of annotation: %s", Arrays.toString(annotations));
    }
}
