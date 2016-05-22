package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.CursoXML;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;
import vista.PrincipalVentana;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
    public MetodosCursos metodosCursos;
   public BaseDatos baseDatos;
   public CursoXML xml;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_mantenimientoCursos)
    {
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        baseDatos=new BaseDatos();
        xml=new CursoXML(frm_mantenimientoCursos);
        metodosCursos=new MetodosCursos();
     
    }//crea las instacias
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {    
                //if(frm_mantenimientoCursos.verificar(frm_mantenimientoCursos.devolverInformacion()))
            //{
               baseDatos.registrarCurso(frm_mantenimientoCursos.devolverInformacion());
               frm_mantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta en base datos");
               frm_mantenimientoCursos.resetearGUI();
            }
           if(PrincipalVentana.numSeleccion==1)
           {
               metodosCursos.agregarCurso(frm_mantenimientoCursos.devolverInformacion());
               frm_mantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta");
               frm_mantenimientoCursos.resetearGUI();

           }
           if(PrincipalVentana.numSeleccion==3)
           {
               xml.guardarEnXML(frm_mantenimientoCursos.devolverInformacion());
               frm_mantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta en XML");
               frm_mantenimientoCursos.resetearGUI();
           }
            
        }//agrega de acuerdo al radio button elegido
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                buscarBase();
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                
                buscar();

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                buscarXML();
            }
        }//consulta de acuerdo al radio button elegido
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                baseDatos.modificarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta en base datos");
                frm_mantenimientoCursos.resetearGUI();     
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosCursos.modificarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue modificado de forma correcta.");
                frm_mantenimientoCursos.resetearGUI();   

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xml.modificarInformacionDelXml(frm_mantenimientoCursos.devolverInformacion());
                 frm_mantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta en  xml");
                frm_mantenimientoCursos.resetearGUI();   
            }
        }//modifica de acuerdo al radio button elegido
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                baseDatos.eliminarCurso(frm_mantenimientoCursos.devolverSigla());
                frm_mantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta en base datos");
                frm_mantenimientoCursos.resetearGUI();
            }
            if(PrincipalVentana.numSeleccion==1)
            {
                metodosCursos.eliminarCurso(frm_mantenimientoCursos.devolverInformacion());
                frm_mantenimientoCursos.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
                frm_mantenimientoCursos.resetearGUI();

            }
            if(PrincipalVentana.numSeleccion==3)
            {
                xml.eliminarInformacionDelXml(frm_mantenimientoCursos.devolverSigla());
                frm_mantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta en xml");
                frm_mantenimientoCursos.resetearGUI();
            }
        }
    
    }
    public void buscarBase()
    {
        if(baseDatos.existenciaCurso(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacion(baseDatos.arregloCurso);
                frm_mantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra en base datos");
                frm_mantenimientoCursos.habilitarAgregar();
            }
    
    }//busca en base de datos

      public void buscarXML()
    {
        if(xml.consultarInformacionDelXml(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacionXML(xml.getArregloInformacion());
                frm_mantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra en xml.");
                frm_mantenimientoCursos.habilitarAgregar();
            }
    
    }//busca en xml
      
    public void buscar()
    {
        if(metodosCursos.consultarCurso(frm_mantenimientoCursos.devolverSigla()))
            {
                frm_mantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_mantenimientoCursos.habilitarEdicion();
            }
            else
            {
                frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
                frm_mantenimientoCursos.habilitarAgregar();
            }
    }//busca en el array
    

    
public void escribirInfoArchivoCurso()
 {
        metodosCursos.guardarArchivoCurso();
  }  //escribe en el archivo

    
}
