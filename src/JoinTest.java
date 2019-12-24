public class JoinTest {

    public static void main(String[] args) throws InterruptedException {


        //线程1
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne is running");
                for (; ; ) {

                }
            }
        });

        final Thread mainThread = Thread.currentThread();

        //线程2
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                mainThread.interrupt();

            }
        });

        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread :" + e);
        }


    }
}
