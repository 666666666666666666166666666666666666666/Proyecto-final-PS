package com.example.covidtracking2;

public class ListElement {
    public String  color;
    public String  name;
    public String  fecha;
    public String  eval;

    public ListElement(String color, String name, String fecha, String eval) {
        this.color = color;
        this.name = name;
        this.fecha = fecha;
        this.eval = eval;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }
}
