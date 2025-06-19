package cn.sy.api;

import cn.sy.api.dto.LockMarketPayOrderRequestDTO;
import cn.sy.api.dto.LockMarketPayOrderResponseDTO;
import cn.sy.api.dto.SettlementMarketPayOrderRequestDTO;
import cn.sy.api.dto.SettlementMarketPayOrderResponseDTO;
import cn.sy.api.response.Response;

/**
 * 营销交易服务接口
 */
public interface IMarketTradeService {

    /**
     * 营销锁单
     *
     * @param requestDTO 锁单商品信息
     * @return 锁单结果信息
     */
    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO requestDTO);

    /**
     * 营销结算
     *
     * @param requestDTO 结算商品信息
     * @return 结算结果信息
     */
    Response<SettlementMarketPayOrderResponseDTO> settlementMarketPayOrder(SettlementMarketPayOrderRequestDTO requestDTO);

}
