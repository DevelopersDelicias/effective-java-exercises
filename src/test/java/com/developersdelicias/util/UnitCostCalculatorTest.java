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
    public void should_divide_acquisition_cost_by_number_of_units_when_unit_cost_code_is_unit() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, "UN"), is(0.1246));
        purchaseOrder.setAcquisitionCost(2.988432d);
        assertThat(calculator.calculate(purchaseOrder, "UN"), is(0.1245));
    }

    @Test
    public void should_retrieve_acquisition_cost_when_unit_cost_code_is_package() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, "PK"), is(2.99));
    }

    @Test
    public void should_divide_acquisition_cost_by_number_of_units_when_unit_cost_code_is_null() throws Exception {
        assertThat(calculator.calculate(purchaseOrder, null), is(0.1246));
        purchaseOrder.setAcquisitionCost(2.988432d);
        assertThat(calculator.calculate(purchaseOrder, null), is(0.1245));
    }
}
