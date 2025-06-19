package cn.sy.api;

import cn.sy.api.response.Response;

/**
 * 动态配置中心
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
