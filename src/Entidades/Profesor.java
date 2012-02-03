/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;

/**
 *
 * @author Victor Hugo
 */
public class Profesor {
 private String ci_profesor;
    private String direccion;
    private String telefono;
    private String celular;
    private String email;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String fechaNacimiento;
    private String lugarNacimiento;
    private String login;
    private String password;
    public Profesor()
    {
        ci_profesor="";
        direccion="";
        telefono="";
        celular="";
        email="";
        nombre="";
        ap_paterno="";
        ap_materno="";
        fechaNacimiento=null;
        lugarNacimiento="";

    }
    public String getCIProfesor()
    {
        return ci_profesor;
    }
    public void setCIProfesor(String ciprofesor)
    {
        ci_profesor= ciprofesor;

    }
    public String getDireccion()
    {
        return direccion;
    }
    public void setDireccion(String direc)
    {
        direccion=direc;
    }
    public String getTelefono()
    {
        return telefono;
    }
    public void setTelefono(String telf)
    {
        telefono=telf;
    }
    public String getCelular()
    {
        return celular;
    }
    public void setCelular(String cel)
    {
        celular=cel;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String mail)
    {
        email=mail;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nom)
    {
        nombre=nom;
    }
    public String getApPaterno()
    {
        return ap_paterno;
    }
    public void setApPaterno(String apepater)
    {
        ap_paterno=apepater;
    }
    public String getApMaterno()
    {
        return ap_materno;
    }
    public void setApMaterno(String apemater)
    {
        ap_materno=apemater;
    }
    public void setFechaNacimiento(String fecha){
        fechaNacimiento=fecha;
    }
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setLugarNacimiento(String lugar){
        lugarNacimiento=lugar;
    }
    public String getLugarNacimiento(){
        return lugarNacimiento;
    }
    public void setLogin(String usr){
        login=usr;
    }
    public String getLogin(){
        return login;
    }
    public void setPassword(String pas){
        password=pas;
    }
    public String getPassword(){
        return password;
    }
}
