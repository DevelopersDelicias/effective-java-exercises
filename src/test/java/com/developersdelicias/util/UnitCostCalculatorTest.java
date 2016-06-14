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
    public static final double ACQUISITION_COST = 2.99088d;
    PurchaseOrder purchaseOrder = new PurchaseOrder(2.99088d, 24);
    UnitCostCalculator calculator = new UnitCostCalculator();

    @Before
    public void setUp() throws Exception {
        //purchaseOrder.setAcquisitionCost(ACQUISITION_COST);
        //purchaseOrder.setQuantityPerPackage(24);
    }

    @Test
    @Parameters(method = "dataForCalculateUnitCost")
    public void should_return_unit_cost_rounded_to_four_decimals_when_unit_cost_code_is_null(
            String unitCost, PurchaseOrder purchaseOrder, Double expectedResult) throws Exception {
        assertThat(calculator.calculate(purchaseOrder, unitCost), is(expectedResult));
        //purchaseOrder.setAcquisitionCost(2.988432d);
        //assertThat(calculator.calculate(purchaseOrder, null), is(0.1245));
    }

    @Test
    public void should_return_unit_cost_rounded_to_four_decimals_when_unit_cost_code_is_UN() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, "UN"), is(0.1246));
        purchaseOrder.setAcquisitionCost(2.988432d);
        assertThat(calculator.calculate(purchaseOrder, "UN"), is(0.1245));
    }

    @Test
    public void should_return_acquisition_cost_when_unit_cost_code_is_PK() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, "PK"), is(2.99));
    }

    protected Object[] dataForCalculateUnitCost() {
        return new Object[]{
                new Object[]{null, new PurchaseOrder(2.99088d, 24), 0.1246},
                new Object[]{null, new PurchaseOrder(2.988432d, 24), 0.1245}
        };
    }

}
