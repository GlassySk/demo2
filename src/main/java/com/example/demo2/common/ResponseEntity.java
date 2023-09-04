package com.example.demo2.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;


/**
 * @author HJL
 */
@ApiModel(description= "返回响应数据")
public class ResponseEntity<T> {
    @ApiModelProperty(value = "编码")
    private int code = 200;

    @ApiModelProperty(value = "基本信息")
    private String message = "成功";

    @ApiModelProperty(value = "错误信息")
    private String errorMsg = "";

    @ApiModelProperty(value = "返回对象")
    private T data;

    public enum ERROR_CODE {
        /**
         * 枚举值
         */
        NONE_DATA(100, "暂无数据"),
        NONE_FIND_DATA(50001, "不存在的对象"),
        NULL_POINTER_ERROR(60000, "空指针异常, 联系后端进行修复!"),
        REQUEST_METHOD_ERROR(60010, "请求方式异常, 请用POST/GET"),
        COMMON_ERROR(1000, "通用错误"),
        LOGIN_OVER_TIME(10002, "登录状态已过期, 请重新登录!"),
        LOGIN_PASSWD_OVER_TIME(10003, "账号密码已过期,请修改密码!"),
        NO_OPERATE_ERROR(20001, "无操作权限"),
        ILLEGAL_PARAMETER_ERROR(30001, "非法参数, 前端确认参数类型是否匹配!"),
        LOSE_NECESSARY_ERROR(30002, "缺少必要参数, 请查验接口文档!"),
        SQL_DATA_ERROR(40010, "数据已经录入, 请勿重复添加"),
        SQL_CONNECTION_ERROR(40020, "数据库连接超时!"),
        SQL_DATA_CAST_ERROR(40030, "数据类型异常, 或字段长度异常"),
        SQL_ERROR(40090, "数据库SQL异常");

        /**
         * 成员变量
         */
        private final String name;
        private final int code;

        /**
         * 构造方法
         * @param code code
         * @param name name
         */
        ERROR_CODE(int code, String name) {
            this.name = name;
            this.code = code;
        }

        public int code() {
            return code;
        }

        public String value() {
            return name;
        }
    }


    private final HashMap<Integer, String> errorCode = new HashMap<Integer, String>() {
        {
            put(100, "暂无数据");
            put(200, "成功");
            put(10000, "通用错误");
            ///用户类
            put(10001, "用户名或密码错误");
            put(10002, "登录状态已过期");
            put(10003, "注册用户已存在");
//            put(10004, "账号已被锁定,请在一小时后重试");

            ///操作权限类
            put(20001, "无操作权限");
            ///参数类
            put(30001, "非法参数");
            put(30002, "缺少必要参数");
            ////数据操作类
            put(40001, "添加数据失败");
            put(40002, "更新数据失败");
            put(40003, "删除数据失败");
            put(50001, "不存在的对象");

            put(100001, "钉钉获取用户信息失败，请稍后再试");

            put(990000, "系统错误");
        }
    };


    public ResponseEntity() {
    }

    public ResponseEntity(T date) {
        this.data = date;
    }

    public int getCode() {
        return code;
    }

    public ResponseEntity<T> setCode(int code) {
        this.code = code;
        if (errorCode.containsKey(code)) {
            setMessage(errorCode.get(code));
        }
        return this;
    }

    public String getErrorMessage() {
        return errorMsg;
    }

    public void setErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public ResponseEntity<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResponseEntity<T> def(Class<T> clazz) {
        return new ResponseEntity<>();
    }

    public ResponseEntity<T> ok() {
        setCode(200);
        return this;
    }

    public ResponseEntity<T> error(int code) {
        setCode(code);
        return this;
    }

    public ResponseEntity<T> error(int code, String message) {
        setCode(code);
        setMessage(message);
        return this;
    }

    public ResponseEntity<T> message(String message) {
        setMessage(message);
        return this;
    }

    public ResponseEntity<T> data(T data) {
        setData(data);
        return this;
    }

    public ResponseEntity<T> back(int code, String message, T data) {
        setCode(code);
        setMessage(message);
        setData(data);
        return this;
    }
}
