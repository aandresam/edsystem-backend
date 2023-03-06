package com.german.edsystem.utils;

public class Operaciones {

    /*+
     * Calcula el promedio de un arreglo de números de tipo Double;
     * @array Double arreglo de números;
     * @return 0 en caso de que el primer elemento del arreglo sea 0;
     * @return el promedio del arreglo;
     */
    public static double calcularPromedio(Double[] array){
        double value = 0;
        for (Double values : array) {
            if (array[0] == null) {
                return 0;
            }
            value += values;
        }
        return value / array.length;
    }
}
