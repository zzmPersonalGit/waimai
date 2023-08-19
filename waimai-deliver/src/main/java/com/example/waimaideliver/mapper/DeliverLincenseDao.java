package com.example.waimaideliver.mapper;

import com.example.waimaideliver.entity.DeliverLincense;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 送餐员认证信息表(DeliverLincense)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-04 10:49:12
 */
@Mapper
public interface DeliverLincenseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DeliverLincense queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param deliverLincense 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DeliverLincense> queryAllByLimit(DeliverLincense deliverLincense, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param deliverLincense 查询条件
     * @return 总行数
     */
    long count(DeliverLincense deliverLincense);

    /**
     * 新增数据
     *
     * @param deliverLincense 实例对象
     * @return 影响行数
     */
    int insert(DeliverLincense deliverLincense);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DeliverLincense> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DeliverLincense> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DeliverLincense> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DeliverLincense> entities);

    /**
     * 修改数据
     *
     * @param deliverLincense 实例对象
     * @return 影响行数
     */
    int update(DeliverLincense deliverLincense);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过主键批量操作骑手认证信息状态
     * @param list 主键列表
     * @return 影响行数
     */
    Integer updateLinStatus(List<Integer> list);

    DeliverLincense queryByDeliverId(Integer deliverId);
}

