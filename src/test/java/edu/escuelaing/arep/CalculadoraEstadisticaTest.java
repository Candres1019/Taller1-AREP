package edu.escuelaing.arep;

import edu.escuelaing.arep.util.LinkedListImp;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CalculadoraEstadisticaTest {

    private ArrayList<LinkedListImp> datos;
    private CalculadoraEstadistica calculadoraEstadistica;
    private static DecimalFormat decimalFormat = new DecimalFormat("#.00");

    @Before
    public void setUp() {
        datos = new ArrayList<>();
        calculadoraEstadistica = new CalculadoraEstadistica();
        LinkedListImp datos1 = new LinkedListImp();
        datos1.addLast(160.0);
        datos1.addLast(591.0);
        datos1.addLast(114.0);
        datos1.addLast(229.0);
        datos1.addLast(230.0);
        datos1.addLast(270.0);
        datos1.addLast(128.0);
        datos1.addLast(1657.0);
        datos1.addLast(624.0);
        datos1.addLast(1503.0);
        LinkedListImp datos2 = new LinkedListImp();
        datos2.addLast(15.0);
        datos2.addLast(69.9);
        datos2.addLast(6.5);
        datos2.addLast(22.4);
        datos2.addLast(28.4);
        datos2.addLast(65.9);
        datos2.addLast(19.4);
        datos2.addLast(198.7);
        datos2.addLast(38.8);
        datos2.addLast(138.2);
        LinkedListImp datos3 = new LinkedListImp();
        datos3.addLast(186.0);
        datos3.addLast(699.0);
        datos3.addLast(132.0);
        datos3.addLast(272.0);
        datos3.addLast(291.0);
        datos3.addLast(331.0);
        datos3.addLast(199.0);
        datos3.addLast(1890.0);
        datos3.addLast(788.0);
        datos3.addLast(1601.0);
        datos.add(datos1);
        datos.add(datos2);
        datos.add(datos3);
    }

    @Test
    public void deberiaCalcularMedia1(){
        calculadoraEstadistica.setDatos(datos.get(0));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularMedia()).equals("550,60"));
    }

    @Test
    public void deberiaCalcularMedia2(){
        calculadoraEstadistica.setDatos(datos.get(1));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularMedia()).equals("60,32"));
    }

    @Test
    public void deberiaCalcularMedia3(){
        calculadoraEstadistica.setDatos(datos.get(2));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularMedia()).equals("638,90"));
    }

    @Test
    public void deberiaCalcularDesviacion1(){
        calculadoraEstadistica.setDatos(datos.get(0));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularDesviacionEstandar()).equals("572,03"));
    }

    @Test
    public void deberiaCalcularDesviacion2(){
        calculadoraEstadistica.setDatos(datos.get(1));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularDesviacionEstandar()).equals("62,26"));
    }

    @Test
    public void deberiaCalcularDesviacion3(){
        calculadoraEstadistica.setDatos(datos.get(2));
        Assert.assertTrue(decimalFormat.format(calculadoraEstadistica.calcularDesviacionEstandar()).equals("625,63"));
    }

}