package org.system.entity;

import org.core.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName User
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:17
 * @Description TODO
 */
public class User extends BaseEntity {

    private Integer id;

    @NotBlank(message = "user.name.notblank.valid.msg",groups = {BaseEntity.Insert.class})
    private String name;

    private Integer sex;

    private String idCard;

    private Date createDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    @NotNull(message = "{page.empty}", groups = { SelectAll.class })
    public Integer getPage() {
        return super.getPage();
    }

    @Override
    @NotNull(message = "{rows.empty}", groups = { SelectAll.class })
    public Integer getRows() {
        return super.getRows();
    }
}
