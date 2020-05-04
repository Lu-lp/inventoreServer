package sysu.lulp.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 性别: 0男，1女
     */
    private Integer gender;

    /**
     * 姓名
     */
    private String username;

    /**
     * 登录账户
     */
    private String account;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 联系电话
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 职务id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取性别: 0男，1女
     *
     * @return gender - 性别: 0男，1女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别: 0男，1女
     *
     * @param gender 性别: 0男，1女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取姓名
     *
     * @return username - 姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置姓名
     *
     * @param username 姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登录账户
     *
     * @return account - 登录账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置登录账户
     *
     * @param account 登录账户
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取联系电话
     *
     * @return phone_number - 联系电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置联系电话
     *
     * @param phoneNumber 联系电话
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取职务id
     *
     * @return role_id - 职务id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置职务id
     *
     * @param roleId 职务id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取用户状态
     *
     * @return status - 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户描述
     *
     * @return description - 用户描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置用户描述
     *
     * @param description 用户描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}