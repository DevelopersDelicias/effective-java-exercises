package com.developersdelicias.util;


import com.developersdelicias.model.PurchaseOrder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitCostCalculatorTest {
    public static final double ACQUISITION_COST = 2.99088d;
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    UnitCostCalculator calculator = new UnitCostCalculator();

    @Before
    public void setUp() throws Exception {
        purchaseOrder.setAcquisitionCost(ACQUISITION_COST);
        purchaseOrder.setQuantityPerPackage(24);
    }

    @Test
    public void should_return_unit_cost_rounded_to_four_decimals_when_unit_cost_code_is_null() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, null), is(0.1246));
        purchaseOrder.setAcquisitionCost(2.988432d);
        assertThat(calculator.calculate(purchaseOrder, null), is(0.1245));
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

}
