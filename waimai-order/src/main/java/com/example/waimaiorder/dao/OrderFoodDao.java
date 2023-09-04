package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.OrderFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单商品详情表(OrderFood)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
public interface OrderFoodDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderFood queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param orderFood 查询条件
     * @return 总行数
     */
    long count(OrderFood orderFood);

    /**
     * 新增数据
     *
     * @param orderFood 实例对象
     * @return 影响行数
     */
    int insert(OrderFood orderFood);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderFood> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderFood> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderFood> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderFood> entities);

    /**
     * 修改数据
     *
     * @param orderFood 实例对象
     * @return 影响行数
     */
    int update(OrderFood orderFood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<OrderFood> queryAll();

    Integer queryByOrderIdAndFoodId(String orderId, Integer foodId);

    List<OrderFood> queryByOrderId(String orderId);

}

