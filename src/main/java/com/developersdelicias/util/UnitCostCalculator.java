package com.developersdelicias.util;

import com.developersdelicias.model.PurchaseOrder;

import static com.developersdelicias.util.RoundNumberUtil.round;
import static com.developersdelicias.util.RoundNumberUtil.roundToFourDecimals;

public class UnitCostCalculator {
    public double calculate(PurchaseOrder purchaseOrder, String unitCostCode) {

        return unitCostCode == null || unitCostCode.equals("UN") ?
                roundToFourDecimals(purchaseOrder.getUnitCost()) :
                round(purchaseOrder.getAcquisitionCost(), 2);
    }
}
