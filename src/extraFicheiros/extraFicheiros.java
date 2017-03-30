/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraFicheiros;

import java.io.IOException;

/**
 *
 * @author ped90
 */ 

/*
1-clase alumno -> nome string y nota int
2-clase escribir -> añadir en el fichero "notas.dat" varios alumnos
3-ler fichero "notas.dat" -> aprobados.dat y suspensos.dat
4-meter os aprobados nun arraylist
5-visualizamos o arraylist ordenado
*/
public class extraFicheiros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
        Escribir tc = new Escribir();
        
        tc.engadir("notas.dat");
        tc.comprobar("notas.dat", "aprobados.dat", "suspensos.dat");
        tc.visualizarAprobados();
        
        
        
    }
    
}
