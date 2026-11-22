/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author April
 */
public class Resta extends Operaciones{
    private String[] preguntas = {};
    
    private int[] respuestas = {};
    

    @Override
    public int calcularResultado(int a, int b) {
        return a - b;
    }

    @Override
    public String obtenerInformacion(int a, int b) {
        return "Para restar juntamos dos cantidades " + a + " - " + b + " = " + (a - b);
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
    @Override
public void generarNumeros(int max) {
    super.generarNumeros(max);
    if (getNum1() < getNum2()) {        // el mayor siempre va primero
        int temp = getNum1();
        setNum1(getNum2());
        setNum2(temp);
    }
}
}
