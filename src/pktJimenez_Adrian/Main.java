package pktJimenez_Adrian;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jimenez Barajas Miguel Adrian
 */
public class Main {
    static ArrayList<Empleado> arrEmp = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);
    static int opc=0,opc2= 0, nSeguro, hrs;
    static double sueldoHora;
    static String nombre;
    private File archivo;
    private String cadena;
    private BufferedReader entrada;
    static Main objArchivo = new Main(arrEmp);
    //mandare el proyecto sin el archivo txt para que vea que funciona de acuerdo a lo pedido
    public static void main(String[] args) {
        objArchivo.leerArchivo();
    while(opc != 5){
        try{
        System.out.println("----MENU---\n"
                + "1.- AGREGAR EMPLEADOS HONORARIOS\n"
                + "2.- IMPRIMIR INFORMACION\n"
                + "3.- OBTENER PAGO\n"
                + "4.- ELIMINAR UN EMPLEADO\n"
                + "5.- SALIR\n"
                + "INGRESE LA OPCION: ");
        opc = teclado.nextInt();
        switch(opc){
            case 1: agregaEmpleadosHonorarios();
                break;
            case 2: imprimeInformacion();
                break;
            case 3: obtenerPago();
                break;
            case 4: 
                if(arrEmp.isEmpty()){
                        System.out.println("AVISO: EL ARREGLO ESTA VACIO");
                    }else{
                        int i = 0, pos;
                        System.out.println("--------------------------------");
                        for(Empleado emp: arrEmp){
                            System.out.println("["+i+"]" + emp.toString());
                            i++;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("INGRESE LA POSICIÓN:");
                        pos = teclado.nextInt();
                        arrEmp.remove(pos);
                        System.out.println("[AVISO]: EMPLEADO ELIMINADO");
                    }
                break;
            default: if(opc == 5){
                objArchivo.escribeArchivo();
                System.out.println("cerrando sesión");
            }
        }//fin switch
    }catch(InputMismatchException e){
                System.out.println("\033[33m[AVISO] TIPO DE DATO INCORRECTO");
                teclado.next();
    }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\033[33m[AVISO] INGRESE UNA POSICION CORRECTA");
                teclado.next();
    }catch(Exception e){
            System.out.println("\033[33m[AVISO] INGRESE UNA POSICION CORRECTA");
    }
    }//fin while
}//fin main
    
    public static void agregaEmpleadosHonorarios(){
        System.out.println("INGRESE EL NOMBRE DEL EMPLEADO:");
        nombre = teclado.next();
        System.out.println("INGRESE EL NUMERO DE SEGURO:");
        nSeguro = teclado.nextInt();
        System.out.println("INGRESE EL SUELDO POR HORA");
        sueldoHora = teclado.nextDouble();
        arrEmp.add(new EmpleadoHonorarios(nombre, nSeguro, sueldoHora));
    }//fin metodo
    public static void imprimeInformacion() throws ArrayIndexOutOfBoundsException{
        opc2 = 0;
        while (opc2 != 3){
            System.out.println("--------------------------------\n"
                    + "SUBMENU MOSTRAR INFORMACIÓN\n"
                    + "\"--------------------------------\n"
                    + "1.- MOSTRAR TODO\n"
                    + "2.- ELEGIR POSICION\n"
                    + "3.- SALIR");
            opc2 = teclado.nextInt();
            switch(opc2){
                case 1:
                    if(arrEmp.isEmpty()){
                        System.out.println("AVISO: EL ARREGLO ESTA VACIO");
                    }else{
                        int i = 0;
                        System.out.println("--------------------------------");
                        for(Empleado emp: arrEmp){
                            System.out.println("["+ i +  "]" + emp.toString());
                            i++;
                        }
                        System.out.println("--------------------------------");
                    }
                    break;
                case 2:
                    if(arrEmp.isEmpty()){
                        System.out.println("AVISO: EL ARREGLO ESTA VACIO");
                    }else{
                        int i = 0, pos;
                        System.out.println("--------------------------------");
                        for(Empleado emp: arrEmp){
                            System.out.println("["+i+"]" + emp.getNombre());
                            i++;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("ingrese la posición:");
                        pos = teclado.nextInt();
                        Empleado emp = arrEmp.get(pos);
                        System.out.println("--------------------------------");
                        System.out.println(emp.toString());
                    }
                    break;
                default: System.out.println("AVISO: SALIENDO DEL SUBMENU...");
            }
            
        }   
        }
    public static void obtenerPago(){
        opc2 = 0;
        while (opc2 != 3){
            System.out.println("--------------------------------\n"
                    + "SUBMENU MOSTRAR INFORMACIÓN\n"
                    + "\"--------------------------------\n"
                    + "1.- MOSTRAR PAGO DE TODOS\n"
                    + "2.- ELEGIR EMPLEADO\n"
                    + "3.- SALIR");
            opc2 = teclado.nextInt();
            switch(opc2){
                case 1:
                    if(arrEmp.isEmpty()){
                        System.out.println("AVISO: EL ARREGLO ESTA VACIO");
                    }else{
                        int i = 0;
                        System.out.println("INGRESE LAS HORAS TRABAJADAS: ");
                        hrs = teclado.nextInt();
                        System.out.println("--------------------------------");
                        for(Empleado emp: arrEmp){
                            System.out.println("["+ i +  "]" + emp.toString() + " PAGO: ["  + emp.obtenerPago(hrs) + "]");
                            i++;
                        }
                        System.out.println("--------------------------------");
                    }
                    break;
                case 2:
                    if(arrEmp.isEmpty()){
                        System.out.println("AVISO: EL ARREGLO ESTA VACIO");
                    }else{
                        int i = 0, pos;
                        System.out.println("--------------------------------");
                        for(Empleado emp: arrEmp){
                            System.out.println("["+i+"]" + emp.toString());
                            i++;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("INGRESE LA POSICIÓN:");
                        pos = teclado.nextInt();
                        System.out.println("INGRESE LAS HORAS TRABAJADAS");
                        hrs = teclado.nextInt();
                        Empleado emp = arrEmp.get(pos);
                        System.out.println(" PAGO: ["  + emp.obtenerPago(hrs) + "]");
                    }
                    break;
                default: System.out.println("AVISO: SALIENDO DEL SUBMENU...");
            }
            
        }   
        }
    //pondre los metodos para escribir y leer archivos de texto aquí para respetar el diagrama
      private ArrayList<Empleado> arreglo;
    public Main(ArrayList<Empleado> arr) {
        arreglo = arr;
        archivo=new File("archivoEmpleadoHonorarios.txt");
    }
    private String getDatosEmpleados(Empleado emp){
        if(emp instanceof EmpleadoHonorarios){
            cadena = emp.getNombre() + "," + emp.getNoSeguro() + "," + ((EmpleadoHonorarios) emp).getSueldoHora();
        }
        return cadena;
    }//fin metodo
    public void escribeArchivo(){
        PrintWriter escribir=null;
        try {
            escribir=new PrintWriter(new FileWriter(archivo));
            for (int ren=0;ren<arreglo.size();ren++){
                cadena=getDatosEmpleados(arreglo.get(ren));
                escribir.println(cadena);
            }
            escribir.println("0");
            if (escribir!=null){
                escribir.close();
                System.out.println("Datos almacenados en el archivo");
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }//fin catch        
    }
  
    private Empleado getEmpleadoArchivo(String ren){
        String fila[]=ren.split(",");
        String asegurado, vehiculo, nombre;
            nombre=fila[0];
            nSeguro=Integer.parseInt(fila[1]);
            sueldoHora=Double.parseDouble(fila[2]);
            return new EmpleadoHonorarios(nombre, nSeguro, sueldoHora);
        }//fin getEmpleadoArchivo
    
    public void leerArchivo(){
        try{
            entrada=new BufferedReader(new FileReader(archivo));
            cadena=entrada.readLine();
            while(!"0".equals(cadena)){
                arreglo.add(getEmpleadoArchivo(cadena));
                cadena=entrada.readLine();
            }//fin while
            if (entrada!=null){
                entrada.close();
                System.out.println("Archivo cargado al arreglo");
            }//fin if
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }//fin catch
    }//fin leerArchivo
    
}

