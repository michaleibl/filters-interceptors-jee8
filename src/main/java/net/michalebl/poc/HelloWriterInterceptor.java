package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Provider
public class HelloWriterInterceptor implements WriterInterceptor {
    private static final Logger LOGGER = Logger.getLogger(HelloWriterInterceptor.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        LOGGER.info("Writer interceptor is up and watching!");

        context.getOutputStream().write(("Hello from the writer interceptor in the client side! And now:\n").getBytes());
        context.proceed();
    }
}
