package sysu.lulp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sysu.lulp.controller.LoginController;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.response.LoginFailureRestResponse;
import sysu.lulp.response.LoginSuccessRestResponse;
import sysu.lulp.utils.WriteResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //登录成功后获取当前登录用户
        User sysUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("用户[{}]于[{}]登录成功!", sysUser.getUsername(), new Date());
        WriteResponse.write(httpServletResponse, new LoginSuccessRestResponse(SecurityContextHolder.getContext().getAuthentication()));
//        WriteResponse.write(httpServletResponse, SecurityContextHolder.getContext().toString());
    }
}
