package com.example.waimaicoupon.dao;

import com.example.waimaicoupon.entity.CouponAccept;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 红包领取表(CouponAccept)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-27 11:18:10
 */
public interface CouponAcceptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CouponAccept queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param couponAccept 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<CouponAccept> queryAllByLimit(CouponAccept couponAccept, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param couponAccept 查询条件
     * @return 总行数
     */
    long count(CouponAccept couponAccept);

    /**
     * 新增数据
     *
     * @param couponAccept 实例对象
     * @return 影响行数
     */
    int insert(CouponAccept couponAccept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CouponAccept> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CouponAccept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CouponAccept> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CouponAccept> entities);

    /**
     * 修改数据
     *
     * @param couponAccept 实例对象
     * @return 影响行数
     */
    int update(CouponAccept couponAccept);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    CouponAccept queryByshopIdAndUserId(String couponId, Integer userId);

    List<CouponAccept> queryAll();
}

