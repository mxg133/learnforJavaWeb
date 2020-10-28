package dao.impl;

import dao.OrderItemDao;
import pojo.OrderItem;

/**
 * @author 孟享广
 * @date 2020-10-28 5:18 下午
 * @description
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`) values(?,?,?,?,?)";
        int i = update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return i;
    }
}
