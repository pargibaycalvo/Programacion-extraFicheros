/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraFicheiros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static milibreria.Milibreria.añadirnombre;
import static milibreria.Milibreria.añadirnota;
/**
 *
 * @author ped90
 */
public class Escribir {
    Scanner sc;
    ObjectOutputStream engado = null;
    ObjectInputStream engado1 = null;
    FileWriter fich;
  
    private ArrayList <Alumno>estudiantes = new ArrayList();
    
 
    public void engadir (String fichero) throws IOException{
        try{
            engado = new ObjectOutputStream(new FileOutputStream(fichero));
            for(int i=0;i<3;i++){
                Alumno a = new Alumno(añadirnombre(),añadirnota());
                engado.writeObject(a);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            engado.close();
        }
        
    }
    
    public void comprobar(String fichero, String aprobados, String suspensos) throws IOException{
        Alumno a;
        try{
            engado1 = new ObjectInputStream(new FileInputStream(fichero));
            for(int i=0;i<3;i++){
                a=(Alumno)engado1.readObject();
                engado=new ObjectOutputStream(new FileOutputStream(aprobados));
                if(a.getNota()>=5){
                    engado.writeObject(i);
                    estudiantes.add(a);
                }
                else{
                    engado=new ObjectOutputStream(new FileOutputStream(suspensos));
                    engado.writeObject(i);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            engado1.close();
        }
        
    }
    
    public void visualizarAprobados(){
        for(int i=0;i<estudiantes.size();i++){
            System.out.println("Lista de aprobados");
            System.out.println();
            System.out.println(estudiantes.get(i).toString());
        }
    }
}



