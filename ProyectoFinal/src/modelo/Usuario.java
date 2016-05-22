/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Andrey
 */
public class Usuario implements Serializable {
    
    private String cedula;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;
    private String repetirContrasena;
    private String tipo;

    public Usuario(String cedula, String nombreCompleto, String nombreUsuario, String contrasena, String repetirContrasena, String tipo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.repetirContrasena = repetirContrasena;
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRepetirContrasena() {
        return repetirContrasena;
    }

    public void setRepetirContrasena(String repetirContrasena) {
        this.repetirContrasena = repetirContrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String infoUsuario() {
        return "Usuario{" + "cedula=" + cedula + ", nombreCompleto=" + nombreCompleto + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", repetirContrasena=" + repetirContrasena + ", tipo=" + tipo + '}';
    }

    
}
