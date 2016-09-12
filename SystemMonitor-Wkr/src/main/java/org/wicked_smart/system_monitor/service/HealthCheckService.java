package org.wicked_smart.system_monitor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicked_smart.system_monitor.model.SystemStatus;

/**
 * Created by dlahey on 8/15/2016.
 */
public interface HealthCheckService
{
    public SystemStatus createStatus(SystemStatus systemStatus);

    public SystemStatus readSystemStatus(Long id);

    public SystemStatus updateSystemStatus(Long id, SystemStatus systemStatus);

    public SystemStatus deleteSystemStatus(Long id);
}
