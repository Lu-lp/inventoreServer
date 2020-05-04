package sysu.lulp.VO;

import sysu.lulp.pojo.SysUser;

import javax.persistence.Column;
import java.io.Serializable;

public class UserVO implements Serializable {

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
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 职务id
     */
    private Integer roleId;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 用户描述
     */
    private String description;

    public UserVO(Integer userId, Integer gender, String username, String phoneNumber, Integer roleId, Integer status, String description) {
        this.userId = userId;
        this.gender = gender;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
        this.status = status;
        this.description = description;
    }
    public UserVO(SysUser sysUser){
        this.userId = sysUser.getUserId();
        this.username = sysUser.getUsername();
        this.description = sysUser.getDescription();
        this.roleId = sysUser.getRoleId();
        this.status = sysUser.getStatus();
        this.gender = sysUser.getGender();
        this.phoneNumber = sysUser.getPhoneNumber();
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
