package thread.executor.future;

import static util.MyLogger.log;

public class SumTaskMainV1 {

    public static void main(String[] args) throws InterruptedException {
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // 쓰레드 종료될 때 까지 대기
        log("join() - main thread가 thread1, thread2 종료까지 대기");
        thread1.join();
        thread2.join();
        log("main thread 대기 완료");

        log("task1.result: " + task1.result);
        log("task2.result: " + task2.result);

        int sumAll = task1.result + task2.result;

        log("result = " + sumAll);


    }

    static class SumTask implements Runnable {
        private int startValue;
        private int endValue;
        private int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {

            log("작업 시작");
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
        }
    }


}
