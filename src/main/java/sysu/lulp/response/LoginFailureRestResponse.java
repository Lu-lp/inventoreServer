package sysu.lulp.response;

import java.io.Serializable;

public class LoginFailureRestResponse implements Serializable {
    private int status;
    private String messages;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }


    public LoginFailureRestResponse() {
        this.status = 401;
        this.messages = "登录失败";
    }
}
