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

    public void addDocumento(Documento ad) throws AlreadyExistNumberDocumentException{
        try{
            boolean siesta = false;
            //Se recorre la lista para ver si el documento no existe previamente en la lista
            for(Documento b: documentos){
                if (b.getNúmero().equalsIgnoreCase(ad.getNúmero())) {
                    siesta = true;
                    if (siesta==true){
                        throw new AlreadyExistNumberDocumentException("¡Lo sentimos! Ese documento ya esta agregado en la" +
                                " lista.");
                    } else {
                        documentos.add(b);
                    }
                }
            }
        }catch (AlreadyExistNumberDocumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void removeDocumento(String rem) throws NotExistNumbreDocumentException{
        try{
            Documento s = null;
            //Se recorre la lista para ver si el documento existe por medio del número y asi poder eliminarlo
            for(Documento a: documentos){
                if(a.getNúmero().equalsIgnoreCase(rem))
                    s=a;
            }
            if(s != null){
                documentos.remove(s);
            }else
                throw new NotExistNumbreDocumentException("¡Lo sentimos! No existe el documento del empleado.");

        }catch(NotExistNumbreDocumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

