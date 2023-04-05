package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class HelloResponseFilter implements ContainerResponseFilter {
    private static final Logger LOGGER = Logger.getLogger(HelloResponseFilter.class);

    @Context
    ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        LOGGER.info("Response filter using ResourceInfo from @Context is up and filtering!");
        HelloUtils.checkResourceInfo(resourceInfo, requestContext, LOGGER);
    }
}
