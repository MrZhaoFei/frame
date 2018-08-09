package org.core.result;

/**
 * @ClassName ResultCode
 * @Author Zhao.Fei
 * @Date 2018/8/9 14:43
 * @Description 状态码枚举类
 */
public enum ResultCode {

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:51
     * @return
     * @Description 操作成功
     **/
    SUCCESS(200, "result.message.success"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:51
     * @return
     * @Description 操作失败
     **/
    FAIL(202, "result.message.fail"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:54
     * @return
     * @Description 参数错误
     **/
    PARAMETER_ERROR(400, "result.message.parameter.error"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:55
     * @return
     * @Description 签名无效，未登录授权
     **/
    UNSIGNATURE(401, "result.message.unsignature"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:56
     * @return
     * @Description 无权限
     **/
    FORBIDDEN(403, "result.message.forbidden"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:57
     * @return
     * @Description 数据不存在
     **/
    DATA_UNEXIST(404, "result.message.data.unexist"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:57
     * @return
     * @Description 数据已存在
     **/
    DATA_EXIST(409, "result.message.data.exist"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:57
     * @return
     * @Description 请求数据格式不支持
     **/
    UNSUPPORTED(415, "result.message.unsupported"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:58
     * @return
     * @Description 系统内部异常
     **/
    SYSTEM_ERROR(500, "result.message.system.error"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 14:58
     * @return
     * @Description  系统方法未定义无法访问
     **/
    SYSTEM_DEFINE(501, "result.message.system.define"),

    /**
     * @Author Zhao.Fei
     * @Param
     * @Date 2018/8/9 15:00
     * @return
     * @Description 超时
     **/
    SYSTEM_TIMEOUT(504, "result.message.gateway.timeout");

    private int value;

    private String message;

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int value, String message) {
        this.value = value;
        this.message = message;
    }
}
