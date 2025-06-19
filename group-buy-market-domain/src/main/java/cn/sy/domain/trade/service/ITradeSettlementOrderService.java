package cn.sy.domain.trade.service;

import cn.sy.domain.trade.model.entity.NotifyTaskEntity;
import cn.sy.domain.trade.model.entity.TradePaySettlementEntity;
import cn.sy.domain.trade.model.entity.TradePaySuccessEntity;

import java.util.Map;

/**
 * 拼团交易结算服务接口
 */
public interface ITradeSettlementOrderService {

    /**
     * 营销结算
     *
     * @param tradePaySuccessEntity 交易支付订单实体对象
     * @return 交易结算订单实体
     */
    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity) throws Exception;

    /**
     * 执行结算通知任务
     *
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execSettlementNotifyJob() throws Exception;

    /**
     * 执行结算通知任务
     *
     * @param teamId 指定结算组ID
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execSettlementNotifyJob(String teamId) throws Exception;

    /**
     * 执行结算通知任务
     *
     * @param notifyTaskEntity 通知任务对象
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execSettlementNotifyJob(NotifyTaskEntity notifyTaskEntity) throws Exception;

}
