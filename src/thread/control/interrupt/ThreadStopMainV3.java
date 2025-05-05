package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work thread interrupt state1 =" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                log("작업중");
            }

            log("work thread interrupted state2 =" + Thread.currentThread().isInterrupted());
            log("자원 정리");
            log("작업 종료");
        }
    }
}
