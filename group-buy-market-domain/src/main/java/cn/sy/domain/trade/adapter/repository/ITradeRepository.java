package cn.sy.domain.trade.adapter.repository;

import cn.sy.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import cn.sy.domain.trade.model.aggregate.GroupBuyTeamSettlementAggregate;
import cn.sy.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.sy.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.sy.domain.trade.model.entity.MarketPayOrderEntity;
import cn.sy.domain.trade.model.entity.NotifyTaskEntity;
import cn.sy.domain.trade.model.valobj.GroupBuyProgressVO;

import java.util.List;

/**
 * 交易仓储服务接口
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryMarketPayOrderEntityByOutTradeNo(String userId, String outTradeNo);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    GroupBuyActivityEntity queryGroupBuyActivityEntityByActivityId(Long activityId);

    Integer queryOrderCountByActivityId(Long activityId, String userId);

    GroupBuyTeamEntity queryGroupBuyTeamByTeamId(String teamId);

    NotifyTaskEntity settlementMarketPayOrder(GroupBuyTeamSettlementAggregate groupBuyTeamSettlementAggregate);

    boolean isSCBlackIntercept(String source, String channel);

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList();

    List<NotifyTaskEntity> queryUnExecutedNotifyTaskList(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

    boolean occupyTeamStock(String teamStockKey, String recoveryTeamStockKey, Integer target, Integer validTime);

    void recoveryTeamStock(String recoveryTeamStockKey, Integer validTime);

}
