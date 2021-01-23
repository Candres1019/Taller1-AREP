package edu.escuelaing.arep;

import edu.escuelaing.arep.util.LinkedListImp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Aplicacion hecha para la lectura de conjuntos via archivos .txt,
 * con la finalidad de sacar su media y desviacion estandar.
 * @author Andres Mateo Calderón Ortega
 */
public class App {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.00");

    // MultiConjuntos -> Cada linea es un conjunto independiente de datos
    // UniConjunto -> Todas las lineas del archivo se consideran como un conjunto completo
    private static String Mode = "MultiConjuntos";
    private static String archivo = "datos.txt";

    /**
     * Metodo principal de la aplicacion.
     */
    public static void main( String[] args ) {
        LectorArchivo lectorArchivo = new LectorArchivo(archivo);
        switch (Mode) {
            case "MultiConjuntos" :
                ArrayList<LinkedListImp> datos = lectorArchivo.leerMultiConjunto();
                for (int i=0; i<datos.size(); i++){
                    CalculadoraEstadistica calculadoraEstadistica = new CalculadoraEstadistica(datos.get(i));
                    System.out.println("-----------------------------------------------");
                    System.out.println("Resultados Conjunto " + (i+1));
                    System.out.println("Media : " + decimalFormat.format(calculadoraEstadistica.calcularMedia()));
                    System.out.println("Desviación Estandar : " + decimalFormat.format(calculadoraEstadistica.calcularDesviacionEstandar()));
                }
                break;
            case "UniConjunto" :
                LinkedListImp datosUni = lectorArchivo.leerUniConjunto();
                CalculadoraEstadistica calculadoraEstadistica = new CalculadoraEstadistica(datosUni);
                System.out.println("-----------------------------------------------");
                System.out.println("Resultados del Conjunto ");
                System.out.println("Media : " + decimalFormat.format(calculadoraEstadistica.calcularMedia()));
                System.out.println("Desviación Estandar : " + decimalFormat.format(calculadoraEstadistica.calcularDesviacionEstandar()));
                break;
        }
    }

    //Metodos Getter y Setter

    public static DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public static void setDecimalFormat(DecimalFormat decimalFormat) {
        App.decimalFormat = decimalFormat;
    }

    public static String getMode() {
        return Mode;
    }

    public static void setMode(String mode) {
        Mode = mode;
    }

    public static String getArchivo() {
        return archivo;
    }

    public static void setArchivo(String archivo) {
        App.archivo = archivo;
    }

    /**
     * Aplicacion hecha para la lectura de los conjuntos de datos mediante archivos .txt
     * @author Andres Mateo Calderón Ortega
     */
    static class LectorArchivo {

        private String nombreArchivo;
        private LinkedListImp datos;
        private FileReader fileReader;
        private BufferedReader bufferedReader;

        /**
         * Constructor de la clase LectorArchivo
         * @param nombreArchivo - Nombre del archivo a abrir.
         */
        public LectorArchivo (String nombreArchivo){
            try {
                this.nombreArchivo = nombreArchivo;
                datos = new LinkedListImp();
                fileReader = new FileReader(nombreArchivo);
                bufferedReader = new BufferedReader(fileReader);
            }catch (Exception e){
                System.out.println("Error al leer el archivo " + nombreArchivo);
            }
        }

        /**
         * Lectura de archivo en modo UniConjunto.
         */
        private LinkedListImp leerUniConjunto(){
            try {
                String linea;
                while((linea=bufferedReader.readLine()) != null){
                    String [] tempData = linea.split(" ");
                    for(String string : tempData){
                        datos.add(Double.valueOf(string));
                    }
                }
                return datos;
            } catch (Exception e) {
                System.out.println("Error en el archivo " + nombreArchivo);
                return null;
            }
        }

        /**
         * Lectura de archivo en modo MultiConjunto.
         */
        private ArrayList<LinkedListImp> leerMultiConjunto(){
            try {
                ArrayList <LinkedListImp> multiConjuntos = new ArrayList<>();
                String linea;
                while((linea=bufferedReader.readLine()) != null){
                    datos = new LinkedListImp();
                    String [] tempData = linea.split(" ");
                    for(String string : tempData){
                        datos.add(Double.valueOf(string));
                    }
                    multiConjuntos.add(datos);
                }
                return multiConjuntos;
            } catch (Exception e) {
                System.out.println("Error en el archivo " + nombreArchivo);
                return null;
            }
        }

    }

}
