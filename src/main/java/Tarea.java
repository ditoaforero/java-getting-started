import java.text.DecimalFormat;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Dito
 */
public class Tarea {
    public static String ejecutarTest(String nombreTest,List<Double> listadoX, List<Double> listadoY) {

        DecimalFormat decimales = new DecimalFormat("0.0000");

        double B1 = Matematica.calcularB1(listadoX, listadoY);
        double B0 = Matematica.calcularB0(listadoX, listadoY);
        double R =  Matematica.calcularR(listadoX, listadoY);
        double R2 = Matematica.calcularR2(listadoX, listadoY);
        double P =  Matematica.calcularP(listadoX, listadoY, 386);

        String result = nombreTest + " B0=" + decimales.format(B0)  + " B1=" + decimales.format(B1) + " R=" + decimales.format(R) + " R2=" + decimales.format(R2) + " P=" + decimales.format(P);
        return result;
    }

}
