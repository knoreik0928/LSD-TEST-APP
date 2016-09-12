package org.wicked_smart.system_monitor.service;

import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by dlahey on 9/12/2016.
 */

public class ManifestServiceTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ManifestServiceTest.class);

    @Test
    public void testManifestParse()
    {
        try(InputStream inputStream = ManifestServiceTest.class.getClassLoader().getResourceAsStream("MANIFEST.MF"))
        {
            ManifestService manifestService = new ManifestServiceImpl();
            manifestService.parseManifest(inputStream);
            LOGGER.info("Parse");
        }
        catch(IOException e)
        {
            LOGGER.error(e.getMessage(), e);
            Assert.fail(e.getMessage());
        }
    }
}
