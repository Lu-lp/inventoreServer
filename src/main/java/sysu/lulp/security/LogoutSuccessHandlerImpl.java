package sysu.lulp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import sysu.lulp.controller.LoginController;
import sysu.lulp.response.LogoutSuccessRestResponse;
import sysu.lulp.utils.WriteResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            logger.info("用户[{}]于[{}]注销成功!", ((User) authentication.getPrincipal()).getUsername(), new Date());
        }
        WriteResponse.write(httpServletResponse, new LogoutSuccessRestResponse());
    }
}
