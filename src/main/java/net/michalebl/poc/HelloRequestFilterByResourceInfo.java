package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class HelloRequestFilterByResourceInfo implements ContainerRequestFilter {
    private static final Logger LOGGER = Logger.getLogger(HelloRequestFilterByResourceInfo.class);

    @Context
    ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext context) {
        LOGGER.info("Request filter using ResourceInfo from @Context is up and filtering!");
        HelloUtils.checkResourceInfo(resourceInfo, context, LOGGER);
    }
}
