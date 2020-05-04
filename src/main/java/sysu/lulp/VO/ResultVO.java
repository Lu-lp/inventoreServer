package sysu.lulp.VO;

import java.io.Serializable;

public class ResultVO<T> implements Serializable {
    private int status ;

    private String messages;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
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

    public ResultVO() {
        this.status = 200;
        this.messages = "成功";
        this.data = null;
    }

    public ResultVO(int status, String messages, T data) {
        this.status = status;
        this.messages = messages;
        this.data = data;
    }
}
