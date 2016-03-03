import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Dito
 */
public class MatematicaTest {

    List<Double> lista = Arrays.asList(new Double[]{4.0,5.0});
    List<Double> lista2 = Arrays.asList(new Double[]{8.0,2.0});

    @org.junit.Test
    public void testCalcularMedia() throws Exception {
        assertTrue(Matematica.calcularMedia(lista) == 4.5);
    }

    @org.junit.Test
    public void testsumatoriaDelCuadrado() throws Exception {
        assertTrue(Matematica.sumatoriaDelCuadrado(lista) == 41);
    }

    @org.junit.Test
    public void testsumatoriaListaXListaDouble() throws Exception {
        assertTrue(Matematica.sumatoriaListaXListaDouble(lista,lista2) == 42);
    }

    @org.junit.Test
    public void testcalcularB1() throws Exception {
        assertTrue(Matematica.calcularB1(lista,lista2) == -6.0);
    }

    @org.junit.Test
    public void testcalcularB0() throws Exception {
        double b1 = -6.0;
        assertTrue(Matematica.calcularB0(lista,lista2) == 32.0);
    }

    @org.junit.Test
    public void testcalcularR() throws Exception {
        assertTrue(Matematica.calcularR(lista,lista2) == -1.0);
    }
}