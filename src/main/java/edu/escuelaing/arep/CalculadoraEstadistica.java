package edu.escuelaing.arep;

import edu.escuelaing.arep.util.LinkedListImp;
import edu.escuelaing.arep.util.Node;

/**
 * Aplicacion de la calculadora estadistica, haciendo uso de una lista enlazada
 * implementada desde cero.
 * @author Andres Mateo Calderón Ortega
 */
public class CalculadoraEstadistica {

    private LinkedListImp datos;
    private Double media;
    private Double desviacionEstandar;

    /**
     * Constructor de la clase CalculadoraEstadistica
     */
    public CalculadoraEstadistica(){}

    /**
     * Constructor de la clase CalculadoraEstadistica
     * @param datos - Lista enlazada de los datos que se utilizaran para calcular la media y la desviacion estandar
     */
    public CalculadoraEstadistica (LinkedListImp datos){
        this.datos = datos;
    }

    /**
     * Metodo para calcular la media.
     * @return Media de los datos guardados en la lista enlazada
     */
    public Double calcularMedia(){
        media = 0.0;
        Node head = datos.getHead();
        for(int i=0; i<datos.size(); i++){
            media = media + head.getDatos();
            head = head.getNext();
        }
        media = media / datos.size();
        return media;
    }

    /**
     * Metodo para calcular la desviacion Estandar.
     * @return Desviacion Estandar de los datos guardados en la lista enlazada
     */
    public Double calcularDesviacionEstandar(){
        Double restaCuadradosTemp, suma, division;
        desviacionEstandar = 0.0;
        suma = 0.0;
        calcularMedia();
        Node head = datos.getHead();
        for(int i=0; i<datos.size(); i++){
            restaCuadradosTemp = Math.pow((head.getDatos() - media), 2);
            suma = suma + restaCuadradosTemp;
            head = head.getNext();
        }
        division = suma / (datos.size() - 1);
        desviacionEstandar = Math.sqrt(division);
        return desviacionEstandar;
    }

    /**
     * Metodo getter de la variable datos
     * @return - LinkedListImp de datos
     */
    public LinkedListImp getDatos() {
        return datos;
    }

    /**
     * Metodo setter de la variable datos
     * @param datos - Lista de datos de tipo LinkedListImp
     */
    public void setDatos(LinkedListImp datos) {
        this.datos = datos;
    }
}
