package sysu.lulp.response;

import java.io.Serializable;

public class LoginSuccessRestResponse implements Serializable {
    private int status ;
    private String messages;
    private Object token;

    public LoginSuccessRestResponse(Object token) {
        this.status = 200;
        this.messages = "登录成功";
        this.token = token;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }
}
