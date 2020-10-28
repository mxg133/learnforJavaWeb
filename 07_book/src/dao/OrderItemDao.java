package dao;

import pojo.Order;
import pojo.OrderItem;

/**
 * @author 孟享广
 * @date 2020-10-28 5:15 下午
 * @description
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
}
