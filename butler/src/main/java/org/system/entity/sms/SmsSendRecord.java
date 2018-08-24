package org.system.entity.sms;

import org.core.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/24 11:02
 * @return
 * @Description 短信记录
 **/
public class SmsSendRecord extends BaseEntity {

    private Integer id;

    private String phone;

    private String content;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    @NotNull(message = "{page.empty}", groups = {SelectAll.class})
    public Integer getPage() {
        return super.getPage();
    }

    @Override
    @NotNull(message = "{rows.empty}", groups = {SelectAll.class})
    public Integer getRows() {
        return super.getRows();
    }
}
