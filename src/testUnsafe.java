import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class testUnsafe {
    //获取Unsafe实例,但由于Unsafe类可以直接操作内存，这样不安全，需要用到反射
   //static final Unsafe unsafe = Unsafe.getUnsafe();


    static final Unsafe unsafe;
    //记录变量state在类testUnsafe中的偏移值
    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            //使用反射获取Unsafe的成员变量theUnsafe
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可存取
            field.setAccessible(true);
            //获取该变量的值
            unsafe = (Unsafe)field.get(null);

            stateOffset = unsafe.objectFieldOffset(testUnsafe.class.getDeclaredField("state"));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        testUnsafe test = new testUnsafe();

        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);
    }
}
