package sysu.lulp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sysu.lulp.VO.ResultVO;
import sysu.lulp.VO.UserVO;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.pojo.UserRole;
import sysu.lulp.service.impl.UserRoleServiceImpl;
import sysu.lulp.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userService;
    private final UserRoleServiceImpl userRoleService;
    @Autowired
    public UserController(UserServiceImpl userService, UserRoleServiceImpl userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @GetMapping("")
    public ResultVO  getUserInfoByUsername(@RequestParam(name = "username") String username){
        SysUser sysUser = userService.queryByName(username);
        logger.warn("获取用户[{}]信息", username);
        if(!(sysUser == null)){
            return new ResultVO(200, "获取成功", sysUser);
        }
        return new ResultVO(400, "用户不存在", new String("1"));
    }

    @GetMapping("/lists")
    public ResultVO getUsersList(){
        List<SysUser> usersList = userService.getAllUsers();
        List<UserVO> temp = new ArrayList<>();
        for ( SysUser user: usersList) {
            temp.add(new UserVO(user));
        }
        return new ResultVO(200, "获取成功", temp);
    }

    @PostMapping("")
    public ResultVO addUser(@RequestBody UserVO userVO) {
        SysUser temp = new SysUser();
        BeanUtils.copyProperties(userVO,temp);
        temp.setUserId(null);
        temp.setAccount(temp.getUsername());
        temp.setPassword("123456");
        UserRole userRole = new UserRole();
        userRole.setRoleId(temp.getRoleId());
        try{
            userService.saveUser(temp);
            userRole.setUserId(userService.queryByName(temp.getUsername()).getUserId());
            userRoleService.saveUserRole(userRole);
        }catch (Exception e){
            logger.warn(String.valueOf(e));
        }
        logger.info("添加用户成功");
        return new ResultVO(200, "添加用户成功", new String("1"));
    }
    @PostMapping("/item")
    public ResultVO updateUser(@RequestBody UserVO userVO){
        SysUser temp = new SysUser();
        BeanUtils.copyProperties(userVO,temp);
        userService.updateUser(temp);
        UserRole userRole = new UserRole();
        userRole.setUserId(temp.getUserId());
        userRoleService.deleteUserRole(userRole);
        userRole.setRoleId(temp.getRoleId());
        try {
            userRoleService.saveUserRole(userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVO(200, "修改", new String("1"));
    }

}
