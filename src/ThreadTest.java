import java.sql.Struct;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static class MyThread extends Thread{

        @Override
        public void run(){

            System.out.println("I am a child thread");


        }


    }

    public static class RunnableTask implements Runnable{

        @Override
        public void run(){

            System.out.println("I am a child thread");
        }

    }

    public static class CallerTask implements Callable<String>{

        @Override
        public String call()throws Exception{
            return "hello";
        }
    }

    public static void main(String[] args)throws InterruptedException {

/*        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());

        //启动线程
        new Thread(futureTask).start();
        try {
            //等任务执行完毕，返回结果
            String result = futureTask.get();
            System.out.println(result);
        }catch (ExecutionException e){
            e.printStackTrace();
        }*/

        //实现Runnable接口的run方法
/*
        RunnableTask task = new RunnableTask();
        new Thread(task).start();//一个Runnable类必须包装在Thread类里面才能运行，此处相当于Thread t = new Thread(task);t.start;
        new Thread(task).start();
*/



        //继承了Thread类，但由于java不支持多继承，继承了Thread类就不能继承其他类
        //创建线程
        MyThread thread = new MyThread();

        //启动线程
        thread.start();
        //thread.start();




    }
}
