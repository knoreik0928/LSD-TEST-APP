package org.wicked_smart.system_monitor.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ManifestServiceImpl.class);

    @Inject
    ServletContext servletContext;

    public Map<String, String> parseManifest(InputStream inputStream) throws IOException
    {
        Map<String, String> map = new HashMap();
        Manifest manifest = new Manifest(inputStream);
        Attributes attr = manifest.getMainAttributes();
        Iterator it = attr.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            Attributes.Entry pair = (Attributes.Entry)it.next();
            sb.append(pair.getKey() + " = " + pair.getValue());
            map.put(pair.getKey().toString(), pair.getValue().toString());
        }
        return map;
    }

    @Override
    public Map<String, String> getManifest() throws IOException
    {
        Map<String, String> map = null;
        try(InputStream inputStream = servletContext.getResourceAsStream("/META-INF/MANIFEST.MF"))
        {
            map = parseManifest(inputStream);
        }
        catch (IOException e)
        {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        return map;
    }
}
