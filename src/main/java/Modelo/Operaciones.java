/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author April
 */
public abstract class Operaciones implements OperacionMatematica{
    private int num1;
    private int num2;

    public Operaciones() {
        num1 = 0;
        num2 = 0;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public void generarNumeros(int max){
        Random random = new Random();
        
        num1 = random.nextInt(max + 1);
        num2 = random.nextInt(max + 1);
    }
    
    public boolean validarEntrada(String texto){
        if (texto == null || texto.length() == 0){
            return false;
        }
        
        for  (int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) < '0' || texto.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}
