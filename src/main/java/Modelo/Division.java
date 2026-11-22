/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

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

   @Override
public void generarNumeros(int max) {
    Random random = new Random();
    int divisor = random.nextInt(max) + 1;      // nunca 0
    int cociente = random.nextInt(max + 1);
    setNum2(divisor);
    setNum1(divisor * cociente);                // división siempre exacta
}
    
    public int cantidadPreguntas(){
        return preguntas.length;
    }
}
