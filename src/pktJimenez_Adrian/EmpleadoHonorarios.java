/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pktJimenez_Adrian;

/**
 *
 * @author Jimenez Barajas Miguel Adrian
 */
public class EmpleadoHonorarios extends Empleado{
    private double sueldoHora;

    public EmpleadoHonorarios(String nombre, int noSeguro, double sueldoHora) {
        super(noSeguro, nombre);
        this.sueldoHora = sueldoHora;
    }

    @Override
    public double obtenerPago(int hrs) throws PagoException {
        if(hrs <= 40){
            return sueldoHora * hrs;
    }else{
            throw new PagoException("\033[33mAVISO: excede las horas de una jornada");
    }//fin ifelse
    }//fin metodo

    public double getSueldoHora() {
        return sueldoHora;
    }

    @Override
    public String toString() {
        return super.toString() + " SUELDO POR HORA: " + sueldoHora;
    }
    
    
}
