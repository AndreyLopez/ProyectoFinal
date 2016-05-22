package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ArchivoUsuario;
import modelo.BaseDatos;
import modelo.MatriculaXML;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatricula;
import modelo.UsuarioXML;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_VentanaPrincipa;

import vista.Login;
import vista.PrincipalVentana;
import vista.VentanaUsuario;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes;
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Matricula frm_Matricula;
    BaseDatos base;
    VentanaUsuario ventanaUsario;
    Login login;
    FRM_VentanaPrincipa ventana;
    MatriculaXML xml;
    UsuarioXML xmlUsu;
    ArchivoUsuario archivoU;
    MetodosEstudiantes memtodosEst;
    MetodosCursos metodosCur;
    Controlador_FRM_Matricula control;
    MetodosMatricula meto;
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipa ventana)
    {
        this.ventana=ventana;
        frm_MantenimientoEstufiantes= new FRM_MantenimientoEstudiantes();
        frm_MantenimientoCursos= new FRM_MantenimientoCursos();
        frm_Matricula=new FRM_Matricula(frm_MantenimientoEstufiantes, frm_MantenimientoCursos);
        metodosCur=new MetodosCursos();
        memtodosEst=new MetodosEstudiantes();
        control=new Controlador_FRM_Matricula(frm_MantenimientoEstufiantes, frm_MantenimientoCursos, frm_Matricula);
        meto=new MetodosMatricula(memtodosEst, metodosCur, control, frm_Matricula);
        if(PrincipalVentana.numSeleccion==2)
        {
            base=new BaseDatos();
            if(base.numUsuarios()>0)
            {
                login=new Login(ventana);
                login.setVisible(true);
            }
            else
            {
                VentanaUsuario ven=new VentanaUsuario();
                ven.setVisible(true);
            }
        }
        if(PrincipalVentana.numSeleccion==1)
        {
            archivoU=new ArchivoUsuario();
            if(archivoU.VerificarArchivosUsuario())
            {
                login=new Login(ventana);
                login.setVisible(true);
            }
            else
            {
                VentanaUsuario ven=new VentanaUsuario();
                ven.setVisible(true);
            }
        }
        else if(PrincipalVentana.numSeleccion==3)
        {
           //xml=new MatriculaXML(frm_Matricula);
            xmlUsu=new UsuarioXML(ventanaUsario);
            if(xmlUsu.cargarXML())
            {
                
                 login=new Login(ventana);
                login.setVisible(true);
            }
            else
            {
                xmlUsu.crearXML();
                VentanaUsuario ven=new VentanaUsuario();
                ven.setVisible(true); 
                
            }
        }
        
       //crea las instancia y referencia ademas hace una comparacion para saber cual radio 
       //button eligio y dependiendo de esto ve si ya existen archivos para sacar login o venta  
        //ventana usuario
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiante"))
        {
            frm_MantenimientoEstufiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                frm_Matricula.setVisible(true);
                frm_Matricula.colocarCodigo(base.codigoMatricula());
            }
            else if(PrincipalVentana.numSeleccion==1)
            {
               
                frm_Matricula.setVisible(true);
                frm_Matricula.colocarCodigo(meto.devolverCodigo());
            }
            else if(PrincipalVentana.numSeleccion==3)
            {
                xml=new MatriculaXML(frm_Matricula);
                 frm_Matricula.setVisible(true);
                 frm_Matricula.colocarCodigo(xml.crearCodigoXML());
            }
            //compara para saber cual eligio de radio y de acuerdo a eso coloca el codigo
            
        }
    }
    
}












