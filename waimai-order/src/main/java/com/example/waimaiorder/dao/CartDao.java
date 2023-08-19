package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 购物车(Cart)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-21 13:50:51
 */
public interface CartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cart queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param cart     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Cart> queryAllByLimit(Cart cart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cart 查询条件
     * @return 总行数
     */
    long count(Cart cart);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int insert(Cart cart);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cart> entities);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过用户id和店铺id查找购物车
     *
     * @param userid 用户id
     * @param shopid 店铺id
     * @return 实例对象*/
    Cart queryByUidAndShopId(Integer userid, Integer shopid);

    /**
     * 查询所有
     *
     * @return 对象列表*/
    List<Cart> queryALL();
}

