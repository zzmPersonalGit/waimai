package com.example.waimaicommodity.dao;

import com.example.waimaicommodity.entity.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 菜品信息表(Food)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-19 10:22:51
 */
public interface FoodDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Food queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param food     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Food> queryAllByLimit(Food food, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param food 查询条件
     * @return 总行数
     */
    long count(Food food);

    /**
     * 新增数据
     *
     * @param food 实例对象
     * @return 影响行数
     */
    int insert(Food food);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Food> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Food> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Food> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Food> entities);

    /**
     * 修改数据
     *
     * @param food 实例对象
     * @return 影响行数
     */
    int update(Food food);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查找所有事物数据
     * @para
     * @return 所有数据
     */
    List<Food> findAll();
}

