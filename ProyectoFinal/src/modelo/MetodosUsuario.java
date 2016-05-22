/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Andrey
 */
public class MetodosUsuario {
    
    ArrayList<Usuario>arrayUsuario;
    private String arregloInfo[]=new String[5];
    ArchivoUsuario archivoU;
   
    public MetodosUsuario() 
    {
        
        arrayUsuario=new ArrayList<Usuario>();
        archivoU=new ArchivoUsuario();
        verificarArchivoUsuario();
    }
    public void verificarArchivoUsuario()
    {
        boolean verificar=archivoU.existeArchivoUsuario();
        if(verificar)
        {
            arrayUsuario=archivoU.leerInformacionCompletaUsuario();
            System.out.println("se cargaron los datos");
        }
        else
        {
            archivoU.crearArchivoUsuario();
            System.out.println("se creo el archivo");
        }
    }//verifica si hay usuario
    public void guardarArchivoUsuario()
    {
            archivoU.crearArchivoUsuario();
            for(int i=0;i<arrayUsuario.size();i++)
            {
                archivoU.escribirInfoEnElArchivousuario(arrayUsuario.get(i));
                
            }
            
        
        
    }//guarda lo del array en el Archivo
    
    public void Agregar(String arreglo[])
    {
        Usuario usuarioTem=new Usuario(arreglo[0],arreglo[1],new String(arreglo[2]),new String(arreglo[3]),arreglo[4],arreglo[5]);
        arrayUsuario.add(usuarioTem);
        //archivoU.escribirInfoEnElArchivoCurso(usuarioTem);
                
    }//agrga al array
    public String mostrarUsuario()
    {
        String mensaje="";
        for(int i=0;i<arrayUsuario.size();i++)
        {
            mensaje+=arrayUsuario.get(i).infoUsuario();
        }
        return mensaje;
    }
    public boolean buscarLogin(String usuario,String contrasena)
    {
        boolean existe=false;
        for(int i=0;i<arrayUsuario.size();i++)
        {
            if((arrayUsuario.get(i).getNombreUsuario().equalsIgnoreCase(usuario))&&(arrayUsuario.get(i).getContrasena().equalsIgnoreCase(contrasena)))
            {
                existe=true;
            }
        }
        return existe;
    }//busca en el array solo usuario y contrasena
    public boolean consultarUsuario(String cedula)
    {
        boolean existe=false;
        for(int i=0;i<arrayUsuario.size();i++)
        {
            if(arrayUsuario.get(i).getCedula().equalsIgnoreCase(cedula))
            {
                arregloInfo[0]=arrayUsuario.get(i).getNombreCompleto();
                arregloInfo[1]=arrayUsuario.get(i).getNombreUsuario();
                arregloInfo[2]=arrayUsuario.get(i).getContrasena();
                arregloInfo[3]=arrayUsuario.get(i).getRepetirContrasena();
                arregloInfo[4]=arrayUsuario.get(i).getTipo();
                existe=true;
            }
        }
        return existe;
    }//consulta un usuario
    public void modificar(String arreglo[])
    {
        for(int i=0;i<arrayUsuario.size();i++)
        {
            if(arrayUsuario.get(i).getCedula().equalsIgnoreCase(arreglo[0]))
            {
                arrayUsuario.get(i).setNombreCompleto(arreglo[1]);
                arrayUsuario.get(i).setNombreUsuario(arreglo[2]);
                arrayUsuario.get(i).setContrasena(arreglo[3]);
                arrayUsuario.get(i).setRepetirContrasena(arreglo[4]);
                arrayUsuario.get(i).setTipo(arreglo[5]);
            }
        }
    }//modifica un usuario
    public void eliminar(String cedula)
    {
        for(int i=0;i<arrayUsuario.size();i++)
        {
            if(arrayUsuario.get(i).getCedula().equalsIgnoreCase(cedula))
            {
                arrayUsuario.remove(i);
            }
        }
    }//elimina en un usuario
    public String[] devolverVector()
    {
        return this.arregloInfo;
    }//regresa el array
    public int tamanioArray()
    {
        return arrayUsuario.size();
    }//regresa el tamano del array

    
}
