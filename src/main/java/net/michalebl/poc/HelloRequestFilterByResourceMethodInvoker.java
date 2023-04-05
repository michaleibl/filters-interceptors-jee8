package net.michalebl.poc;

import org.jboss.logging.Logger;
import org.jboss.resteasy.core.ResourceMethodInvoker;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;

@Provider
public class HelloRequestFilterByResourceMethodInvoker implements ContainerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(HelloRequestFilterByResourceMethodInvoker.class);

    @Override
    public void filter(ContainerRequestContext context) {
        LOGGER.info("Request filter using ResourceMethodInvoker instance is up and filtering!");

        ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) context.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
        String className = methodInvoker.getResourceClass().getName();
        String methodName = methodInvoker.getMethod().getName();

        LOGGER.infof("Calling: %s#%s which were retrieved from ResourceMethodInvoker instance", className, methodName);
        LOGGER.infof("Its list of annotation: %s", Arrays.toString(methodInvoker.getMethodAnnotations()));
    }
}
