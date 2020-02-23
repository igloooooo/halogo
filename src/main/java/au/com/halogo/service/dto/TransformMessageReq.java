package au.com.halogo.service.dto;

public class TransformMessageReq {
    private String username;
    private float number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TransformMessageReq{" +
            "username='" + username + '\'' +
            ", number=" + number +
            '}';
    }
}
