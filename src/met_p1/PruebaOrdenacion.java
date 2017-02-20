/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package met_p1;
import met_p1.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Carmen.Lacave
 */
public class PruebaOrdenacion {
  public static void main(String[] args){
	  apartado1();
	  apartado2();
  }
  
  public static void apartado1(){
	  char repetir;
	  do{
		  System.out.println("\n\nRealizaremos una prueba para un tama�o de vector dado");
		  int[] A=crearVector();
	  
		  System.arraycopy(A,0,B,0,A.length);
		  System.out.println("A\n"+MatricesOperaciones.mostrar(A));
      
		  char medida=leer.caracter("�En qu� unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");
		  long tb0= obtenerTiempo(medida);
		  burbuja(B);
		  long tb1=obtenerTiempo(medida);
 
		  int[] C=new int[A.length];
		  System.arraycopy(A,0,C,0,A.length);
		  System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");
		  long ts0= obtenerTiempo(medida);
		  seleccionDirecta(C);
		  long ts1=obtenerTiempo(medida);

		  
		  repetir=Character.toUpperCase(leer.caracter("�Quieres repetir la prueba? (S=si/N=no)"));
	  }while (repetir=='S');
  }
  
  
  public static int[] crearVector(){
	  int[] V=null;
	  char fuenteDatos=leer.caracter("�Desde d�nde quieres cargar los datos:\n T=teclado\n F=archivo\n A=crearlo con valores aleatorios");
	  fuenteDatos=Character.toUpperCase(fuenteDatos);
	  while (fuenteDatos!='T' && fuenteDatos!='F' && fuenteDatos!='A'){
		  System.out.println("Ha introducido una opci�n incorrecta. Vuelva a intentarlo");
	  	  fuenteDatos=Character.toUpperCase(leer.caracter("�Desde d�nde quieres cargar los datos:\n T=teclado\n F=archivo\n A=crearlo con valores aleatorios"));
  	  }
	  
	  return V;
  }
  
  public static int[] cargarDatosTeclado(){
	
  }
  
  public static int[] cargarDatosArchivo(String nombre){
	
  }

  public static int[] cargarDatosAleatorio(){
	  return cargarDatosAleatorio(leer.entero("Introduce tama�o del vector"));
  }
  
    public static int[] cargarDatosAleatorio(int size){
    }
	public static void burbuja(int[] t){
    }
	
    public static void seleccionDirecta(int[] t){
    }

  public static void apartado2(){
	  
	  	System.out.println("\n\nAhora realizaremos pruebas con distintos tama�os del vector");
    	int[] valoresN= {100, 500, 1000, 5000, 8000, 9000, 10000, 11000, 20000, 50000};
		
		char medida=leer.caracter("�En qu� unidad de medida quieres calcular:\n M=milisegundos\n N=nanosegundos ");

		System.out.println("  N   |	     Burbuja	   |  SeleccionDirecta  |");

		
			 int[] B=new int[A.length];
			 System.arraycopy(A,0,B,0,A.length);
			 long tb0 = obtenerTiempo(medida);
			 Ordenes.burbuja(B);
			 long tb2 = obtenerTiempo(medida); 
			 int[] C=new int[A.length];
			 System.arraycopy(A,0,C,0,A.length);
			 long ts0 = obtenerTiempo(medida);
			 Ordenes.seleccionDirecta(C);
			 long ts2 = obtenerTiempo(medida);

  	
		System.out.printf("\n\n");
  }
	
	static long obtenerTiempo(char medida){
	}
          

}
