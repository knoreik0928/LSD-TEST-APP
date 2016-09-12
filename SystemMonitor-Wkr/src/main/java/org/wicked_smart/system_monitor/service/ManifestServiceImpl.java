package org.wicked_smart.system_monitor.service;

import java.io.InputStream;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by dlahey on 9/10/2016.
 */
@Service
public class ManifestServiceImpl implements ManifestService
{
    Logger LOGGER = LoggerFactory.getLogger(ManifestServiceImpl.class);

    @Inject
    ServletContext servletContext;

    @Override
    public String getManifest()
    {
        StringBuilder sb = new StringBuilder();

        try
        {
            InputStream inputStream = servletContext.getResourceAsStream("/META-INF/MANIFEST.MF");
            Manifest manifest = new Manifest(inputStream);
            Attributes attr = manifest.getMainAttributes();
            Iterator it = attr.entrySet().iterator();
            while (it.hasNext()) {
                Attributes.Entry pair = (Attributes.Entry)it.next();
                sb.append(pair.getKey() + " = " + pair.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }
        }
        catch (Throwable e)
        {
            LOGGER.error(e.getMessage(), e);
        }
        return sb.toString();
    }
}
