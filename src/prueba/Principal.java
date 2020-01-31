/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Scanner;
import operaciones.Servicios;

/**
 *
 * @author Tania Gallardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner dato = new Scanner (System.in);
        Servicios servicio = new Servicios();
        String placa;
        String fecha;
        String hora;
        
        System.out.println("Bienvenido/a al predictor de pico y placa");
        System.out.println("Ingrese la placa: (Ejemplo: PPP1234)");
        placa = dato.nextLine();
        System.out.println("Ingrese la fecha: (Formato: dd-mm-aaaa)");
        fecha = dato.nextLine();
        System.out.println("Ingrese la hora: (Formato: HH:mm)");
        hora = dato.nextLine();
        
        servicio.constructor(placa, fecha, hora);
        servicio.resultado();
        
    }
    
}
