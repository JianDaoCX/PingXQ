package cn.sy.domain.trade.adapter.port;

import cn.sy.domain.trade.model.entity.NotifyTaskEntity;

/**
 * 交易接口服务接口
 */
public interface ITradePort {

    String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception;

}
