package org.wicked_smart.system_monitor.exception;

/**
 * Created by dlahey on 3/7/2016.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
