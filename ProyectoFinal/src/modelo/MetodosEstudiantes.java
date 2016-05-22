package modelo;

import java.util.ArrayList;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosEstudiantes {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    BaseDatos baseDatos;
   ArchivoEstudiante archivoEstudiante;
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        baseDatos=new BaseDatos();
        archivoEstudiante=new ArchivoEstudiante();
        verificarArchivoEstudiante();
       
    }
       public void verificarArchivoEstudiante()
    {
        boolean verificar=archivoEstudiante.existeArchivoEstudiante();
        if(verificar)
        {
            arrayEstudiantes=archivoEstudiante.leerInformacionCompletaEstudiante();
            
        }
        else
        {
            archivoEstudiante.crearArchivoEstudiante();
          
        }
        
    }//verifica si existe un archivo  ya creado
      public void guardarArchivoEstudiante()
    {
        archivoEstudiante.crearArchivoEstudiante();
        for(int i=0;i<arrayEstudiantes.size();i++)
        {
            archivoEstudiante.escribirInfoEnElArchivoEstudiante(arrayEstudiantes.get(i));
            System.out.println("se guardo en archivo");
        }
    }//guarda lo del array al archivo
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(temporal);
       // baseDatos.registrarEstudiante(informacion[0], informacion[1], informacion[2]);
        
    }//agrega al array
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
            }
        
        }
        return existe;
    }//consulta en el array un estudiante
    
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
            }
        }
    }//modifica en el array un estudiante
    public void eliminarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.remove(contador);
            }
        }
    }//Ellimina del array un estudiante
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } //regresa un arreglo   
}
