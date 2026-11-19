/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author user
 */
public class Division extends Operaciones{
    private String[] preguntas = {};
    
    private int[] respuestas = {};
    

    @Override
    public int calcularResultado(int a, int b) {
        if(b != 0){
            return a / b;
        }
        return 0;
    }

    @Override
    public String obtenerInformacion(int a, int b) {
        if(b != 0){
        return "Dividir significa repartir en partes iguales " + a + " ÷ " + b + " = " + (a / b);
        }
        return "no se puede dividir entre cero. ";
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
