package dao.impl;

import dao.OrderDao;
import pojo.Order;

/**
 * @author 孟享广
 * @date 2020-10-28 5:16 下午
 * @description
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `creat_time`, `price`, `status`, `user_id`) values(?,?,?,?,?)";
        int i = update(sql, order.getOrderId(), order.getCreatTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return i;

    }
}
