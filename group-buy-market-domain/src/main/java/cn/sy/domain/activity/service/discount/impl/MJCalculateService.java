package cn.sy.domain.activity.service.discount.impl;

import cn.sy.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.sy.domain.activity.service.discount.AbstractDiscountCalculateService;
import cn.sy.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 满减优惠计算
 */
@Slf4j
@Service("MJ")
public class MJCalculateService extends AbstractDiscountCalculateService {

    @Override
    public BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        log.info("优惠策略折扣计算:{}", groupBuyDiscount.getDiscountType().getCode());

        // 折扣表达式 - 100,10 满100减10元
        String marketExpr = groupBuyDiscount.getMarketExpr();
        String[] split = marketExpr.split(Constants.SPLIT);
        BigDecimal x = new BigDecimal(split[0].trim());
        BigDecimal y = new BigDecimal(split[1].trim());

        // 不满足最低满减约束，则按照原价
        if (originalPrice.compareTo(x) < 0) {
            return originalPrice;
        }

        // 折扣价格
        BigDecimal deductionPrice = originalPrice.subtract(y);

        // 判断折扣后金额，最低支付1分钱
        if (deductionPrice.compareTo(BigDecimal.ZERO) <= 0) {
            return new BigDecimal("0.01");
        }

        return deductionPrice;
    }

}
