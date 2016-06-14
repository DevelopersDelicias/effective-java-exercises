package com.developersdelicias.util;

import com.developersdelicias.model.PurchaseOrder;

import static com.developersdelicias.util.RoundNumberUtil.round;
import static com.developersdelicias.util.RoundNumberUtil.roundToFourDecimals;
import static com.developersdelicias.util.TruncateNumberUtil.truncate;

public class UnitCostCalculator {

    public static final int TWO_DECIMALS = 2;

    public double calculate(PurchaseOrder purchaseOrder, String unitCostCode) {

        return unitCostCode == null || unitCostCode.equals("UN") ?
                roundToFourDecimals(purchaseOrder.getUnitCost()) :
                truncate(purchaseOrder.getAcquisitionCost(), TWO_DECIMALS);
    }
}
