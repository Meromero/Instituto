/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import java.util.Date;

/**
 *
 * @author General
 */
public class Modulo {

    private int idModulo;
    private String tipo;
    private String tipoModulo;
    private float costo;
    private String nivel;
    private String subNivel;
    private int cantidadClases;
    private String fechaInicio;
    private String fechaFin;
    private int estado;
    private float costoLibro;

    public Modulo()
    {
        idModulo=0;
        tipo="";
        costo=0;
        nivel="";
        subNivel="";
        cantidadClases=0;
        fechaInicio=null;
        fechaFin=null;


    }
    public int idModulo()
    {
        return idModulo;
    }
    public void setCIModulo(int ciModulo)
    {
        idModulo= ciModulo;

    }
    public String gettipo()
    {
        return tipo;
    }
    public void settipo(String direc)
    {
        tipo=direc;
    }
     public String getTipoModulo()
    {
        return tipoModulo;
    }
    public void setTipoModulo(String direc)
    {
        tipoModulo=direc;
    }
    public String getNivel()
    {
        return nivel;
    }
    public void setNivel(String telf)
    {
        nivel=telf;
    }
    public String getsubNivel()
    {
        return subNivel;
    }
    public void setsubNivel(String cel)
    {
        subNivel=cel;
    }
    public int getcantidadClases()
    {
        return cantidadClases;
    }
    public void setcantidadClases(int mail)
    {
        cantidadClases=mail;
    }

    public float getCosto()
    {
        return costo;
    }
    public void setCosto(float apemater)
    {
        costo=apemater;
    }
public int getEstado()
    {
        return estado;
    }
    public void setEstado(int apemater)
    {
        estado=apemater;
    }
    public float getCostoLibro(){
        return costoLibro;
    }
    public void setCostoLibro(float costoLibro){
        this.costoLibro=costoLibro;
    }






}
