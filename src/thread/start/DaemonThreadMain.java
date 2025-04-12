package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DemoThread demoThread = new DemoThread();
        demoThread.setDaemon(true); // 데몬 스레드 여부
        demoThread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DemoThread extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
