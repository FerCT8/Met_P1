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
        //apartado1();
        //apartado2();
        apartado3();
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
            

            char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
            long tb0 = obtenerTiempo(medida);
            burbuja(B);
            long tb1 = obtenerTiempo(medida);
            
            int[] C = new int[A.length];
            System.arraycopy(A, 0, C, 0, A.length);
            System.out.println("A\n" + MatricesOperaciones.mostrar(C));
            System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");
            long ts0 = obtenerTiempo(medida);
            seleccionDirecta(C);
            long ts1 = obtenerTiempo(medida);

            System.out.printf("   %d |        %d       |       %d        |\n",A.length, tb1 - tb0, ts1 - ts0);
            
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
        switch (fuenteDatos) {
            case 'T':
                V = cargarDatosTeclado(V, size);
                break;
            case 'F':
                boolean bandera = false;
                String a = "Prueba1_1.dat";
                String b = "Prueba1_2.dat";
                System.out.println("a) " + a + "\n" + "b) " + b);
                
                do {
                    String x=leer.cadena("¿Que archivo quieres utilizar?");
                    if (x.equals("a")) {
                        V = cargarDatosArchivo(a);
                        bandera = true;
                    } else if (x.equals("b")) {
                        V = cargarDatosArchivo(b);
                        bandera = true;     
                    } else {
                        System.out.println("Error en la seleccion");
                    }
                } while (bandera == false);
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
        int[] V=null;
        Scanner sc = new Scanner(new File(nombre));
        //Primer numero es el tamaño.
        V = new int[sc.nextInt()];
        
                for(int i=0;i<V.length;i++){
                    V[i]=sc.nextInt();	
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
            for (int j = i + 1; j < t.length; j++) {
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
        
        System.out.println("\n\nAhora realizaremos pruebas con distintos tamaños del vector");
        int[] valoresN = {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};

        char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
        System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");

        for( int i=0; i<valoresN.length;i++){
             
        int[] A= new int[valoresN[i]];
        cargarDatosAleatorio(A.length);
        
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
        
        System.out.printf("   %d |        %d       |       %d        |\n",A.length, tb2 - tb0, ts2 - ts0);
       
    }
         System.out.printf("\n\n");
    }
    
    static long obtenerTiempo(char medida) {
        medida = Character.toUpperCase(medida);
        if(medida=='M'){
            return System.currentTimeMillis();
        }else{
           return System.nanoTime();
        }
     
   }
    
    public static void apartado3(){
        
                char repetir;
        do {
            int hola=leer.entero("Introduce un valor N por teclado");
            int [] A=new int[hola];

            char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
            long tb0 = obtenerTiempo(medida);
            titoFibonacci(hola);
            long tb1 = obtenerTiempo(medida);
            
            System.out.println("  N   |	     Iterativo	   |  Recursivo   |");
            long ts0 = obtenerTiempo(medida);
            iterativo(hola,A);
            long ts1 = obtenerTiempo(medida);

            System.out.printf("   %d |        %d       |       %d        |\n",hola, tb1 - tb0, ts1 - ts0);
            
            repetir = Character.toUpperCase(leer.caracter("¿Quieres repetir la prueba? (S=si/N=no)"));
        }while (repetir == 'S');
    
    
    
           
}
      public static int titoFibonacci(int numero){
          
          if(numero < 2){
              return 1;
          }else{
              return titoFibonacci(numero-1)+titoFibonacci(numero-2);
          }
      }
      
      public static int iterativo(int numero, int array[]){
          for(int i=0; i<numero; i++){
              if(i<2){
                  array[i]=1;
              }else{
                  array[i]=array[i-1]+array[i-2];
              }
          }
            return array[numero-1];
      }

      public static void apartado4(){
           System.out.println("\n\nAhora realizaremos pruebas con distintos tamaños del vector");
        int[] valoresN = {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};

        char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
        System.out.println("  N   |	     Iterativo	   |  Recursivo     |");

        for( int i=0; i<valoresN.length;i++){
             
        int[] A= new int[valoresN[i]];
        cargarDatosAleatorio(A.length);
        
        int[] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
       
        long tb0 = obtenerTiempo(medida);
        iterativo(A.length,B);
        long tb2 = obtenerTiempo(medida);
        int[] C = new int[A.length];
        System.arraycopy(A, 0, C, 0, A.length);
        long ts0 = obtenerTiempo(medida);
        titoFibonacci(C.length);
        long ts2 = obtenerTiempo(medida);
        
        System.out.printf("   %d |        %d       |       %d        |\n",A.length, tb2 - tb0, ts2 - ts0);
       
    }
         System.out.printf("\n\n");
     
      
      
      }
}

