package sysu.lulp.response;

import java.io.Serializable;

public class LogoutSuccessRestResponse implements Serializable {

    private int status;
    private String messages;

    public LogoutSuccessRestResponse() {
        this.status = 200;
        this.messages = "注销成功";
    }

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
}
