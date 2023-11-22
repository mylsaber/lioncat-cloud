package com.mylsaber.console.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author mylsaber
 * @since 2023-11-22
 */
@TableName("SYS_USER")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Byte type;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private Byte gender;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 上次登录ip
     */
    private String lastLoginIp;

    /**
     * 上次登录地点
     */
    private String lastLoginAddress;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 上次登录设备
     */
    private String lastLoginDevice;

    /**
     * 最新登录ip
     */
    private String latestLoginIp;

    /**
     * 最新登录地点
     */
    private String latestLoginAddress;

    /**
     * 最新登录时间
     */
    private LocalDateTime latestLoginTime;

    /**
     * 最新登录设备
     */
    private String latestLoginDevice;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 排序码
     */
    private Integer sortCode;

    /**
     * 扩展信息
     */
    private String extJson;

    /**
     * 删除标志
     */
    private String deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改用户
     */
    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginAddress() {
        return lastLoginAddress;
    }

    public void setLastLoginAddress(String lastLoginAddress) {
        this.lastLoginAddress = lastLoginAddress;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginDevice() {
        return lastLoginDevice;
    }

    public void setLastLoginDevice(String lastLoginDevice) {
        this.lastLoginDevice = lastLoginDevice;
    }

    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp;
    }

    public String getLatestLoginAddress() {
        return latestLoginAddress;
    }

    public void setLatestLoginAddress(String latestLoginAddress) {
        this.latestLoginAddress = latestLoginAddress;
    }

    public LocalDateTime getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(LocalDateTime latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public String getLatestLoginDevice() {
        return latestLoginDevice;
    }

    public void setLatestLoginDevice(String latestLoginDevice) {
        this.latestLoginDevice = latestLoginDevice;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return "SysUser{" +
            "id = " + id +
            ", account = " + account +
            ", password = " + password +
            ", type = " + type +
            ", avatar = " + avatar +
            ", nickname = " + nickname +
            ", gender = " + gender +
            ", birthday = " + birthday +
            ", phone = " + phone +
            ", email = " + email +
            ", lastLoginIp = " + lastLoginIp +
            ", lastLoginAddress = " + lastLoginAddress +
            ", lastLoginTime = " + lastLoginTime +
            ", lastLoginDevice = " + lastLoginDevice +
            ", latestLoginIp = " + latestLoginIp +
            ", latestLoginAddress = " + latestLoginAddress +
            ", latestLoginTime = " + latestLoginTime +
            ", latestLoginDevice = " + latestLoginDevice +
            ", userStatus = " + userStatus +
            ", sortCode = " + sortCode +
            ", extJson = " + extJson +
            ", deleteFlag = " + deleteFlag +
            ", createTime = " + createTime +
            ", createUser = " + createUser +
            ", updateTime = " + updateTime +
            ", updateUser = " + updateUser +
        "}";
    }
}
