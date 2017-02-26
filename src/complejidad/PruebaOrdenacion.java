/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

import utilidades.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class PruebaOrdenacion {

    public static void main(String[] args) throws IOException{ 
        apartado1();
        apartado2();
    }

    public static void apartado1() throws IOException{
        char repetir;
        do {
            System.out.println("\n\nRealizaremos una prueba para un tamaño de vector dado");
            //String x="Introduce el tamaño del vector";
            //System.out.println(x);
            
            
            int[] A = crearVector();
            int[] B = new int[A.length];

            System.arraycopy(A, 0, B, 0, A.length);
            System.out.println("A\n" + MatricesOperaciones.mostrar(A));

            char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
            long tb0 = obtenerTiempo(medida);
            burbuja(B);
            long tb1 = obtenerTiempo(medida);

            int[] C = new int[A.length];
            System.arraycopy(A, 0, C, 0, A.length);
            System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");
            long ts0 = obtenerTiempo(medida);
            seleccionDirecta(C);
            long ts1 = obtenerTiempo(medida);

            repetir = Character.toUpperCase(leer.caracter("¿Quieres repetir la prueba? (S=si/N=no)"));
        } while (repetir == 'S');
    }

    public static int[] crearVector() throws FileNotFoundException{
        int[] V = null;
        int size=leer.entero("Introduce el tamaño del vector");
        char fuenteDatos = leer.caracter("¿Desde dónde quieres cargar los datos:\n "
                + "T=teclado\n F=archivo\n A=crearlo con valores aleatorios");
        fuenteDatos = Character.toUpperCase(fuenteDatos);
        
        while (fuenteDatos != 'T' && fuenteDatos != 'F' && fuenteDatos != 'A') {
            System.out.println("Ha introducido una opción incorrecta. Vuelva a intentarlo");
            fuenteDatos = Character.toUpperCase(leer.caracter("¿Desde dónde quieres cargar los datos:\n"
                    + " T=teclado\n F=archivo\n A=crearlo con valores aleatorios"));
        }
        switch(fuenteDatos){
            case 'T':
               V = cargarDatosTeclado(V,size);
                break;
            case 'F':
                String a="Prueba1_1.dat";
                String b="Prueba1_2.dat";
                System.out.println("a) "+a+"\n"+"b) "+b);
                String x=leer.cadena("¿Que archivo quieres utilizar?");
                switch(x){
                    case "a":
                        V=cargarDatosArchivo(a);
                    break;
                    case "b":
                        V=cargarDatosArchivo(b);
                    break;
                    default:
                        System.out.println("Selecciona una opcion valida");
                }
                break;
            case 'A':
                V = cargarDatosAleatorio(size);
                break;    
        }   
        return V;
    }

    public static int[] cargarDatosTeclado(int[]A,int size) {
        
// Lo primero pide el tamaño del vector
        A=new int[size];    
        
        for(int i=0;i<A.length;i++){
           A[i]=leer.entero("Introduzca un valor en la posicion "+i);
        }
        return A;
    }

    public static int[] cargarDatosArchivo(String nombre) throws FileNotFoundException {
        int[] V;
        Scanner sc = new Scanner(new File(nombre));
        //Primer numero es el tamaño.
        V = new int[sc.nextInt()];
        
            while(sc.hasNext()){
                for(int i=0;i<V.length;i++){
                    V[i]=sc.nextInt();	
                }	
            }
    	return V;
    }

    public static int[] cargarDatosAleatorio() {
        // Llama a otro método, no hay que tocar nada
        return cargarDatosAleatorio(leer.entero("Introduce tamaño del vector"));
    }

    public static int[] cargarDatosAleatorio(int size) {
        int []V=new int[size];
        
        for( int i=0; i<V.length; i++){
            V[i]=(int)(Math.random()*99+1);
        }
        return V;
    }

    public static void burbuja(int[] t) {
        for (int i = 1; i < t.length; i++) {
            for (int j = t.length - 1; j >= i; j--) {
                if (t[j-1] > t[j]) {
                    int aux = t[j-1];
                    t[j-1] = t[j];
                    t[j] = aux;
                }
            }
        }
    }

    public static void seleccionDirecta(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j <= t.length; j++) {
                if (t[j] < t[minimo]) {
                    minimo = j;
                }
            }
            int aux = t[i];
            t[i] = t[minimo];
            t[minimo] = aux;
        }
    }

    public static void apartado2() throws IOException{
        int[] A = crearVector();
        System.out.println("\n\nAhora realizaremos pruebas con distintos tamaños del vector");
        int[] valoresN = {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};

        char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");

        System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");

        int[] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        long tb0 = obtenerTiempo(medida);
        burbuja(B);
        long tb2 = obtenerTiempo(medida);
        int[] C = new int[A.length];
        System.arraycopy(A, 0, C, 0, A.length);
        long ts0 = obtenerTiempo(medida);
        seleccionDirecta(C);
        long ts2 = obtenerTiempo(medida);

        System.out.printf("\n\n");
    }

    static long obtenerTiempo(char medida) {
        //Devuelve el tiempo dependiendo de si es Mili o Nano/segundos.
        if(medida=='M'){
            return System.currentTimeMillis();
        }else{
            return System.nanoTime();
        }
    }

}
