package net.sgl.simplemanageoa.bean;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer code = 200;
    private String msg = "Success!!";
    private T data;

}
