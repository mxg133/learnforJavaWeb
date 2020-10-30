package threadLocal;

/**
 * @author 孟享广
 * @date 2020-10-30 4:10 下午
 * @description
 */
public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("OrderService 当前线程[" + name + "]中保存的数据是：" + ThreadLocalTest.threadLocal.get());
        new OrderDao().saveOrder();
    }
}
