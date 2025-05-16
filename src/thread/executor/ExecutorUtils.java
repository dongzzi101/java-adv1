package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils {

    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log("[pool = " + pool + ", active = " + active + ", queuedTasks = " + queuedTasks + ", completedTaskCount = " + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }

    public static void printState(ExecutorService executorService, String taskNAme) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queuedTasks = poolExecutor.getQueue().size();
            long completedTaskCount = poolExecutor.getCompletedTaskCount();
            log(taskNAme + " -> [pool = " + pool + ", active = " + active + ", queuedTasks = " + queuedTasks + ", completedTaskCount = " + completedTaskCount + "]");
        } else {
            log(executorService);
        }
    }

}
