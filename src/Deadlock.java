import java.util.concurrent.TimeUnit;

public class Deadlock {

    public static Integer r1 = 1;
    public static Integer r2 =2;

    public static void main(String[] args)throws InterruptedException {

        ThreadDemo51 threadDemo51 = new ThreadDemo51();
        threadDemo51.start();
        ThreadDemo52 threadDemo52 = new ThreadDemo52();
        threadDemo52.start();
    }
}

class ThreadDemo51 extends Thread{
    @Override
    public void run(){

        synchronized (Deadlock.r1){
            try {
                TimeUnit.SECONDS.sleep(3);//睡眠3s
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (Deadlock.r2){
                System.out.println("Thread1 is running");
        }
        }
    }


}


class ThreadDemo52 extends Thread{

    @Override
    public void run(){

        synchronized (Deadlock.r1) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Deadlock.r2) {
                System.out.println("Thread2 is running");
            }
        }
    }

}