package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单详情表(OrderDetail)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
public interface OrderDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDetail queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param orderDetail 查询条件
     * @return 总行数
     */
    long count(OrderDetail orderDetail);

    /**
     * 新增数据
     *
     * @param orderDetail 实例对象
     * @return 影响行数
     */
    int insert(OrderDetail orderDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderDetail> entities);

    /**
     * 修改数据
     *
     * @param orderDetail 实例对象
     * @return 影响行数
     */
    int update(OrderDetail orderDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

