/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author Andrey
 */
public class ArchivoUsuario {
    
    ObjectOutputStream archivoSalida;//cuando se necesita obtener informacion
    ObjectInputStream archivoEntrada; 
 public ArchivoUsuario()
 {
     
 }
   public boolean existeArchivoUsuario()
    {
        boolean existe=false;
     try
     {
         archivoEntrada= new ObjectInputStream(new FileInputStream("usuario.dat"));
         existe=true;
     }
     catch(Exception e)
     {
        
            System.out.println("No existe el archivo Usuario" + e);

     }
        return existe;
    }//verifica la existencia del archivo
    public void crearArchivoUsuario()
    {
        try
        {
             archivoSalida=new ObjectOutputStream(new FileOutputStream("usuario.dat"));
             System.out.println("Archivo usuario Creado");
        }
        catch(Exception e)//el catch y el try son excepciones por si el archivo tiene un erro o se cae el programa
        {
           System.out.println("Error al crear el archivo : " + e); //trae cual es el error
        }
        
    }//crea el archivo
    public void escribirInfoEnElArchivousuario(Usuario usuario)//recive a la persona para escribirla en el archivo
    {
        try
        {
          
            archivoSalida.writeObject(usuario);
            System.out.println("Se escribió la informacion de manera correcta en usuario");
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir en el archivo");
        }
        
    }// escribe en el archivo
   public boolean VerificarArchivosUsuario()//solo sirve para leer un archivo el primero
    {
        boolean estado=false;
         //ArrayList<Cursos> arrayCurso=new ArrayList<Cursos>();
        try
        {
          archivoEntrada=new ObjectInputStream(new FileInputStream("usuario.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              archivoEntrada.readObject();//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
              estado=true;
          }
        }
       catch(Exception e)
       {
           System.out.println("no hay archivo usuario");
       } 
       return estado;
      
    }
    public ArrayList<Usuario> leerInformacionCompletaUsuario()
    {
       ArrayList<Usuario> arrayUsuario=new ArrayList<Usuario>();
       try
       {
           archivoEntrada=new ObjectInputStream(new FileInputStream("usuario.dat"));
           while(true)//es para que se detenga cuando se detenga cuando ya no haya nada en el archivo
          {
        
              arrayUsuario.add((Usuario)archivoEntrada.readObject());//se utiliza el array que es tipo persona y el punto add por que eso recibe objeto, y lo que esta adentro es un objeto
          }
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo curso" + e);
       } 
       return arrayUsuario;
    }//lee la infomacion y la pasa al array
     public String leerInformacion()
     {
       Usuario usuario=null;
       try
       {
          archivoEntrada=new ObjectInputStream(new FileInputStream("usuario.dat"));//en el archivo tiene que poner el mismo nombre que cuando guardo
          usuario=(Usuario)archivoEntrada.readObject();//contatenar
        }
       catch(Exception e)
       {
           System.out.println("Fin del archivo Usuario" + e);
       } 
       return usuario.infoUsuario();
    }
    
   
    
    
    
}
