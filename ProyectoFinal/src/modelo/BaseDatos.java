/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import vista.FRM_Matricula;


/**
 *
 * @author Andrey
 */
//En esta clase se conecta de netbeans a la basde de datos,se agrega,elimina,modifica y busca en cada uno de los objetos
public class BaseDatos {
    Connection con;
    public String arregloEstudiante[]=new String[2];
    public String arregloCurso[]=new String[3];
    public String arregloUsuario[]=new String[5];
    public String arregloDetalle[]=new String[4];
    public String arregloMatricula[]=new String[3];
    FRM_Matricula matricula;
    
    public BaseDatos()
    {
        realizarConexion();
    }
    
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean existenciaEstudiante(String cedula)
    {
        Statement cmd=null;
       ResultSet rs=null;
       boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM estudiantes WHERE cedula=" + cedula);
             while(rs.next())
             {
                 arregloEstudiante[0]=rs.getString("nombre");
                 arregloEstudiante[1]=rs.getString("direccion");
                 existe=true;
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: " + e.getMessage());
            existe=false;

        }
        return existe;
    }
//    public String[] mostrarExistencia(String cedula)
//    {
//       //Connection con = null;
//       Statement cmd=null;
//       ResultSet rs=null;
//       boolean existe=false;
//       String arreglo[]=new String[2];
//
//        try {
//             cmd=con.createStatement();
//             rs=cmd.executeQuery("SELECT * FROM estudiantes WHERE cedula=" + cedula);
//             while(rs.next())
//             {
//                
//                 arreglo[0]=rs.getString("nombre");
//                 arreglo[1]=rs.getString("direccion");
//                 
//                 existe=true;
//             }
//             rs.close();
//          
//            // Otros y operaciones sobre la base de datos...
//
//        } catch (Exception e) {
//
//            // Mantener el control sobre el tipo de error
//            System.out.println("SQLException: " + e.getMessage());
//
//        }
//        return arreglo;
//    }
    public boolean registrarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(Cedula, Nombre, Direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                //comillas sencillas por fuera y normales por dentro
               return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean modificarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE estudiantes SET cedula='" + arreglo[0] +"',nombre='" + arreglo[1] + "',direccion='" + arreglo[2] + "'WHERE cedula='" + arreglo[0]+"'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarEstudiante(String cedula)
     {
          ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiantes WHERE cedula = "+ cedula);
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
     }
//    public void consultarEstudiante(String cedula)
//    {
//        ResultSet rs = null;
//        Statement cmd = null;
//
//        try {
//                cmd = con.createStatement();
//                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula = " + cedula);
//                
//                while (rs.next())//mientras halla otro registro 
//                {
//                    String nombre = rs.getString("nombre");
//                     String direccion = rs.getString("direccion");
//                    //int edad = rs.getInt(2);
//                    System.out.println("Información de la BD: Nombre :"+nombre + "direccion :" + direccion); 
//                }
//                rs.close();
//        }
//        catch(Exception e)
//        {
//            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
//        }
//        
//    }
    //base de datos de cursos
   public boolean existenciaCurso(String sigla)
    {
        Statement cmd=null;
       ResultSet rs=null;
       boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM cursos WHERE sigla='" + sigla+"'");
             while(rs.next())
             {
                 arregloCurso[0]=rs.getString("nombre");
                 arregloCurso[1]=rs.getString("creditos");
                 arregloCurso[2]=rs.getString("horario");
                 existe=true;
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: error en existencia cursos " + e.getMessage());
            existe=false;

        }
        return existe;
    }
    
    
     public boolean registrarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla,nombre,creditos,horario) VALUES ('" +arreglo[0] + "','"+ arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");
                //comillas sencillas por fuera y normales por dentro
               return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
       public boolean modificarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE cursos SET sigla='" + arreglo[0] +"',nombre='" + arreglo[1] + "',creditos='" + arreglo[2] + "',horario='" + arreglo[3] +  "'WHERE sigla='" + arreglo[0]+"'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarCurso(String sigla)
     {
          ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos WHERE sigla = '"+ sigla + "'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
     }
     //BASE DE DATOS DE MATRICULA
      public boolean existenciaMatricula(String codigo)
    {
        Statement cmd=null;
        ResultSet rs=null;
        boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM matricula WHERE codigo=" +codigo);
             while(rs.next())
             {
                 arregloMatricula[0]=rs.getString("cedula");
                 if(existenciaEstudiante(arregloMatricula[0]))
                 {
                     arregloMatricula[1]=arregloEstudiante[0];
                 }
                
                 existe=true;
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: " + e.getMessage());
            existe=false;

        }
        return existe;
    }
    
    public String codigoMatricula()
    {
        String codigo="0000"; 
        int contador=0;
         ResultSet rs=null;
         Statement cmd=null;
         
         try
         {
              cmd=con.createStatement();
              rs=cmd.executeQuery("SELECT * FROM matricula");
              while(rs.next())
              {
                  //contador+=1;
                  if(contador==0)
                  {
                      contador=1;
                       codigo="0000" + contador;
                      //codigo="0000" + contador;
                  }
                  else
                  {
                    contador+=1;
                    codigo="0000"+contador;
                 
                  }
                  
                  //codigo+="0000";
                  codigo=codigo.substring(codigo.length()-5,codigo.length());
              }
              rs.close();
         }
         catch(Exception e)
                 {
                     System.out.println("numusuario " + e.getMessage());
                 }
         return codigo;
    }
     public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `matricula`(`codigo`, `cedula`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"')");
                //comillas sencillas por fuera y normales por dentro
               return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
       public boolean modificarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE matricula SET codigo='" + arreglo[0] +"',cedula='" + arreglo[1] +  "'WHERE codigo='" + arreglo[0]+"'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarMatricula(String codigo)
     {
          ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM matricula WHERE codigo = "+ codigo);
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
     }
     
     
     
     
     
     
     //base da datos de usuario
     
       public boolean existenciaUsuario(String cedula)
    {
        Statement cmd=null;
        ResultSet rs=null;
        boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM usuarios WHERE cedula='" +cedula+"'");
             while(rs.next())
             {
                arregloUsuario[0]=rs.getString("nombreCompleto");
                 arregloUsuario[1]=rs.getString("nombreUsuario");
                  arregloUsuario[2]=rs.getString("contrasena");
                   arregloUsuario[3]=rs.getString("repetirContrasena");
                    arregloUsuario[4]=rs.getString("tipo");
                 existe=true;
                
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: " + e.getMessage());
            existe=false;

        }
        return existe;
    }
    
    
     public boolean registrarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuarios(cedula,nombreCompleto,nombreUsuario,contrasena,repetirContrasena,tipo) VALUES ('" +arreglo[0] + "','"+ arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"','"+arreglo[4]+"','"+arreglo[5]+"')");
                //comillas sencillas por fuera y normales por dentro
               return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
       public boolean modificarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE usuarios SET cedula='" + arreglo[0] +"',nombreCompleto='" + arreglo[1] + "',nombreUsuario='" + arreglo[2] + "',contrasena='" + arreglo[3] +"',repetirContrasena='" + arreglo[4] + "',tipo='" + arreglo[5] +  "'WHERE cedula='" + arreglo[0]+"'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarUsuario(String cedula)
     {
          ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuarios WHERE cedula = '"+ cedula+"'");
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
     }
     public boolean buscarContrasena(String contrasena)
     {
       Statement cmd=null;
       ResultSet rs=null;
       boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM usuarios WHERE contrasena= '" + contrasena + "'");
             while(rs.next())
             {
                 
                 existe=true;
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: " + e.getMessage());
            existe=false;

        }
        return existe;            
     }
      public boolean buscarUsuario(String usuario)
     {
       Statement cmd=null;
       ResultSet rs=null;
       boolean existe=false;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM usuarios WHERE nombreUsuario= '" + usuario + "'");
             while(rs.next())
             {
                 
                 existe=true;
             }
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: en buscar usuario" + e.getMessage());
            existe=false;

        }
        return existe;            
     }
     public int numUsuarios()
     {
         int contador=0;
         ResultSet rs=null;
         Statement cmd=null;
         
         try
         {
              cmd=con.createStatement();
              rs=cmd.executeQuery("SELECT * FROM usuarios");
              while(rs.next())
              {
                  contador++;
              }
              rs.close();
         }
         catch(Exception e)
                 {
                     System.out.println("numusuario " + e.getMessage());
                 }
         return contador;
     }
     
     //base de datos Detallematricula
     
     public boolean existenciaDetalleMatricula(String codigo)
    {
        Statement cmd=null;
        ResultSet rs=null;
        boolean existe=false;
        //int numMatriculas=0;

        try {
             cmd=con.createStatement();
             rs=cmd.executeQuery("SELECT * FROM detalle_matricula WHERE codigo='" +codigo+"'");
             while(rs.next())
             {
                
                arregloDetalle[0]=rs.getString("codigo");
                arregloDetalle[1]=rs.getString("cedula");
                 if(existenciaEstudiante(arregloDetalle[1]))
                 {
                     arregloDetalle[2]=arregloEstudiante[0];
                 }
                arregloDetalle[3]=rs.getString("sigla");
                
                
                 existe=true;
                 
               // matricula.agregarInformacionTabla(arregloDetalle);
             }
            
             rs.close();
          
            // Otros y operaciones sobre la base de datos...

        } catch (Exception e) {

            // Mantener el control sobre el tipo de error
            System.out.println("SQLException: detalle matricula" + e.getMessage());
            existe=false;

        }
        return existe;
    }
    
    
     public boolean registrarDetalleMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `detalle_matricula`(`codigo`, `cedula`, `sigla`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                //comillas sencillas por fuera y normales por dentro
               return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarDetalleMatricula(String codigo)
     {
          ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM detalle_matricula WHERE codigo = "+ codigo);
                //comillas sencillas por fuera y normales por dentro
                  return true;
               //execute es para insertar update delete
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: eliminar detalle matricula " + e.getMessage());
            return false;
        }
     }
     
}
