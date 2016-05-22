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
public class ArchivoMatricula {
    
      ObjectOutputStream archivoSalida;//cuando se necesita obtener informacion
    ObjectInputStream archivoEntrada;//cuando se quiere guardar informacion
    
    public ArchivoMatricula()
    {
        
    }
    public boolean existeArchivo()
    {
        boolean existe=false;
     try
     {
         archivoEntrada= new ObjectInputStream(new FileInputStream("matricula.dat"));
         existe=true;
     }
     catch(Exception e)
     {
        
            System.out.println("No existe el archivo matricula" + e);

     }
        return existe;
    }
    public void crearArchivoMatricula()
    {
        try
        {
             archivoSalida=new ObjectOutputStream(new FileOutputStream("matricula.dat"));
             System.out.println("Archivo matricula Creado");
        }
        catch(Exception e)//el catch y el try son excepciones por si el archivo tiene un erro o se cae el programa
        {
           System.out.println("Error al crear el archivo matricula: " + e); //trae cual es el error
        }
        
    }
    public void escribirInfoEnElArchivoMatricula(Matricula matricula)//recive a la persona para escribirla en el archivo
    {
        try
        {
            archivoSalida.writeObject(matricula);
            System.out.println("Se escribió la informacion de manera correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo");
        }
        
    }
   public boolean VerificarArchivosMatricula()//solo sirve para leer un archivo el primero
    {
        boolean estado=false;
         //ArrayList<Cursos> arrayCurso=new ArrayList<Cursos>();
        try
        {
          archivoEntrada=new ObjectInputStream(new FileInputStream("matricula.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              archivoEntrada.readObject();//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
              estado=true;
          }
        }
       catch(Exception e)
       {
           System.out.println("no hay archivo matricula");
       } 
       return estado;
      
    }
    public ArrayList<Matricula> leerInformacionCompletaMatricula()
    {
       ArrayList<Matricula> arrayMatricula=new ArrayList<Matricula>();
       try
       {
        archivoEntrada=new ObjectInputStream(new FileInputStream("matricula.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              arrayMatricula.add((Matricula)archivoEntrada.readObject());//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
          }
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo" + e);
       } 
       return arrayMatricula;
    }
     public String leerInformacion()
     {
       Matricula matricula=null;
       try
       {
          archivoEntrada=new ObjectInputStream(new FileInputStream("matricula.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          matricula=(Matricula)archivoEntrada.readObject();
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo matricula" + e);
       } 
       return matricula.infoMatricula();
    }
    
    
}
