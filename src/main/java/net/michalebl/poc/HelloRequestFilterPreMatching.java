package net.michalebl.poc;

import org.jboss.logging.Logger;
import org.jboss.resteasy.core.ResourceMethodInvoker;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class HelloRequestFilterPreMatching implements ContainerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(HelloRequestFilterPreMatching.class);

    @Override
    public void filter(ContainerRequestContext context) {
        LOGGER.info("@PreMatching request filter is up and filtering!");

        ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) context.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");

        if ( methodInvoker == null ) {
            LOGGER.info("The method invoker is correctly null.");
        } else {
            LOGGER.warn("The method invoker is surprisingly not null.");
        }
    }
}
