/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package met_p1;

import java.util.Random;

/**
 *
 * @author Juan.Giralt
 */
public class MatricesOperaciones{
	

    public static String mostrar(int [] A){
        String s="";
        for(int n=0;n<A.length;n++) s=s+A[n]+" ";
        return s;
    }
//hola
    

    public static String mostrar(int[][] A){
        String s="";
        for(int fil=0;fil<A.length;fil++) s=s+mostrar(A[fil])+"\n";
        return s;
    }
    
  
}//MatricesOperaciones