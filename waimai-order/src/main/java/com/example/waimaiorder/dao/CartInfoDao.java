package com.example.waimaiorder.dao;

import com.example.waimaiorder.entity.CartInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 购物车内商品信息(CartInfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-21 13:50:52
 */
public interface CartInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CartInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param cartInfo 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<CartInfo> queryAllByLimit(CartInfo cartInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cartInfo 查询条件
     * @return 总行数
     */
    long count(CartInfo cartInfo);

    /**
     * 新增数据
     *
     * @param cartInfo 实例对象
     * @return 影响行数
     */
    int insert(CartInfo cartInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CartInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CartInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CartInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CartInfo> entities);

    /**
     * 修改数据
     *
     * @param cartInfo 实例对象
     * @return 影响行数
     */
    int update(CartInfo cartInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查找cartInfo表所有信息
     */
    List<CartInfo> queryAll();

    CartInfo queryByCartIdAndFoodId(Integer cartId, Integer foodId);

    List<CartInfo> queryByCartId(Integer cartId);
}

