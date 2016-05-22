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
public class ArchivoCurso {
    
    ObjectOutputStream archivoSalida;//cuando se necesita obtener informacion
    ObjectInputStream archivoEntrada;//cuando se quiere guardar informacion
    
    public ArchivoCurso()
    {
        
    }
    
    public boolean existeArchivoCurso()
    {
        boolean existe=false;
     try
     {
         archivoEntrada= new ObjectInputStream(new FileInputStream("curso.dat"));
         existe=true;
     }
     catch(Exception e)
     {
        
            System.out.println("No existe el archivo curso" + e);

     }
        return existe;
    }
    public void crearArchivoCurso()
    {
        try
        {
             archivoSalida=new ObjectOutputStream(new FileOutputStream("curso.dat"));
             System.out.println("ArchivoCreado");
        }
        catch(Exception e)//el catch y el try son excepciones por si el archivo tiene un erro o se cae el programa
        {
           System.out.println("Error al crear el archivo : " + e); //trae cual es el error
        }
        
    }
    public void escribirInfoEnElArchivoCurso(Cursos curso)//recive a la persona para escribirla en el archivo
    {
        try
        {
            archivoSalida.writeObject(curso);
            System.out.println("Se escribió la informacion de manera correcta en curso111");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo");
        }
        
    }
   public boolean VerificarArchivosCursos()//solo sirve para leer un archivo el primero
    {
        boolean estado=false;
         //ArrayList<Cursos> arrayCurso=new ArrayList<Cursos>();
        try
        {
          archivoEntrada=new ObjectInputStream(new FileInputStream("curso.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              archivoEntrada.readObject();//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
              estado=true;
          }
        }
       catch(Exception e)
       {
           System.out.println("no hay archivo Curso");
       } 
       return estado;
      
    }
    public ArrayList<Cursos> leerInformacionCompletaCursos()
    {
       ArrayList<Cursos> arrayCurso=new ArrayList<Cursos>();
       Cursos curso=null;
       try
       {
           archivoEntrada=new ObjectInputStream(new FileInputStream("curso.dat"));
           while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              arrayCurso.add((Cursos)archivoEntrada.readObject());//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
          }
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo curso" + e);
       } 
       return arrayCurso;
    }
     public String leerInformacion()
     {
       Cursos curso=null;
       try
       {
          archivoEntrada=new ObjectInputStream(new FileInputStream("curso.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          curso=(Cursos)archivoEntrada.readObject();
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo curso" + e);
       } 
       return curso.getInfoCurso();
    }
    
    
}
