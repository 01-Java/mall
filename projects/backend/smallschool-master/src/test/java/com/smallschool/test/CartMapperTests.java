package com.smallschool.test;

@Test
public void findCartByUid() {
        List<Cart> list = cartMapper.findCartByUid(11);
        System.out.println(list);
}
