package com.example.waimaiuser.dao;

import com.example.waimaiuser.entity.UserAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户配送地址(UserAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-20 18:30:49
 */
public interface UserAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserAddress queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param userAddress 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<UserAddress> queryAllByLimit(UserAddress userAddress, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userAddress 查询条件
     * @return 总行数
     */
    long count(UserAddress userAddress);

    /**
     * 新增数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    int insert(UserAddress userAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserAddress> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserAddress> entities);

    /**
     * 修改数据
     *
     * @param userAddress 实例对象
     * @return 影响行数
     */
    int update(UserAddress userAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

