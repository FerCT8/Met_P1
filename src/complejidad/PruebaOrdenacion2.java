/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

import static complejidad.PruebaOrdenacion.obtenerTiempo;
import utilidades.leer;

/**
 * @author Javier
 * @author Fernando
 */
public class PruebaOrdenacion2 {
    
    public static void apartado3(){
        
                char repetir;
        do {
            int hola=leer.entero("Introduce un valor N por teclado");
            int [] A=new int[hola];

            char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
            long tb0 = obtenerTiempo(medida);
            iterativo(hola);
            long tb1 = obtenerTiempo(medida);
            
            System.out.println("  N   |	     Iterativo	   |  Recursivo   |");
            long ts0 = obtenerTiempo(medida);
            recursivo(hola);
            long ts1 = obtenerTiempo(medida);

            System.out.printf("   %d |        %d       |       %d        |\n",hola, tb1 - tb0,ts1 - ts0);
            
            repetir = Character.toUpperCase(leer.caracter("¿Quieres repetir la prueba? (S=si/N=no)"));
        }while (repetir == 'S');
    }  
      public static void apartado4(){
           
        System.out.println("\n\nAhora realizaremos pruebas con distintos tamaños del vector");
        
        int[] valoresN = {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};

        char medida = leer.caracter("¿En qué unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
        System.out.println("  N   |	     Iterativo	   |  Recursivo     |");

        for(int i=0;i<valoresN.length;i++){
            
            int A=(int)(valoresN[i]);

            long tb0 = obtenerTiempo(medida);
            iterativo(A);
            long tb2 = obtenerTiempo(medida);
            long tbiterativo=tb2-tb0;
            
            long ts0 = obtenerTiempo(medida);
            recursivo(A);
            long ts2 = obtenerTiempo(medida);
            long tsrecursivo=ts2-ts0;
            
            System.out.printf("   %d |        %d       |       %d        |\n",A,tbiterativo,tsrecursivo);

        }
         System.out.printf("\n\n");
      }
      
       public static int iterativo(int n) {
        int act = 0, ant1, ant2;
        ant1 = 0;
        ant2 = 1;
        if (n == 0) {
            act = 0;         
        }else if(n == 1){
            act = 1;
        } else {
            for (int i = 0; i < n; i++) {
                act = ant1 + ant2;
                ant2 = ant1;
                ant1 = act;
            }
        }
        return act;
    }

    public static int recursivo(int n) {
        int m;
        if (n == 0 || n == 1) {
            return n;
        } else {
            return recursivo(n - 2) + recursivo(n - 1);
        }
    }

}
