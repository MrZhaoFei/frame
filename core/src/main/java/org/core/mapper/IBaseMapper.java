package org.core.mapper;

import org.core.entity.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IBaseMapper
 * @Author Zhao.Fei
 * @Date 2018/8/9 14:03
 * @Description 顶层基础Mapper
 */
public abstract interface IBaseMapper<T extends BaseEntity> {

    /**
     * @Author Zhao.Fei
     * @Param [entity]
     * @Date 2018/8/9 14:36
     * @return int
     * @Description 新增对象
     **/
    abstract int insert(T entity);

    /**
     * @Author Zhao.Fei
     * @Param [entity]
     * @Date 2018/8/9 14:36
     * @return int
     * @Description 修改对象
     **/
    abstract int update(T entity);

    /**
     * @Author Zhao.Fei
     * @Param [entity]
     * @Date 2018/8/9 14:36
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 查询单个对象
     **/
    abstract Map<String,Object> selectOne(T entity);

    /**
     * @Author Zhao.Fei
     * @Param [entity]
     * @Date 2018/8/9 14:36
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description  检查数据是否重复
     **/
    abstract Map<String,Object> selectIsExists(T entity);

    /**
     * @Author Zhao.Fei
     * @Param [entity]
     * @Date 2018/8/9 14:36
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @Description 查询多条记录
     **/
    abstract List<Map<String,Object>> selectAll(T entity);

}
