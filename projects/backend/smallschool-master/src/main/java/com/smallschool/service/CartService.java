package com.smallschool.service;


import org.springframework.stereotype.Service;

public interface CartService{
    List<Cart> getCartByUid(Integer user_id);

    Integer addCart(Integer cart_id,Integer user_id);

    Integer deleteCart(Integer cart_id,Integer user_id);

    List<Cart> payCart(Integer cart_id);
}
@Service
public class CartServiceImpl implements CartService{
    @Override
    public List<Cart> getCartByUid(Integer user_id) {
        return cartMapper.findCartByUid(user_id);
    }
    @Override
    public Integer addCart(Integer cart_id, Integer user_id) {
        Cart result = cartMapper.findCartByCid(cart_id);
        if (result == null) {
            throw new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cart_id, num, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知异常");
        }
        return num;
    }

    @java.lang.Override
    public Integer deleteCart(Integer cart_id, Integer user_id) {
        Cart result = cartMapper.findCartByCid(cart_id);
        if (result == null) {
            throw new CartNotFoundException("数据不存在");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum() - 1;
        Integer rows = cartMapper.updateNumByCid(cart_id, num, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知异常");
        }
        return num;
    }
    @Override
    public BigDecimal payCart(Integer cart_id) {
        return cartMapper.payCart(cart_id);
    }
}
