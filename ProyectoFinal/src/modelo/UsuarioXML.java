/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import vista.FRM_VentanaPrincipa;
import vista.Login;
import vista.VentanaUsuario;

/**
 *
 * @author Andrey
 */
//se crea los archivos xml para usuario y aqui se encuentran los metodos agregar,buscar,modificar y elimnar
public class UsuarioXML {
    
    VentanaUsuario ventana;
     DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    String nombreArchivo="Usuario";
    Login login;
    public UsuarioXML(VentanaUsuario ventana)
    {
        this.ventana=ventana;
        nombreArchivo="Usuario";
    if(cargarXML())
      {
           
      }
//        else
//        {
//            crearXML();
//            //curso.mensaje("no existia archivo xml, por lo cual se creo uno");
//        }
        arregloInformacion=new String[6];
        titulos=new ArrayList();
        valores=new ArrayList();
        
    }
    public boolean existencia()
    {
        boolean existe=false;
        nombreArchivo="Usuario";
        if(cargarXML())
        {
            //ventana.mensaje("Ya existe datos en xml");
        }
        else
        {
            crearXML();
           
        }
        return existe;
    }
    
       public void crearXML() //Método nuevo en pruebas
    {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML de usuario: " + e);
        }
    }
    public boolean cargarXML() //Método nuevo en pruebas
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(nombreArchivo+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Usuario");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML de usuario"+e);
        }
        return cargo;
    } 
    public int numxml()
    {
        int num=0;
         Element raiz= document.getDocumentElement();//guarda documento de la raiz
         NodeList lista=raiz.getElementsByTagName("Matricula");
        
            num=lista.getLength();
     
       return num;      
    }
     public void guardarEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{
            
            raiz = document.createElement("Usuario");
            principal = document.createElement("Usuario");
            document.getDocumentElement().appendChild(raiz);
            
           Element valor1 = document.createElement("cedula");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("nombre");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("usuario");
            Text text3 = document.createTextNode(arregloInformacion[2]);
             Element valor4 = document.createElement("contrasena");
            Text text4 = document.createTextNode(""+arregloInformacion[3]);
            Element valor5 = document.createElement("contrasena2");
            Text text5 = document.createTextNode(""+arregloInformacion[4]);
            Element valor6 = document.createElement("tipo");
            Text text6 = document.createTextNode(""+arregloInformacion[5]);
            
            
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            raiz.appendChild(valor4);
            valor4.appendChild(text4);
            raiz.appendChild(valor5);
            valor5.appendChild(text5);
            raiz.appendChild(valor6);
            valor6.appendChild(text6);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
    public void crearArchivo(String nombreArchivo) 
    {
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UsuarioXML.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(UsuarioXML.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public boolean consultarInformacionDelXml(String cedula)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+cedula) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<6)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    public boolean buscarlogin(String usuario,String contrasena)
    {
        Element raiz = document.getDocumentElement();
         NodeList listaDeItems =raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;
       
         boolean itemEncontrado=false,titulosigla=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if((tag.getNodeName().equals("usuario") && datoContenido.getNodeValue().equals(""+usuario)))
                 {
                    contador++;    
                 }
                 if(tag.getNodeName().equals("contrasena") && datoContenido.getNodeValue().equals(""+contrasena))
                 {
                    
                    contador++;
                 }
                 if(contador==2)
                 {
                     return true;
                 }
             }

         }
        return itemEncontrado;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
    public void modificarInformacionDelXml(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[4];
         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;
         try
         {
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {   
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+informacion[0]) )
                    {   
                       itemEncontrado=true;     
                    }
                    if(itemEncontrado && contador<6)
                    {
                        datoContenido.setNodeValue(informacion[contador]);                    
                        contador++;
                    }
                }
            }
           source = new DOMSource(document);
           result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar: " + e);
        }
    }
    public void eliminarInformacionDelXml(String cedula)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[6];
         boolean itemEncontrado=false,tituloCedula=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+cedula) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
                       console = new StreamResult(System.out);
                       transformer = TransformerFactory.newInstance().newTransformer();
                       transformer.transform(source, result);
                       transformer.transform(source, console);
                    } 
                }
            }
         }
        catch (Exception e) 
        {
            System.err.println("Error al eliminar: " + e);
        }
    }
}
