package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre="";
    protected String puesto="";
    protected ArrayList<Documento> documentos = new ArrayList();
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }
    public ArrayList<Documento> getDocumentos(){
        return documentos;
    }

    public void addDocumento(Documento ad){
        String nu="";
        String no="";
        no=getNombre();
        nu=JOptionPane.showInputDialog(null,"bienvenido " +no+ " ingrese su numero " +
                "de documento: ");

        ad = new Documento(no, nu);
        documentos.add(ad);
    }

    public void removeDocumento(String rem){
        String nu;
        String no;
        no=getNombre();
        nu=JOptionPane.showInputDialog(null,"bienvenido " +no+ " ingrese su numero de " +
                "documento que desea eliminar: ");

        rem = nu;

    }



    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", documentos=" + documentos +
                ", salario=" + salario +
                '}';
    }
}