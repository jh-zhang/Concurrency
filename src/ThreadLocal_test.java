public class ThreadLocal_test {
    //public static ThreadLocal<String> threadLocal  = new ThreadLocal<String>(); //ThreadLocal不具有继承性
    public static ThreadLocal<String> threadLocal  = new InheritableThreadLocal<String>();  //inheritaThreadLocal可以继承父线程
    public static void main(String[] args) {
        threadLocal.set("Hello World!");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:" + threadLocal.get());

            }
        });

        thread.start();

        System.out.println("main:"+threadLocal.get());
    }
}
