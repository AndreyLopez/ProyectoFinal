/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Andrey
 */
public class ArchivoEstudiante {
    
      ObjectOutputStream archivoSalida;//cuando se necesita obtener informacion
    ObjectInputStream archivoEntrada;//cuando se quiere guardar informacion
    
    public ArchivoEstudiante()
    {
        
    }
    public boolean existeArchivoEstudiante()
    {
     boolean existe=false;
     try
     {
         archivoEntrada= new ObjectInputStream(new FileInputStream("estudiante.dat"));
         existe=true;
     }
     catch(Exception e)
     {
        
            System.out.println("No existe el archivo estudiante" + e);

     }
        return existe;
    }//ve si el archivo existe
    public void crearArchivoEstudiante()
    {
        try
        {
             archivoSalida=new ObjectOutputStream(new FileOutputStream("estudiante.dat"));
             System.out.println("Archivo estudiante Creado");
        }
        catch(Exception e)//el catch y el try son excepciones por si el archivo tiene un erro o se cae el programa
        {
           System.out.println("Error al crear el archivo : " + e); //trae cual es el error
        }
        
    }//crea el archivo
    public void escribirInfoEnElArchivoEstudiante(Estudiante estudiante)//recive a la persona para escribirla en el archivo
    {
        try
        {
            archivoSalida.writeObject(estudiante);
            System.out.println("Se escribió la informacion de manera correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo");
        }
        
    }//escribe en el archivo
    public String leerInformacionEstudiante()//solo sirve para leer un archivo el primero
    {
        Estudiante estudiante=null;
       try
       {
        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiante.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
        estudiante=(Estudiante)archivoEntrada.readObject();//se hace un casting que es el (Persona) lo que hace es para que sepa que lo que tiene  que devolver es un objeto tipo persona
       }
       catch(Exception e)
       {
           System.out.println("ERROR al leer el archivo");
       }
       return estudiante.getInformacion();
    }
    public ArrayList<Estudiante> leerInformacionCompletaEstudiante()
    {
       ArrayList<Estudiante> arrayEstudiante=new ArrayList<Estudiante>();
       try
       {
        archivoEntrada=new ObjectInputStream(new FileInputStream("estudiante.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              arrayEstudiante.add((Estudiante)archivoEntrada.readObject());//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
          }
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo" + e);
       } 
       return arrayEstudiante;
    }//lo del array lo pene en el archivo
    
}
