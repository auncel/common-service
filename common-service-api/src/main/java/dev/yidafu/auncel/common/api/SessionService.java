package dev.yidafu.auncel.common.api;

import dev.yidafu.auncel.common.api.response.PlainResult;
import com.alibaba.fastjson.JSONObject;
import dev.yidafu.auncel.user.center.api.dto.UserDTO;

public interface SessionService {
    /**
     * 获取 session 数据
     */
    PlainResult<JSONObject> getAll(String sessionId);

    PlainResult<Boolean> create(String sessionId,Object userData);

    PlainResult<Boolean> delAll(String sesstionId);
}
