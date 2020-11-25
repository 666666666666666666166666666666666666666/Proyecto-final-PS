package com.example.covidtracking2.Usuario;

public class Usuarios {
    private String email;
    private int codigoDr;
    private String dbnombre;


    public  Usuarios(String email,  String dbnombre){

        this.email = email;
        this.codigoDr = codigoDr;
        this.dbnombre = dbnombre;
    }
    public  String getEmail(){
        return email;
    }
    public  void setEmail(){
        this.email=email;
    }


    public  int getCodigo(){
        return codigoDr;
    }
    public  void setCodigo(){
        this.codigoDr=codigoDr;
    }


    public  String getNombre(){
        return dbnombre;
    }
    public  void setNombre(){
        this.dbnombre=dbnombre;
    }
    public  int getStrinCodigo(){
        return codigoDr;
    }
}
