public class Storage {

    //仓库容量为10
    private Product[] products = new Product[10];
    private int top = 0;//当前放的位置

//互斥，每次只能有一个线程进入仓库放东西
    public synchronized void push(Product product){

        while(top == products.length){
            try {
                System.out.println("producer wait");
                wait();//仓库已满，等待
            }catch (InterruptedException e){

                e.printStackTrace();
            }
        }

        //放进仓库
        products[top++] = product;
        System.out.println(Thread.currentThread().getName() + "生产了产品" + product);
        System.out.println("producer notifyAll");
        notifyAll();
    }


    //拿商品

    public synchronized Product pop() {
        while (top == 0) {
            try {
                System.out.println("consumer wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        --top;
        Product p = new Product(products[top].getId(), products[top].getName());
        products[top] = null;
        System.out.println(Thread.currentThread().getName() + "消费了产品" + p);

        System.out.println("consumer notifyAll");
        notifyAll();
        return p;

    }


}
