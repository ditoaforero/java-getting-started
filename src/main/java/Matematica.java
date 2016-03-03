/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dito
 */
public class Matematica {

    /*
    Metodo: Calcula la media de un listado de registros pasados en un List
    */
    public static double calcularMedia(List<Double> listadoValores) {
        double sumatoria = 0;
        sumatoria = sumatoria(listadoValores);
        return (double) sumatoria / listadoValores.size();
    }

    /*
    Metodo: Calcula la desviación standart a partir de los valres recibidos en un List
    */
    public static double calcularDesviacionEstandar(List listadoValores) {
        ArrayList ll = (ArrayList) listadoValores;
        double varianza = Matematica.calcularVarianza(ll);
        return (double) Math.pow(varianza, 0.5);
    }


    /*
    Metodo: Calcular varianza, calcula la varianza a partir de los valores recibidos en un List
    */
    public static double calcularVarianza(List listadoValores) {
        ArrayList ll = (ArrayList) listadoValores;
        int cantidadNumeros = 0;
        double media = Matematica.calcularMedia(ll);
        double base = 0;
        double sumatoria = 0;
        for (Object valor : ll) {
            if (esNumerico(valor)) {
                cantidadNumeros++;
                base = (double) Double.valueOf((String) valor) - media;
                sumatoria = (double) sumatoria + Math.pow(base, 2);
            }
        }
        return (double) sumatoria / (cantidadNumeros-1);
    }
    
    /*
    Metodo: Calcula la sumatoria de una lista de double
    */
    public static double sumatoria(List<Double> listadoValores){
        double sumatoria = 0;
        sumatoria = listadoValores.stream().map((valor) -> valor).reduce(sumatoria, (accumulator, _item) -> accumulator + _item);
        return sumatoria;
    }
    
    /*
    Metodo: Calcula la sumatoria de los numero al cuadrado de un List
    */
    public static double sumatoriaDelCuadrado(List<Double> listadoValores){
        double sumatoria = 0;
        sumatoria = listadoValores.stream().map((valor) -> Math.pow(valor, 2)).reduce(sumatoria, (accumulator, _item) -> accumulator + _item);
        return sumatoria;
    }
    
    /*
    Metodo: Calcula la sumatoria de los valores multiplicados de los listas
    */
    public static double sumatoriaListaXListaDouble(List<Double> listadoValoresIzq, List<Double> listadoValoresDer){
        double sumatoria = 0;
        for (int i = 0; i < listadoValoresIzq.size(); i++) {
            sumatoria += listadoValoresIzq.get(i) * listadoValoresDer.get(i);
        }
        return sumatoria;
    }
    
    /*
    Metodo: Calcula B1
    */
    public static double calcularB1(List<Double> listadoValoresIzq, List<Double> listadoValoresDer){
        double b1 = 0;
        double sumatoriaXY = 0;
        double mediaX = 0;
        double mediaY = 0;
        double sumatoriax2;
        double dividendo = 0;
        double divisor = 0;
        int numeroRegistros = 0;
        
        sumatoriaXY=sumatoriaListaXListaDouble(listadoValoresIzq, listadoValoresDer);
        numeroRegistros = listadoValoresIzq.size();
        mediaX = calcularMedia(listadoValoresIzq);
        mediaY = calcularMedia(listadoValoresDer);
        sumatoriax2 = sumatoriaDelCuadrado(listadoValoresIzq);
        
        dividendo = sumatoriaXY-(numeroRegistros*mediaX*mediaY);
        divisor = sumatoriax2-(numeroRegistros*Math.pow(mediaX, 2));
        
        return dividendo/divisor;
    }
    
    /*
    Metodo: Calcula B0
    */
    public static double calcularB0(List<Double> listadoValoresIzq, List<Double> listadoValoresDer){
        double mediaX = 0;
        double mediaY = 0;
        double b1 = 0;
        mediaX = calcularMedia(listadoValoresIzq);
        mediaY = calcularMedia(listadoValoresDer);
        b1 = calcularB1(listadoValoresIzq, listadoValoresDer);
        
        return mediaY-(b1*mediaX);
    }
    
    /*
    Metodo: Calcula R
    */
    public static double calcularR(List<Double> listadoValoresIzq, List<Double> listadoValoresDer){
        double numeroRegistros = 0;
        double sumatoriaXY = 0;
        double sumatoriaX = 0;
        double sumatoriaY = 0;
        double sumatoriax2 = 0;
        double sumatoriay2 = 0;
        double dividendo = 0;
        double divisorP1 = 0;
        double divisorP2 = 0;
        double divisor = 0; 
        
        numeroRegistros = listadoValoresIzq.size();
        sumatoriaXY=sumatoriaListaXListaDouble(listadoValoresIzq, listadoValoresDer);
        sumatoriaX = sumatoria(listadoValoresIzq);
        sumatoriaY = sumatoria(listadoValoresDer);
        sumatoriax2 = sumatoriaDelCuadrado(listadoValoresIzq);
        sumatoriay2 = sumatoriaDelCuadrado(listadoValoresDer);
        
        dividendo = (numeroRegistros*sumatoriaXY)-(sumatoriaX*sumatoriaY);
        divisorP1 = (numeroRegistros*sumatoriax2)-(Math.pow(sumatoriaX, 2));
        divisorP2 = (numeroRegistros*sumatoriay2)-(Math.pow(sumatoriaY, 2));
        divisor = divisorP1*divisorP2;
        divisor = Math.sqrt(divisor);
        
        
        return dividendo/divisor;
    }
    
    /*
    Metodo: Calcula R al cuadrado
    */
    public static double calcularR2(List<Double> listadoValoresIzq, List<Double> listadoValoresDer){
        double numeroRegistros = 0;
        double sumatoriaXY = 0;
        double sumatoriaX = 0;
        double sumatoriaY = 0;
        double sumatoriax2 = 0;
        double sumatoriay2 = 0;
        double dividendo = 0;
        double divisorP1 = 0;
        double divisorP2 = 0;
        double divisor = 0; 
        
        numeroRegistros = listadoValoresIzq.size();
        sumatoriaXY=sumatoriaListaXListaDouble(listadoValoresIzq, listadoValoresDer);
        sumatoriaX = sumatoria(listadoValoresIzq);
        sumatoriaY = sumatoria(listadoValoresDer);
        sumatoriax2 = sumatoriaDelCuadrado(listadoValoresIzq);
        sumatoriay2 = sumatoriaDelCuadrado(listadoValoresDer);
        
        dividendo = (numeroRegistros*sumatoriaXY)-(sumatoriaX*sumatoriaY);
        divisorP1 = (numeroRegistros*sumatoriax2)-(Math.pow(sumatoriaX, 2));
        divisorP2 = (numeroRegistros*sumatoriay2)-(Math.pow(sumatoriaY, 2));
        divisor = divisorP1*divisorP2;
        divisor = Math.sqrt(divisor);
        
        
        return Math.pow(dividendo/divisor, 2);
    }
    
    /*
    Metodo: Calcula P
    */
    public static double calcularP(List<Double> listadoValoresIzq, List<Double> listadoValoresDer, double esperanza){
        double b0;
        double b1;
        
        b0 = calcularB0(listadoValoresIzq, listadoValoresDer);
        b1 = calcularB1(listadoValoresIzq, listadoValoresDer);
        
        return b0+b1*esperanza;
    }
    


    /*
    Metodo: verifica si el valor recibido es numerico
    */
    private static boolean esNumerico(Object valor) {
        try {
            Double.valueOf((String) valor);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
