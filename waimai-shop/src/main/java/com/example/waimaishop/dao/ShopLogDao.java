package com.example.waimaishop.dao;

import com.example.waimaishop.entity.ShopLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商家操作日志(ShopLog)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-20 01:30:22
 */
public interface ShopLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopLog queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param shopLog  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<ShopLog> queryAllByLimit(ShopLog shopLog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shopLog 查询条件
     * @return 总行数
     */
    long count(ShopLog shopLog);

    /**
     * 新增数据
     *
     * @param shopLog 实例对象
     * @return 影响行数
     */
    int insert(ShopLog shopLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShopLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopLog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShopLog> entities);

    /**
     * 修改数据
     *
     * @param shopLog 实例对象
     * @return 影响行数
     */
    int update(ShopLog shopLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

