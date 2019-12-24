public class interruptTest {
    public static void main(String[] args)throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

        Thread.sleep(3000);
        thread1.interrupt();;
        thread2.flag = false; //这种方法暂停线程比较好
        System.out.println("main thread is exiting");

    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        while (!interrupted()){
            System.out.println("Thread1 is running");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;  //此处需要break才能够正常退出循环，否则一次interr后，循环又会继续
            }
        }

        System.out.println("Thread1 is exiting");
    }
}

class Thread2 extends Thread{

    public volatile boolean flag = true;
    @Override
    public void run(){
        while (flag){
            System.out.println("Thread2 is running");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Thread2 is exiting");
    }
}