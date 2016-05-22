/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.BaseDatos;
import modelo.MetodosUsuario;
import modelo.UsuarioXML;

import vista.FRM_VentanaPrincipa;
import vista.Login;
import vista.PrincipalVentana;
import vista.VentanaUsuario;


/**
 *
 * @author Andrey
 */
public class ControLoginl implements ActionListener{

    Login login;
    BaseDatos base;
    MetodosUsuario metodos;
    FRM_VentanaPrincipa ventana;
    UsuarioXML xml;
    public ControLoginl(Login login,FRM_VentanaPrincipa ventana) {
        this.login=login;
        base=new BaseDatos();
        metodos=new MetodosUsuario();
        VentanaUsuario ven=new VentanaUsuario();
        xml=new UsuarioXML(ven);
        this.ventana=ventana;
       
        
    }//cre las instancias
    
    public void actionPerformed(ActionEvent e)
    {
       if(e.getActionCommand().equalsIgnoreCase("Entrar")) 
       {
         if(PrincipalVentana.numSeleccion==2)
         {
             if(base.buscarUsuario(login.devolverUsuario()))
              {
                 System.out.println("encontro usuario");
               if(base.buscarContrasena(login.devolverPassword()))
               {
                   System.out.println("encontro contrasena");
                  ventana= new FRM_VentanaPrincipa();
                  ventana.setVisible(true);
                  login.cerrar();
              
                }
               
             }
             else
              {
                 JOptionPane.showMessageDialog(null,"no se encuentra");
              }
          
         }
         
         else if(PrincipalVentana.numSeleccion==1)
         {
                  if(metodos.buscarLogin(login.devolverUsuario(),login.devolverPassword()))
                   {
                      ventana.setVisible(true);
                      login.cerrar();

                   }
               else
                   {
                       JOptionPane.showMessageDialog(null,"no se encuentra");

                  }   
         }
         else if(PrincipalVentana.numSeleccion==3)
         {
             if(xml.buscarlogin(login.devolverUsuario(),login.devolverPassword())) 
             {
                     ventana.setVisible(true);
                      login.cerrar();
             }
             else
             {
                   JOptionPane.showMessageDialog(null,"no se encuentra");
             }
             
         }
       }//compara el usuario y contrasena deacuerdo al radio button seleccionado
          
          
     }

          
          
   
    }
    
    

