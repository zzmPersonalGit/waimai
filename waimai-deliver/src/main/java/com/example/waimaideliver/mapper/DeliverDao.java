package com.example.waimaideliver.mapper;

import com.example.waimaideliver.entity.Deliver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;


import java.util.List;

/**
 * 送餐员信息表(Deliver)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-19 16:44:51
 */
@Mapper
public interface DeliverDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
   /* @Select("select * from deliver where id = 1")*/
    Deliver queryById(Integer id);


    /**
     * 统计总行数
     *
     * @param deliver 查询条件
     * @return 总行数
     */
    long count(Deliver deliver);

    /**
     * 新增数据
     *
     * @param deliver 实例对象
     * @return 影响行数
     */
    int insert(Deliver deliver);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deliver> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Deliver> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Deliver> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Deliver> entities);

    /**
     * 修改数据
     *
     * @param deliver 实例对象
     * @return 影响行数
     */
    int update(Deliver deliver);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Deliver queryByUsername(String username);

    Deliver queryByMobile(String mobile);
}

