/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dito
 */
public class Archivo {

    /*
    Metodo: Verifica la existencia de un archivo
     */
    public static boolean verificarExistenciaArchivo(String ruta) {
        return new File(ruta).exists();
    }

    /*
    Metodo: Retorna los valores de un archivo en una lista
     */
    public static List retornarContenidoArchivoList(String ruta) {

        List listadoContenido = new ArrayList();
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            return listadoContenido;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;
            // Se recorre el archivo y se va llenando el LinkedList
            while ((line = br.readLine()) != null) {
                listadoContenido.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoContenido;
    }
    
    /*
    Metodo: Retorna los valores de un archivo con elementos double en una lista
    */
    public static List<Double> retornarContenidoArchivoDouble(String ruta) {

        List<Double> listadoContenido = new ArrayList<Double>();
        File fichero = new File(ruta);
        if (!fichero.exists()) {
            return listadoContenido;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String line;
            while ((line = br.readLine()) != null) {
                listadoContenido.add(Double.valueOf((String)line));
            }
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoContenido;
    }

}
