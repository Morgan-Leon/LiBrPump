package lyn.librpump.kernel.formular;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lyn on 16/5/8.
 */
public class FormularTest {
    private Formular formular = new Formular();

    @Test
    public void testConversionT_C2K() throws Exception {
        System.out.print(conversionT_C2K(0));
        assertEquals(273.15,conversionT_C2K(0),0.0001);

    }

    @Test
    public void testConversionT_K2C() throws Exception {

    }

    @Test
    public void testConversion_P_lgmmHg2kPa() throws Exception {

    }

    @Test
    public void testLgsvp() throws Exception {

    }

    @Test
    public void testSaturationTemperatureH2O() throws Exception {

    }

    @Test
    public void testConversionQ_kCal2kJ() throws Exception {

    }

    @Test
    public void test_H2O_latentHeatOfVaporization() throws Exception {

    }

    @Test
    public void test_H2O_enthalpy() throws Exception {
        assertEquals(4,_H2O_enthalpy(1),0.001);
    }

    @Test
    public void test_H2OVapor_enthalpy() throws Exception {
        assertEquals(2500.79, _H2OVapor_enthalpy(1), 0.001);

    }

    @Test
    public void test_H2OHeat_enthalpy() throws Exception {
        assertEquals(2675.0067, _H2OHeat_enthalpy(100, 100), 0.001);
    }

    @Test
    public void testDewTLiBr() throws Exception {

    }

    @Test
    public void test_concentration_LiBrSolution() throws Exception {

    }

    @Test
    public void testEnthalpyLiBrSolution() throws Exception {

    }

    @Test
    public void testTemperaturLiBrSolution() throws Exception {

    }
}