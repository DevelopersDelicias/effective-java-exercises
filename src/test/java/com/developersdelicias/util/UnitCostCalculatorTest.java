package com.developersdelicias.util;


import com.developersdelicias.model.PurchaseOrder;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UnitCostCalculatorTest {
    public static final int DEFAULT_QUANTITY_PER_PACKAGE = 24;
    PurchaseOrder purchaseOrder = new PurchaseOrder(2.99088d, DEFAULT_QUANTITY_PER_PACKAGE);
    UnitCostCalculator calculator = new UnitCostCalculator();


    @Test
    @Parameters(method = "dataForCalculateUnitCost")
    public void should_return_unit_cost_rounded_to_four_decimals_when_unit_cost_code_is_null(
            String unitCost, PurchaseOrder purchaseOrder, Double expectedResult) throws Exception {
        assertThat(calculator.calculate(purchaseOrder, unitCost), is(expectedResult));
    }

    @Test
    public void should_return_acquisition_cost_when_unit_cost_code_is_PK() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, "PK"), is(2.99));
        purchaseOrder.setAcquisitionCost(1.318d);
        assertThat(calculator.calculate(purchaseOrder, "PK"), is(1.31d));
    }

    @SuppressWarnings("unused")
    private Object[] dataForCalculateUnitCost() {
        return new Object[]{
                new Object[]{null, new PurchaseOrder(2.99088d, DEFAULT_QUANTITY_PER_PACKAGE), 0.1246},
                new Object[]{null, new PurchaseOrder(2.988432d, DEFAULT_QUANTITY_PER_PACKAGE), 0.1245},
                new Object[]{"UN", new PurchaseOrder(2.99088d, DEFAULT_QUANTITY_PER_PACKAGE), 0.1246},
                new Object[]{"UN", new PurchaseOrder(2.988432d, DEFAULT_QUANTITY_PER_PACKAGE), 0.1245},
        };
    }

}
