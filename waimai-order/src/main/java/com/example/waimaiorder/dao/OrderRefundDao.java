package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.OrderRefund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单--退款处理(OrderRefund)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-17 18:08:14
 */
public interface OrderRefundDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderRefund queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param orderRefund 查询条件
     * @return 总行数
     */
    long count(OrderRefund orderRefund);

    /**
     * 新增数据
     *
     * @param orderRefund 实例对象
     * @return 影响行数
     */
    int insert(OrderRefund orderRefund);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderRefund> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderRefund> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderRefund> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderRefund> entities);

    /**
     * 修改数据
     *
     * @param orderRefund 实例对象
     * @return 影响行数
     */
    int update(OrderRefund orderRefund);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

