package net.michalebl.poc;

import org.jboss.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Provider
public class HelloReaderInterceptor implements ReaderInterceptor {
    private static final Logger LOGGER = Logger.getLogger(HelloReaderInterceptor.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        LOGGER.info("Reader interceptor is up and watching!");

        String text = new String(context.getInputStream().readAllBytes())
                + " (Reviewed and approved by HelloReaderInterceptor)";

        context.setInputStream(new ByteArrayInputStream(text.getBytes()));

        return context.proceed();
    }
}
