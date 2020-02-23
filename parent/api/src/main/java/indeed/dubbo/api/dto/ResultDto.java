package indeed.dubbo.api.dto;

import java.io.Serializable;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2020-01-21
 */
public class ResultDto<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public ResultDto() {
        this.code = 200;
        this.message = "success";
    }

    public ResultDto(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public ResultDto(int code, String message, T data) {
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public final int getCode() {
        return code;
    }

    public ResultDto<T> setCode(int code) {
        this.code=code;
        return this;
    }

    public final String getMessage() {
        return message;
    }

    public ResultDto<T> setMessage(String message) {
        this.message=message;
        return this;
    }

    public final T getData() {
        return data;
    }

    public ResultDto<T> setData(T data) {
        this.data=data;
        return this;
    }
}
