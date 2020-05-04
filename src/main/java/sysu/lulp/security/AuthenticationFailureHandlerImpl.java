package sysu.lulp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import sysu.lulp.controller.LoginController;
import sysu.lulp.response.LoginFailureRestResponse;
import sysu.lulp.utils.WriteResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private String username;

    public AuthenticationFailureHandlerImpl(String username) {
        this.username = username;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        logger.info("用户[{}]于[{}]登录失败,失败原因：[{}]", username, new Date());
        WriteResponse.write(httpServletResponse, new LoginFailureRestResponse());
    }
}
