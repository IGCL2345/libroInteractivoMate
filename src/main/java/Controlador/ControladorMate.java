/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Division;
import Modelo.Multiplicacion;
import Modelo.Operaciones;
import Modelo.Resta;
import Modelo.Suma;
import Vista.VistaActividad;
import Vista.VistaInstrucciones;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random; // ver linea 189
import javax.swing.JOptionPane;

/**
 *
 * @author April
 */


public class ControladorMate implements ActionListener {

    // VISTAS
    private VistaMenu menu = new VistaMenu();
    private VistaInstrucciones instrucciones = new VistaInstrucciones();
    private VistaActividad actividad = new VistaActividad();

    // MODELO (Suma, Resta, Multiplicacion o Division)
    private Operaciones operacion;
    private String nombre;
    private String simbolo;

    // CONTROL DEL NIVEL
    private final int MAX = 10;
    private final int TOTAL_PREGUNTAS = 5;
    private int preguntaActual = 1;

    public ControladorMate() {
        menu.addMenuListener(this);
        instrucciones.addContinuarListener(this);
        actividad.addListener(this);
    }

    public void inicio() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "SUMA":
                elegirNivel(new Suma(), "Suma", "+");
                break;

            case "RESTA":
                elegirNivel(new Resta(), "Resta", "-");
                break;

            case "MULTIPLICACION":
                elegirNivel(new Multiplicacion(), "Multiplicación", "x");
                break;

            case "DIVISION":
                elegirNivel(new Division(), "División", "÷");
                break;

            case "CONTINUAR":
                instrucciones.setVisible(false);
                preguntaActual = 1;
                nuevaPregunta();
                actividad.setLocationRelativeTo(null);
                actividad.setVisible(true);
                break;

            case "OPCION1":
                comprobar(1);
                break;

            case "OPCION2":
                comprobar(2);
                break;

            case "OPCION3":
                comprobar(3);
                break;

            case "OPCION4":
                comprobar(4);
                break;

            case "MENU":
                actividad.setVisible(false);
                menu.setVisible(true);
                break;

            case "SALIR":
                System.exit(0);
                break;
        }
    }

    // Guarda la operación elegida y muestra sus instrucciones.
    private void elegirNivel(Operaciones op, String nombre, String simbolo) {
        this.operacion = op;
        this.nombre = nombre;
        this.simbolo = simbolo;

        // 6 y 2 funcionan en las cuatro operaciones.
        String texto = op.obtenerInformacion(6, 2);
        instrucciones.mostrar(nombre, texto);

        menu.setVisible(false);
        instrucciones.setLocationRelativeTo(null);
        instrucciones.setVisible(true);
    }

    // Genera una pregunta nueva con sus 4 opciones.
    private void nuevaPregunta() {
        operacion.generarNumeros(MAX);

        int correcta = operacion.calcularResultado(
                operacion.getNum1(), operacion.getNum2());

        actividad.mostrarPregunta(
                nombre,
                operacion.getNum1() + " " + simbolo + " " + operacion.getNum2() + " = ?",
                generarOpciones(correcta),
                preguntaActual,
                TOTAL_PREGUNTAS);
    }

    // comprueba la opción que presionó el usuario
    private void comprobar(int numeroBoton) {
        int respuesta = actividad.obtenerOpcion(numeroBoton);
        int correcta = operacion.calcularResultado(
                operacion.getNum1(), operacion.getNum2());

        if (respuesta == correcta) {

            if (preguntaActual < TOTAL_PREGUNTAS) {
                preguntaActual++;
                nuevaPregunta();
            } else {
                JOptionPane.showMessageDialog(actividad,
                        "¡Terminaste el nivel de " + nombre + "!"); // o nivel finalizado no se como le quieran poner
                actividad.setVisible(false);
                menu.setVisible(true);
            }

        } else {
            actividad.mostrarResultado("Inténtalo otra vez.");
        }
    }

    // Una opción correcta y tres incorrectas, en orden al azar.
    private int[] generarOpciones(int correcta) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(correcta);
        Random random = new Random();

        while (lista.size() < 4) {
            int falsa = correcta + random.nextInt(9) - 4;
            if (falsa >= 0 && !lista.contains(falsa)) {
                lista.add(falsa);
            }
        }

        Collections.shuffle(lista);

        int[] opciones = new int[4];
        for (int i = 0; i < 4; i++) {
            opciones[i] = lista.get(i);
        }
        return opciones;
    }
}


//para la utilizacion del java.util.Random vi https://codegym.cc/es/groups/posts/es.825.clase-java-util-random
//por que usar un java.util.Random? poeque permite generar ejercicios dinámicos con valores diferentes en cada intento, evitando que el menor memorice respuestas fijas y obligándolo a aplicar el procedimiento matemático.