/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author April
 */
public class Multiplicacion extends Operaciones{
    private String[] preguntas = {};
    
    private int[] respuestas = {};
    

    @Override
    public int calcularResultado(int a, int b) {
        return a * b;
    }

    @Override
    public String obtenerInformacion(int a, int b) {
        return "Para sumar juntamos dos cantidades " + a + " x " + b + " = " + (a * b);
    }

    public String getPreguntas(int posicion) {
        return preguntas[posicion];
    }

    public int getRespuestas(int posicion) {
        return respuestas[posicion];
    }
    
    public int cantidadPreguntas(){
        return preguntas.length;
    }
}
