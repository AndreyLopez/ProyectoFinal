package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ArchivoMatricula;
import modelo.BaseDatos;
import modelo.CursoXML;
import modelo.EstudianteXML;
import modelo.MatriculaXML;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.PrincipalVentana;

/**
 *
 * @author vaio01
 */
public class Controlador_FRM_Matricula implements ActionListener {
 
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    public MetodosMatricula metodosMatricula;
    FRM_Matricula frm_Matricula;
   
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    BaseDatos baseDatos;
    MatriculaXML xmlM;
    EstudianteXML xmlEst;
    CursoXML xmlCur;
    ArchivoMatricula  archivo;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos fRM_MantenimientoCursos,FRM_Matricula frm_Matricula)
    {
    
        //this.metodosCursos=fRM_MantenimientoCursos.controlador.metodosCursos;
        //this.metodosEstudiantes=frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
      // this.baseDatos=fRM_MantenimientoCursos.controlador.baseDatos;
     
        this.frm_Matricula=frm_Matricula;
        metodosMatricula=new MetodosMatricula(metodosEstudiantes,metodosCursos,this,frm_Matricula);
        baseDatos=new BaseDatos();
        xmlEst=new EstudianteXML(frm_MantenimientoEstufiantes);
        xmlCur=new CursoXML(fRM_MantenimientoCursos);
        xmlM=new MatriculaXML(frm_Matricula);
        metodosEstudiantes=new MetodosEstudiantes();
        metodosCursos=new MetodosCursos();
        archivo=new ArchivoMatricula();
        
        //crea las instancias necesarias
       
    }
    public void actionPerformed(ActionEvent e)
    {
        
       if(e.getActionCommand().equals("BuscarCedula"))  
        {
            if(PrincipalVentana.numSeleccion==2){
            buscarCedulaBase();
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                buscarCedula();
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                buscarCedulaXML();
            }
        }//busca la cedula de acuerdo al radio button elegido
      if(e.getActionCommand().equals("BuscarSigla"))
      {
          if(PrincipalVentana.numSeleccion==2)
          {
             if(baseDatos.existenciaCurso(frm_Matricula.devolverSigla()))
             {
                //String arreglo[]=metodosCursos.getArregloInformacion();
                frm_Matricula.colocarNombreCurso(baseDatos.arregloCurso);
                frm_Matricula.habilitarAgregar();
                encontroCurso=true;
                }
                else
                {
                  frm_Matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                }
              }
            if(PrincipalVentana.numSeleccion==1)
              {
                if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
                {
                  String[] arreglo=metodosCursos.getArregloInformacion();
                  frm_Matricula.colocarNombreCurso(arreglo);
                  frm_Matricula.habilitarAgregar();
                  encontroCurso=true;
                }else
                {
                  frm_Matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al mÃ³dulo de Mantenimiento Cursos");
                }
              }

              
              if(PrincipalVentana.numSeleccion==3)
              {
                  if(xmlCur.consultarInformacionDelXml(frm_Matricula.devolverSigla()))
                  {
                    frm_Matricula.colocarNombreCursoXML(xmlCur.getArregloInformacion());
                    frm_Matricula.habilitarAgregar();
                    encontroCurso=true;
                  }
                  else
                  {
                      frm_Matricula.mostrarMensaje("o se encontro sigla en xml");
                  }
              }
         
      }//busca la sigla de acuerdo al radio button elegido
      if(e.getActionCommand().equals("Agregar"))  
        {
            if(PrincipalVentana.numSeleccion==2){
                frm_Matricula.agregarInformacionTabla();
                frm_Matricula.limpiarSigla();
               // frm_Matricula.limpiarCedula();
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                
                frm_Matricula.agregarInformacionTabla();
                frm_Matricula.limpiarSigla();

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                frm_Matricula.agregarInformacionTabla();
                frm_Matricula.limpiarSigla();
            }
        }//ingresa de acuerdo al radio button elegido
      if(e.getActionCommand().equals("Finalizar"))  
        {
            if(PrincipalVentana.numSeleccion==2){
                String arreglo[]=new String[3];
                 for(int i=0; i < frm_Matricula.getCantidadFilas();i++)
                 {
                 arreglo[0]=frm_Matricula.devolverCodigo();
                 arreglo[1]=frm_Matricula.devolverDato(i,1);
                 arreglo[2]=frm_Matricula.devolverDato(i,3);
                 baseDatos.registrarMatricula(arreglo);
                 baseDatos.registrarDetalleMatricula(arreglo);
                 //baseDatos.
                 }
                 frm_Matricula.colocarCodigo(baseDatos.codigoMatricula());
                 frm_Matricula.resetearVentana();
                 encontroEstudiante=false;
                 encontroCurso=false;
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                  String arreglo[]=new String[3];
                for(int i=0; i < frm_Matricula.getCantidadFilas();i++)
                {
                arreglo[0]=frm_Matricula.devolverCodigo();
                arreglo[1]=frm_Matricula.devolverDato(i,1);
                arreglo[2]=frm_Matricula.devolverDato(i,3);
                metodosMatricula.agregarMatricula(arreglo);
                }
                //frm_Matricula.colocarCodigoMatri();
                 frm_Matricula.colocarCodigo(metodosMatricula.devolverCodigo());
                frm_Matricula.resetearVentana();
                encontroEstudiante=false;
                encontroCurso=false;

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                String arreglo[]=new String[4];
                 for(int i=0; i < frm_Matricula.getCantidadFilas();i++)
                 {
                 arreglo[0]=frm_Matricula.devolverCodigo();
                 arreglo[1]=frm_Matricula.devolverDato(i,1);
                 arreglo[2]=frm_Matricula.devolverDato(i,3);
                 arreglo[3]=frm_Matricula.devolverNombre();
                 xmlM.guardarEnXML(arreglo);
                 //baseDatos.registrarDetalleMatricula(arreglo);
                 //baseDatos.
                 }
                 frm_Matricula.colocarCodigo(baseDatos.codigoMatricula());
                 frm_Matricula.resetearVentana();
                 encontroEstudiante=false;
                 encontroCurso=false;
            }
        }//guarda en el archivo de acuerdo al radio button elegido
         
    if(e.getActionCommand().equals("Consultar")) 
        
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                if(baseDatos.existenciaDetalleMatricula(frm_Matricula.devolverCodigo()))
                {
                 //frm_Matricula.mostrarInformacion(baseDatos.arregloDetalle);
                 frm_Matricula.agregarInformacionTabla(baseDatos.arregloDetalle);
                  frm_Matricula.habilitarOpciones();
                }

             else
             {

                 JOptionPane.showMessageDialog(null,"No existe");
             }
           }
            
            if(PrincipalVentana.numSeleccion==1)
            {
                if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
                {
                    frm_Matricula.habilitarOpciones();
                }else{

                   
                    JOptionPane.showMessageDialog(null,"No existe");
                }

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                if(xmlM.consultarInformacionDelXml(frm_Matricula.devolverCodigo()))
                {
                    //frm_Matricula.mostrarInformacionXML(xmlM.getArregloInformacion());
                    frm_Matricula.agregarInformacionTablaXML(xmlM.getArregloInformacion());
                    frm_Matricula.habilitarOpciones();
                }
                else
                {
                    frm_Matricula.mostrarMensaje("no se encontro en xml");
                }
            }
        }//consulta de acuerdo al radio button elegido
    if(e.getActionCommand().equalsIgnoreCase("Modificar"))
    {
        if(PrincipalVentana.numSeleccion==2)
            {
                  baseDatos.modificarMatricula(frm_Matricula.devolverInfo());
                  frm_Matricula.habilitarOpciones();
                   frm_Matricula.resetearVentana();
                   frm_Matricula.colocarCodigo(baseDatos.codigoMatricula());
            }

           
            
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosMatricula.modificarMatricula(frm_Matricula.devolverInfo());
                frm_Matricula.habilitarOpciones();
                   frm_Matricula.resetearVentana();
                    frm_Matricula.colocarCodigo(metodosMatricula.devolverCodigo());
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xmlM.modificarInformacionDelXml(frm_Matricula.devolverInfo());
                frm_Matricula.resetearVentana();
                frm_Matricula.colocarCodigo(xmlM.crearCodigoXML());
                      
            }
     }//modifica de acuerdo al radio button elegido
    
    if(e.getActionCommand().equalsIgnoreCase("Eliminar"))  
        {
            if(PrincipalVentana.numSeleccion==2)
            {    
          
           baseDatos.eliminarMatricula(frm_Matricula.devolverCodigo());
           baseDatos.eliminarDetalleMatricula(frm_Matricula.devolverCodigo());
              
               frm_Matricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
             frm_Matricula.colocarCodigo(baseDatos.codigoMatricula());
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosMatricula.eliminarMatricula(frm_Matricula.devolverCodigo());
                //frm_Matricula.colocarCodigoMatri();
                frm_Matricula.resetearVentana();
                encontroEstudiante=false;
                encontroCurso=false;
                frm_Matricula.colocarCodigo(metodosMatricula.devolverCodigo());

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xmlM.eliminarInformacionDelXml(frm_Matricula.devolverCodigo());
                frm_Matricula.mostrarMensaje("Se elimino de xml");
                 frm_Matricula.resetearVentana();
                frm_Matricula.colocarCodigo(xmlM.crearCodigoXML());
            }
        }//elimina de acuerdo al radio button elegido
   }
    
    public void buscarCedulaBase(){
     if(baseDatos.existenciaEstudiante(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacion(baseDatos.arregloEstudiante);
                encontroEstudiante=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            }
    }//busca en base de datos
     public void buscarCedulaXML(){
     if(xmlEst.consultarInformacionDelXml(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacionXML(xmlEst.getArregloInformacion());
                encontroEstudiante=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            }
    }//busca en xml
    
    public void buscarCedula(){
     if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                encontroEstudiante=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cÃ©dula buscada no se encuentra.");
            }
    }//busca en el array
    
   
    public void escribirArchivoMatricula(){
         metodosMatricula.guardarArchivoMatricula();
     }//escribe lo del array al archivo

    public void verificarConsultas()
    {
     if(encontroEstudiante && encontroCurso){
       this.frm_Matricula.habilitarAgregar();
     }
    }
}

