package service;

import pojo.Cart;

/**
 * @author 孟享广
 * @date 2020-10-28 5:34 下午
 * @description
 */
public interface OrderService {
    public String creatOrder(Cart cart, Integer userId);
}
