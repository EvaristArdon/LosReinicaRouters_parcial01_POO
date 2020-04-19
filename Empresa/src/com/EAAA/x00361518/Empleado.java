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
        String num="";
        String nom="";
        nom=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su tipo de documento: ");
        num=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su numero de " + nom + " :");

        ad = new Documento(nom, num);
        documentos.add(ad);
    }

    public void removeDocumento(String rem) {

        rem = JOptionPane.showInputDialog(null, "Ingrese número de documento a remover de la lista: ");

        for (Documento s : documentos) {
            if(s.getNúmero()== rem){
                documentos.remove(s);
            }
        }
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

