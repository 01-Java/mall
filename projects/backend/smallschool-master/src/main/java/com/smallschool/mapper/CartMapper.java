package com.smallschool.mapper;

public interface CartMapper {
    List<Cart> findCartByUid(Integer user_id);
    List<Cart> findCartByCid(Integer cart_id);
    Integer updateNumByCid(Integer cart_id,Integer product_number,Date add_time);
    Integer addCart(Integer cart_id);
    Integer deleteCart(Integer cart_id);
    BigDecimal payCart(Integer cart_id);

    Integer updateNumByCid(
            @Param("cart_id") Integer cart_id,
            @Param("product_number") Integer product_number,
            @Param("add_time") Date add_time);

    List<Cart> findCartByUid(
            @Param("user_id") Integer user_id);

    List<Cart> findCartByCid(
            @Param("cart_id") Integer cart_id);
    Integer addCart(
            @Param("cart_id") Integer cart_id);
    Integer deleteCart(
            @Param("cart_id") Integer cart_id);

    @Repository
    public class CartMapperImpl implements CartMapper {

        private final SqlSession sqlSession;
        public CartMapperImpl(SqlSession sqlSession) {
            this.sqlSession = sqlSession;
        }
        @Override
        public List<Cart> findCartByUid(Integer user_id) {
            return sqlSession.selectList("com.smallschool.mapper.CartMapper.findCartByUid", user_id);
        }

        @Override
        public List<Cart> findCartByCid(Integer cart_id) {
            return sqlSession.selectList("com.smallschool.mapper.CartMapper.findCartByCid", cart_id);
        }

        @Override
        public Integer updateNumByCid(Integer cart_id, Integer product_number, Date add_time) {
            return sqlSession.update("com.smallschool.mapper.CartMapper.updateNumByCid", cart_id, product_number, add_time);
        }

        @Override
        public Integer addCart(Integer cart_id) {
            return sqlSession.insert("com.smallschool.mapper.CartMapper.addCart", cart_id);
        }

        @Override
        public Integer deleteCart(Integer cart_id) {
            return sqlSession.delete("com.smallschool.mapper.CartMapper.deleteCart", cart_id);
        }

        @Override
        public BigDecimal payCart(Integer cart_id) {
            return sqlSession.selectOne("com.smallschool.mapper.CartMapper.payCart", cart_id);
        }
    }
}
