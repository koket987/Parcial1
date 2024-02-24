package edu.eci.cvds.tdd.aerodescuentos;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import org.junit.Assert;
import org.junit.Test;

public class aerodescuentosTest {
    private CalculadorDescuentos calculos = new CalculadorDescuentos();

    @Test
    public void validateDaysAntelation() {
        double calculoTotal = calculos.calculoTarifa(100,0,25);
        boolean descuento = calculoTotal == 100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,-10,25);
        descuento = calculoTotal==100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,19,25);
        descuento = calculoTotal==100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,20,25);
        descuento = calculoTotal==100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,25);
        descuento = calculoTotal==85;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,4000,25);
        descuento = calculoTotal==85;
        Assert.assertTrue(descuento);
     }
    @Test
    public void validateAge() {
        double calculoTotal = calculos.calculoTarifa(100,10,30);
        boolean descuento = calculoTotal == 100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,18);
        descuento = calculoTotal==100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,17);
        descuento = calculoTotal==95;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,-100);
        descuento = calculoTotal==95;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,65);
        descuento = calculoTotal==100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,66);
        descuento = calculoTotal==92;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,10,150);
        descuento = calculoTotal==92;
        Assert.assertTrue(descuento);
    }
    @Test
    public void validateAgeAndDaysAdvance() {
        double calculoTotal = calculos.calculoTarifa(100,10,30);
        boolean descuento = calculoTotal == 100;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,17);
        descuento = calculoTotal==80;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,66);
        descuento = calculoTotal==77;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,20,80);
        descuento = calculoTotal==92;
        //Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,65);
        descuento = calculoTotal==85;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,20,17);
        descuento = calculoTotal==95;
        //Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,18);
        descuento = calculoTotal==85;
        calculoTotal = calculos.calculoTarifa(100,10,150);
        descuento = calculoTotal==92;
        Assert.assertTrue(descuento);
        calculoTotal = calculos.calculoTarifa(100,21,150);
        descuento = calculoTotal==77;
        Assert.assertTrue(descuento);
    }
}
