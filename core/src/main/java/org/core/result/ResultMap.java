package org.core.result;

import org.core.message.SystemMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName ResultMap
 * @Author Zhao.Fei
 * @Date 2018/8/9 15:13
 * @Description 返回结果集
 */
public class ResultMap {
    private final static String total = "total";

    private final static String rows = "rows";

    /**
     * @Author Zhao.Fei
     * @Param [code, message]
     * @Date 2018/8/9 15:24
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description  采用自定义消息 无数据实体 用于无数据返回
     **/
    public static Map<String, Object> convertMap(ResultCode code, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.message.key"), message);
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code]
     * @Date 2018/8/9 15:24
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用内定消息 无数据实体 用于无数据返回
     **/
    public static Map<String, Object> convertMap(ResultCode code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, body]
     * @Date 2018/8/9 15:16
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用内定消息 有数据实体 用于单条
     **/
    public static Map<String, Object> convertMap(ResultCode code, Object body) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, body, message]
     * @Date 2018/8/9 15:16
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用自定义消息 有数据实体 用于单条
     **/
    public static Map<String, Object> convertMap(ResultCode code, Object body, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), message);
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, total, data]
     * @Date 2018/8/9 15:21
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用内定消息 有数据实体 用于多条
     **/
    public static Map<String, Object> convertMap(ResultCode code, Integer total, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put(ResultMap.total, total);
        body.put(ResultMap.rows, data);
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, total, data, message]
     * @Date 2018/8/9 15:21
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用自定义消息 有数据实体 用于多条
     **/
    public static Map<String, Object> convertMap(ResultCode code, Integer total, Object data, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put(ResultMap.total, total);
        body.put(ResultMap.rows, data);
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), message);
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, body, message, otherMap]
     * @Date 2018/8/9 15:19
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用自定义消息 有数据实体 用于单条，及其它实体
     **/
    public static Map<String, Object> convertMap(ResultCode code, Object body, String message,
                                                 Map<String, Object> otherMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), message);
        for (Entry<String, Object> entry : otherMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, total, data, otherMap]
     * @Date 2018/8/9 15:22
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 采用内定消息 有数据实体 用于多条，及其它实体
     **/
    public static Map<String, Object> convertMap(ResultCode code, Integer total, Object data,Map<String, Object> otherMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put(ResultMap.total, total);
        body.put(ResultMap.rows, data);
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
        for (Entry<String, Object> entry : otherMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    /**
     * @Author Zhao.Fei
     * @Param [code, total, data, message, otherMap]
     * @Date 2018/8/9 15:23
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description  采用自定义消息 有数据实体 用于多条，及其它实体
     **/
    public static Map<String, Object> convertMap(ResultCode code, Integer total, Object data, String message,Map<String, Object> otherMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put(ResultMap.total, total);
        body.put(ResultMap.rows, data);
        map.put(SystemMessage.bundle("result.code.key"), code.getValue());
        map.put(SystemMessage.bundle("result.date.key"), body);
        map.put(SystemMessage.bundle("result.message.key"), message);
        for (Entry<String, Object> entry : otherMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

}
