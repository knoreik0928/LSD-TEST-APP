package org.wicked_smart.system_monitor.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by dlahey on 9/10/2016.
 */
public interface ManifestService
{
    public Map<String, String> parseManifest(InputStream inputStream) throws IOException;

    public Map<String, String> getManifest() throws IOException;
}
