package com.example.security.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.security.common.exception.BaseException;
import com.example.security.common.exception.RespCode;
import com.example.security.common.utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Response 通用工具类
 */
@Slf4j
public class ResponseUtil {

    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param status   状态
     * @param data     返回数据
     */
    public static void renderJson(HttpServletResponse response, RespCode status, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            // FIXME: hutool 的 BUG：JSONUtil.toJsonStr()
            //  将JSON转为String的时候，忽略null值的时候转成的String存在错误
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(ApiResponse.ofStatus(status, data), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *
     * @param response  响应
     * @param exception 异常
     */
    public static void renderJson(HttpServletResponse response, BaseException exception) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            // FIXME: hutool 的 BUG：JSONUtil.toJsonStr()
            //  将JSON转为String的时候，忽略null值的时候转成的String存在错误
            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(ApiResponse.ofException(exception), false)));
        } catch (IOException e) {
            log.error("Response写出JSON异常，", e);
        }
    }
}
