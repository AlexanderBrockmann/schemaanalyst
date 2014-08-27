
package org.schemaanalyst.util.monitoring;

import java.util.concurrent.Callable;
import org.apache.commons.lang3.time.StopWatch;

/**
 * Utility functions for timing operations.
 * 
 * @author Chris J. Wright
 */
public class Timing {
    
    /**
     * Times the duration it takes for a callable to be executed using a StopWatch.
     * 
     * @param <T> The callable return type
     * @param callable The callable
     * @param watch The stopwatch
     * @return The callable return
     */
    public static <T> T timedTask(Callable<T> callable, StopWatch watch) {
        try {
            watch.start();
            T result = callable.call();
            watch.stop();
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}