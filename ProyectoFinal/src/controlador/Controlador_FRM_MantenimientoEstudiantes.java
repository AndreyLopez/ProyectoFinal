package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.EstudianteXML;
import modelo.MetodosEstudiantes;
import vista.FRM_MantenimientoEstudiantes;
import vista.PrincipalVentana;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    BaseDatos baseDatos;
    PrincipalVentana principal;
    PrincipalVentana pri;
    EstudianteXML xml;
   // int num;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes)
    {
        
        //pri=new PrincipalVentana();
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
        if(PrincipalVentana.numSeleccion==2)
        {
            baseDatos=new BaseDatos();
        }
        else if(PrincipalVentana.numSeleccion==3)
        {
           xml=new EstudianteXML(frm_MantenimientoEstudiantes);
        }
        else if(PrincipalVentana.numSeleccion==1)
        {
            metodosEstudiantes= new MetodosEstudiantes();
        }
        
       // principal=new PrincipalVentana();
       
    }//las instancias y compara cuan radio button eligio
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            if(PrincipalVentana.numSeleccion==2)
          {
            

            baseDatos.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en base datos");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
            if(PrincipalVentana.numSeleccion==1)
            {
               metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
              frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en archivos");
              frm_MantenimientoEstudiantes.resetearGUI();
            }
            if(PrincipalVentana.numSeleccion==3)
            {
                 xml.guardarEnXML(frm_MantenimientoEstudiantes.devolverInformacion());
                 frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta en xml");
                 frm_MantenimientoEstudiantes.resetearGUI();
                
            }
        }//Agrega de acuerdo al radio button seleccionado
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            if(PrincipalVentana.numSeleccion==2){
            buscarBase();
            }
            else if(PrincipalVentana.numSeleccion==1){
             buscar();
            }
             else if(PrincipalVentana.numSeleccion==3){
            buscarXML();
            }

        }//consulta de acuerdo al radio button seleccionado
        
        
        if(e.getActionCommand().equals("Modificar"))
        {
            
            if(PrincipalVentana.numSeleccion==2)
            {
                if(baseDatos.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion()))
                {
                    
                     frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en base datos.");
                     frm_MantenimientoEstudiantes.resetearGUI();
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante no se encuentra");
                }
                
               
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosEstudiantes.verificarArchivoEstudiante();
                metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta ");
                frm_MantenimientoEstudiantes.resetearGUI();

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xml.modificarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta en xml.");
                frm_MantenimientoEstudiantes.resetearGUI();
            }
            
           // metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
//            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
//            frm_MantenimientoEstudiantes.resetearGUI();
        }//modifica de acuerdo al radio button seleccionado
        
        
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {    
                //metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                 if(baseDatos.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
                 {
                      
                      frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta base datos");
                      frm_MantenimientoEstudiantes.resetearGUI();
                 }
                 else
                 {
                      frm_MantenimientoEstudiantes.mostrarMensaje("Cedula no se encuentra");
                 }
                 
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
                frm_MantenimientoEstudiantes.resetearGUI();

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                 xml.eliminarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula());
                 frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta en xml.");
                 frm_MantenimientoEstudiantes.resetearGUI();
            }
            
       }//elimina de acuerdo al radio button seleccionado
        
    
    }
    public void buscarBase()
    {
        
            if(baseDatos.existenciaEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
               frm_MantenimientoEstudiantes.mostrarInformacion(baseDatos.arregloEstudiante);
               frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                 frm_MantenimientoEstudiantes.mostrarMensaje("Cedula se escribio mal");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
      
       
        
    }//buca en base datos
    
     public void buscarXML()
    {
        
            if(xml.consultarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula()))
            {
               frm_MantenimientoEstudiantes.mostrarInformacionXML(xml.getArregloInformacion());
               frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                 frm_MantenimientoEstudiantes.mostrarMensaje("Cedula se escribio mal");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
      
       
    }//busca en xml
    public void buscar()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                frm_MantenimientoEstudiantes.mostrarMensaje("La cÃ©dula buscada no se encuentra.");
                frm_MantenimientoEstudiantes.habilitarAgregar();
            }
    }//busca en el array

      public void escribirInfoArchivo()
      {
          metodosEstudiantes.guardarArchivoEstudiante();
         // System.out.println("se cargo al archivo");
      }//guarda en archivos
    
}
