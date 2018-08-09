package org.core.entity;

import java.util.List;

/**
 * @ClassName BaseEntity
 * @Author Zhao.Fei
 * @Date 2018/8/9 13:57
 * @Description 顶层基础实体类
 */
public class BaseEntity {

    /**
     * 当前页数 从1开始计数
     */
    Integer page;

    /**
     * 每页记录数 必须大于0
     */
    Integer rows;

    /**
     * 记录总数 设置分页会自动封装此属性
     */
    Integer total;

    /**
     * 自定义排序
     */
    List<Sort> sorts;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page > 0 ? page : 1;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows >= 0 ? rows : 10;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    /**
     * 用于新增单条记录的校验分组接口
     */
    public interface Insert {
    }


    /**
     * 用于修改单条记录的校验分组接口
     */
    public interface Update {
    }


    /**
     * 用于查询多条记录的校验分组接口
     */
    public interface SelectAll {
    }


    /**
     * 用于查询条单条记录的校验分组接口
     */
    public interface SelectOne {
    }


    /**
     * 用于删除记录的校验分组接口
     */
    public interface Delete {
    }


}
