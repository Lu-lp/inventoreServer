package sysu.lulp.response;

import java.io.Serializable;

public class AccessDenyRestResponse  implements Serializable {
    private int status;
    private String messages;

    public AccessDenyRestResponse() {
        this.status = 222;
        this.messages = "没有相应的权限";
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
