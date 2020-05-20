package org.conversions.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Slf4j
@Provider
public class ResponseTimeLogger implements ContainerRequestFilter, ContainerResponseFilter {

    private final static String REQUEST_TIME = "requestTime";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        containerRequestContext.setProperty(REQUEST_TIME, new Long(System.nanoTime()));
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext
            , ContainerResponseContext containerResponseContext) throws IOException {
        Long requestTime = (Long) containerRequestContext.getProperty(REQUEST_TIME);
        Long responseTime = System.nanoTime();
        Long duration = (responseTime - requestTime);
        log.info("response time {} {} nano seconds", containerRequestContext.getUriInfo().getPath()
                , duration);
    }

}
