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
public abstract class Empleado implements PorPagar{
    protected int noSeguro;
    protected String nombre;

    public Empleado(int noSeguro, String nombre) {
        this.noSeguro = noSeguro;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "NOSEGURO: " + noSeguro + " NOMBRE: " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNoSeguro() {
        return noSeguro;
    }
    
    
    
}
