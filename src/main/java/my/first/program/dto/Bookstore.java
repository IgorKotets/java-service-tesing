package my.first.program.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Bookstore")
public class Bookstore {

    @XStreamAlias("Token")
    @XStreamAsAttribute
    private String token;

    @XStreamAlias("Expires")
    @XStreamAsAttribute
    private String Expires;

    @XStreamAlias("Status")
    @XStreamAsAttribute
    private String Status;

    @XStreamAlias("Result")
    @XStreamAsAttribute
    private String Result;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpires() {
        return Expires;
    }

    public void setExpires(String expires) {
        Expires = expires;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }






}
