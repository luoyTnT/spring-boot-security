package com.example.security.util;

import com.example.security.common.exception.BaseException;
import com.example.security.common.exception.SystemRespCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RedisUtil {

    private final StringRedisTemplate stringRedisTemplate;

    public static final String GUID_VERIFY = "guid_verify";

    /**
     * 存入标识和验证码存入redis中
     *
     * @param guid       标识
     * @param verifyCode 验证码
     */
    public void setGuidAndVerifyCode(String guid, String verifyCode) {
        HashOperations<String, String, String> sv = stringRedisTemplate.opsForHash();
        sv.put(GUID_VERIFY, guid, verifyCode);
        stringRedisTemplate.expire(GUID_VERIFY, 1, TimeUnit.MINUTES);
    }

    /**
     * 通过标识获取redis中的验证码
     *
     * @param guid 标识
     * @return 验证码
     */
    public String getVerifyCodeByGuid(String guid) {
        HashOperations<String, String, String> sv = stringRedisTemplate.opsForHash();
        if (Boolean.TRUE.equals(sv.hasKey(GUID_VERIFY, guid))) {
            log.info("从redis获取验证码");
            return sv.get(GUID_VERIFY, guid);
        }
        throw new BaseException(SystemRespCode.FAILED, "验证码已失效!");
    }
}
