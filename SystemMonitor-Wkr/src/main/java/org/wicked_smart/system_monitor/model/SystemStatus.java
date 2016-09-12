package org.wicked_smart.system_monitor.model;

import java.io.Serializable;

/**
 * Created by dlahey on 8/16/2016.
 */
public class SystemStatus implements Serializable
{
    private long id;
    private String name;
    private boolean ok;

    public SystemStatus()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isOk()
    {
        return ok;
    }

    public void setOk(boolean ok)
    {
        this.ok = ok;
    }

    @Override
    public String toString()
    {
        return "SystemStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ok=" + ok +
                '}';
    }
}
