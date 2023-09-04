package com.example.waimaishop.dao;

import com.example.waimaishop.entity.ShopInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商铺信息表(ShopInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-20 01:30:22
 */
public interface ShopInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param shopInfo 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<ShopInfo> queryAllByLimit(ShopInfo shopInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shopInfo 查询条件
     * @return 总行数
     */
    long count(ShopInfo shopInfo);

    /**
     * 新增数据
     *
     * @param shopInfo 实例对象
     * @return 影响行数
     */
    int insert(ShopInfo shopInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShopInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShopInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShopInfo> entities);

    /**
     * 修改数据
     *
     * @param shopInfo 实例对象
     * @return 影响行数
     */
    int update(ShopInfo shopInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有数据
     * @param
     * @return 对象列表
     */
    List<ShopInfo> queryAll();

    /**
     * 根据 shopinfo 主键 list 表查数据
     * @param
     * @return 对象列表
     */
    ShopInfo queryByShopId(Integer shopId);
}

