/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author Tania Gallardo
 */
public class Servicios {

    public String placa = "";
    public String fecha = "";
    public String hora = "";
    public String dia = "";
    public HashMap<Integer, String> diasRestriccion = new HashMap();

    //Datos de ingreso
    public void constructor(String placa, String fecha, String hora) {
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
    }

    //Se obtiene el día de una fecha.
    //Fuente: https://es.stackoverflow.com/questions/62067/dia-de-la-semana-a-partir-de-fecha-en-formato-int
    public static String diaSemana(int mes, int dias, int año) {
        String dia = "";
        int numD;
        Calendar c = Calendar.getInstance(Locale.US);
        c.set(año, mes - 1, dias);
        numD = c.get(Calendar.DAY_OF_WEEK);
        if (numD == Calendar.SUNDAY) {
            dia = "DOMINGO";
        } else if (numD == Calendar.MONDAY) {
            dia = "LUNES";
        } else if (numD == Calendar.TUESDAY) {
            dia = "MARTES";
        } else if (numD == Calendar.WEDNESDAY) {
            dia = "MIERCOLES";
        } else if (numD == Calendar.THURSDAY) {
            dia = "JUEVES";
        } else if (numD == Calendar.FRIDAY) {
            dia = "VIERNES";
        } else if (numD == Calendar.SATURDAY) {
            dia = "SABADO";
        }
        return dia;
    }

    //Para obtener el dia de la fecha ingresada
    public void diaIngreso() {
        String[] fechaCadena = this.fecha.split("-");
        this.dia = Servicios.diaSemana(Integer.parseInt(fechaCadena[1]), Integer.parseInt(fechaCadena[0]),
                Integer.parseInt(fechaCadena[2]));
    }

    //Para obtener la hora ingresada
    public int horaIngreso() {
        int horaSumada;
        String[] horaCadena = this.hora.split(":");
        horaSumada = (Integer.parseInt(horaCadena[0]) * 100) + Integer.parseInt(horaCadena[1]);
        return horaSumada;
    }

    public void obtenerRestriccion() {
        this.diasRestriccion.put(1, "LUNES");
        this.diasRestriccion.put(2, "LUNES");
        this.diasRestriccion.put(3, "MARTES");
        this.diasRestriccion.put(4, "MARTES");
        this.diasRestriccion.put(5, "MIERCOLES");
        this.diasRestriccion.put(6, "MIERCOLES");
        this.diasRestriccion.put(7, "JUEVES");
        this.diasRestriccion.put(8, "JUEVES");
        this.diasRestriccion.put(9, "VIERNES");
        this.diasRestriccion.put(0, "VIERNES");
    }

    public void resultado() {
        this.diaIngreso();
        this.obtenerRestriccion();
        String ultimoDigitoPlaca = this.placa.substring(placa.length()-1);
        if (this.dia.equals(this.diasRestriccion.get(Integer.parseInt(ultimoDigitoPlaca)))) {
            if ((this.horaIngreso() >= 700) && (this.horaIngreso() <= 930)) {
                System.out.println("El vehículo de placa " + this.placa + " no puede circular el día "
                        + this.dia + " de 07:00 a 09:30.");
            } else if ((this.horaIngreso() >= 1600) && (this.horaIngreso() <= 1930)) {
                System.out.println("El vehículo de placa " + this.placa + " no puede circular el día "
                        + this.dia + " de 16:00 a 19:30.");
            } else {
                System.out.println("El vehículo de placa " + this.placa + " puede circular el día "
                        + this.dia + " a la hora " + this.hora + ".");
            }
        }else{
            System.out.println("El vehículo de placa " + this.placa + " puede circular el día "
                        + this.dia + " a la hora " + this.hora + ".");
        }
    }

    //Getters
    public String getPlaca() {
        return placa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getDia() {
        return dia;
    }

    //Setters
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

}
