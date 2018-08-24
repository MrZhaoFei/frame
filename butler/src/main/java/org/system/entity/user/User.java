package org.system.entity.user;

import org.core.entity.BaseEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName User
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:17
 * @Description 用户信息
 */
public class User extends BaseEntity {

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/24 10:13
     * @return
     * @Description  用户注册校验组
     **/
    public interface UserRegister{};

    private Integer id;

    @NotBlank(message = "{user.phone.notblank.valid.msg}", groups = {User.UserRegister.class})
    private String phone;

    @NotBlank(message = "{user.password.notblank.valid.msg}", groups = {User.UserRegister.class})
    private String password;

    @NotBlank(message = "{user.nickName.notblank.valid.msg}", groups = {User.UserRegister.class})
    private String nickName;

    private String name;

    private Integer sex;

    private String idCard;

    private Date birthday;

    private String province;

    private String city;

    private String area;

    private String street;

    private Double lng;

    private Double lat;

    private String address;

    private String remark;

    private Date createDate;

    private Date updateDate;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
