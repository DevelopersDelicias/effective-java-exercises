package com.developersdelicias.util;

import com.developersdelicias.model.PurchaseOrder;

import static com.developersdelicias.util.RoundNumberUtil.round;
import static com.developersdelicias.util.RoundNumberUtil.roundToFourDecimals;

public class UnitCostCalculator {
    public double calculate(PurchaseOrder purchaseOrder, String unitCostCode) {
        if (unitCostCode == null || unitCostCode.equals("UN")) {
            return roundToFourDecimals(purchaseOrder.getUnitCost());
        }
        return round(purchaseOrder.getAcquisitionCost(), 2);
    }
}
