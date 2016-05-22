/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import modelo.BaseDatos;
import modelo.MetodosUsuario;
import modelo.UsuarioXML;

import vista.FRM_VentanaPrincipa;
import vista.PrincipalVentana;
import vista.VentanaUsuario;

/**
 *
 * @author Andrey
 */
public class ControlVentanaUsuario implements ActionListener{
    
    VentanaUsuario ventaUsuario;
     BaseDatos base;
    FRM_VentanaPrincipa pricipal;
     UsuarioXML xml;
     MetodosUsuario metodos;
    public ControlVentanaUsuario(VentanaUsuario ventaUsuario) {
       
        
        
          //metodos=new MetodosUsuario();
         this.ventaUsuario=ventaUsuario;
         if(PrincipalVentana.numSeleccion==2)
         {
              base=new BaseDatos();
         }
         else if(PrincipalVentana.numSeleccion==3)
         {
             xml=new UsuarioXML(ventaUsuario);
         }
         else if(PrincipalVentana.numSeleccion==1)
         {
             metodos=new MetodosUsuario();
         }
        
    }//compara y crea las instancias
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("Buscar"))
        {
         if(PrincipalVentana.numSeleccion==2)
         {
             if(base.existenciaUsuario(ventaUsuario.devolverCedula()))
            {
               ventaUsuario.mostrar(base.arregloUsuario);
               ventaUsuario.ventana3();
               ventaUsuario.botones3();
            }
            else
            {
                  JOptionPane.showMessageDialog(null,"no se encuentra cedula");
                  ventaUsuario.ventana2();
                  ventaUsuario.botones2();
            } 
         }
         else if(PrincipalVentana.numSeleccion==3)
         {
            if(xml.consultarInformacionDelXml(ventaUsuario.devolverCedula()))
            {
             ventaUsuario.mostrarXML(xml.getArregloInformacion());
             ventaUsuario.ventana3();
             ventaUsuario.botones3();
            }
            else
            {
                ventaUsuario.mensaje("No se encuentra cedula en xml");
                 ventaUsuario.ventana2();
                  ventaUsuario.botones2();
            }
         }
          else if(PrincipalVentana.numSeleccion==1)
          {
                if(metodos.consultarUsuario(ventaUsuario.devolverCedula()))
            {
               ventaUsuario.mostrar(metodos.devolverVector());
               ventaUsuario.ventana3();
               ventaUsuario.botones3();
            }
            else
            {
                  JOptionPane.showMessageDialog(null,"no se encuentra cedula");
                  ventaUsuario.ventana2();
                  ventaUsuario.botones2();
            }

          }
        }//busca de acuerdo al radio button selecconado
        if(e.getActionCommand().equalsIgnoreCase("Agregar"))
        {
           if(PrincipalVentana.numSeleccion==2)
           {
                if(ventaUsuario.conprobarContrasena())
               {
                   base.registrarUsuario(ventaUsuario.devolverInfo());
                   JOptionPane.showMessageDialog(null,"se agrego usuario");
                   ventaUsuario.inicioVentana();
                   ventaUsuario.inicioBotones();
               }
               else
               {
                   ventaUsuario.mensaje("Las contraseñas son distintas");
               }
           }
           else if(PrincipalVentana.numSeleccion==3)
           {
               if(ventaUsuario.conprobarContrasena())
               {
                   xml.guardarEnXML(ventaUsuario.devolverInfo());
                   ventaUsuario.inicioVentana();
                   ventaUsuario.inicioBotones();
               }
           }
           else if(PrincipalVentana.numSeleccion==1)
           {
                  
            metodos.Agregar(ventaUsuario.devolverInfo());
            JOptionPane.showMessageDialog(null,"se agrego usuario");
            ventaUsuario.inicioVentana();
            ventaUsuario.inicioBotones();
          
           }


      }//agrega de acuerdo al radio button selecconado
           
            
        
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                 base.modificarMatricula(ventaUsuario.devolverInfo());
                 ventaUsuario.inicioVentana();
                 ventaUsuario.inicioBotones();
            }
            else if(PrincipalVentana.numSeleccion==1)
            {
                metodos.modificar(ventaUsuario.devolverInfo());
                ventaUsuario.inicioVentana();
                ventaUsuario.inicioBotones();
            }
            else if(PrincipalVentana.numSeleccion==3)
            {
                xml.modificarInformacionDelXml(ventaUsuario.devolverInfo());
                ventaUsuario.inicioVentana();
                 ventaUsuario.inicioBotones();
                
            }
            
                
           
        }//modifica de acuerdo al radio button selecconado
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            if(PrincipalVentana.numSeleccion==2)
            {
                 base.eliminarUsuario(ventaUsuario.devolverCedula());
                 ventaUsuario.inicioVentana();
                 ventaUsuario.inicioBotones();
            } 
            else if(PrincipalVentana.numSeleccion==1)
            {
                
                metodos.eliminar(ventaUsuario.devolverCedula());
                ventaUsuario.inicioVentana();
                ventaUsuario.inicioBotones();
            }
            else if(PrincipalVentana.numSeleccion==3)
            {
                xml.eliminarInformacionDelXml(ventaUsuario.devolverCedula());
                 ventaUsuario.inicioVentana();
                 ventaUsuario.inicioBotones();
            }
           
        }
        
    }//elimina de acuerdo al radio button selecconado
    
   public void agregarArchivoUsuario()
   {
       metodos.guardarArchivoUsuario();
   }//escribe en el archivo

   
}
