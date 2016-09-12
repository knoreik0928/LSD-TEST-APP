package org.wicked_smart.system_monitor.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dlahey on 3/10/2016.
 */
public class SystemMonitorServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemMonitorServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        LOGGER.info("contextInitialized");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        LOGGER.info("contextDestroyed");
    }
}
