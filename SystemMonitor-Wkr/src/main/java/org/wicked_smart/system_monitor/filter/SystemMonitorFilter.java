package org.wicked_smart.system_monitor.filter;

import java.io.InputStream;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by dlahey on 3/10/2016.
 */
public class SystemMonitorFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemMonitorFilter.class);

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        LOGGER.info("init");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOGGER.info("doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
