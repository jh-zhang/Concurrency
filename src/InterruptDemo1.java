public class InterruptDemo1 {

    public static void main(String[] args)throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });


        threadOne.start();


        threadOne.interrupt();

        System.out.println("isInterrupted:"+ threadOne.isInterrupted());
        System.out.println("isInterrupted:"+ threadOne.interrupted());//返回的是当前运行线程的中断标志
        System.out.println("isInterrupted:"+ Thread.interrupted());
        System.out.println("isInterrupted:"+ threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main thread is over");
    }
}
