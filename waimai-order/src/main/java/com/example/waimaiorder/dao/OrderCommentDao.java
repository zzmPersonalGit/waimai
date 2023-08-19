package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.OrderComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单--评论(OrderComment)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-17 18:08:13
 */
public interface OrderCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderComment queryById(Integer id);

    /**
     * 统计总行数
     *
     * @param orderComment 查询条件
     * @return 总行数
     */
    long count(OrderComment orderComment);

    /**
     * 新增数据
     *
     * @param orderComment 实例对象
     * @return 影响行数
     */
    int insert(OrderComment orderComment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderComment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrderComment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OrderComment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OrderComment> entities);

    /**
     * 修改数据
     *
     * @param orderComment 实例对象
     * @return 影响行数
     */
    int update(OrderComment orderComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

