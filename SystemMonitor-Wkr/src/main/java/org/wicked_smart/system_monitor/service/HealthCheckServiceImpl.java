package org.wicked_smart.system_monitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wicked_smart.system_monitor.model.SystemStatus;

/**
 * Created by dlahey on 8/15/2016.
 */
@Service
public class HealthCheckServiceImpl implements HealthCheckService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckServiceImpl.class);

    @Override
    public SystemStatus createStatus(SystemStatus systemStatus)
    {
        return null;
    }

    @Override
    public SystemStatus readSystemStatus(Long id)
    {
        return null;
    }

    @Override
    public SystemStatus updateSystemStatus(Long id, SystemStatus systemStatus)
    {
        return null;
    }

    @Override
    public SystemStatus deleteSystemStatus(Long id)
    {
        return null;
    }
}
