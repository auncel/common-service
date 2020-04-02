package dev.yidafu.auncel.common.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import dev.yidafu.auncel.common.api.SessionService;
import dev.yidafu.auncel.common.api.response.PlainResult;
import dev.yidafu.auncel.common.api.response.PlainResults;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * invoke SessionService.create("AUNCEL04564211eb26f810c80e", {username: "test1", password: "encodepassword", email: "xx@qq.com"})
 * invoke SessionService.getAll("AUNCEL04564211eb26f810c80e")
 */
@Service
public class SessionServiceImpl implements SessionService {

    /**
     * @url https://blog.csdn.net/zhaoheng314/article/details/81564166
     */
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public PlainResult<JSONObject> getAll(String sessionId) {
        ValueOperations<String, JSONObject> ops = redisTemplate.opsForValue();
        JSONObject json = ops.get(sessionId);
        return PlainResults.success(json, "get all session data by SESSIONID");
    }

    @Override
    public PlainResult<Boolean> create(String sessionId, Object userData) {
        ValueOperations<String, JSONObject> ops = redisTemplate.opsForValue();
        ops.set(sessionId, (JSONObject) JSON.toJSON(userData));
        return PlainResults.success(true, "create a new SESSIONID");
    }

    @Override
    public PlainResult<Boolean> delAll(String sessionId) {
        ValueOperations<String, JSONObject> ops = redisTemplate.opsForValue();
        redisTemplate.delete(sessionId);
        return PlainResults.success(true, "delete all session data by SESSIONID");
    }
}
