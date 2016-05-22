package modelo;

import java.util.ArrayList;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosCursos {
    
    private ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    ArchivoCurso archivoCurso;
    public MetodosCursos()
    {
        arrayCursos=new ArrayList <Cursos>();
        archivoCurso=new ArchivoCurso();
        verificarArchivoCurso();
    }
      public void verificarArchivoCurso()
    {
        boolean verificar=archivoCurso.existeArchivoCurso();
        if(verificar)
        {
            arrayCursos=archivoCurso.leerInformacionCompletaCursos();
            System.out.println("se cargaron los datos..");
        }
        else
        {
            archivoCurso.crearArchivoCurso();
            System.out.println("se creo el archivo");
        }
        
    }
      public void guardarArchivoCurso()
    {
        archivoCurso.crearArchivoCurso();
        for(int i=0;i<arrayCursos.size();i++)
        {
            archivoCurso.escribirInfoEnElArchivoCurso(arrayCursos.get(i));
            System.out.println("se guardo en archivo");
        }
    }
    public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        
    }
   
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(contador).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
            }
        }
    }
    public void eliminarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(arrayCursos.get(contador));
    
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
}
