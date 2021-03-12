package demo;

/**
 * @author：hanzhigang
 * @Date : 2021/1/23 6:35 PM
 */
public enum PinType {

    REGISTER(100000,"注册使用"),
    FORGOT_PASSWORD(100001,"忘记密码"),
    UPDATE_PHONE_NUMBER(100002,"更新手机号使用");

    private int code;
    private String message;

    PinType(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PinType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
