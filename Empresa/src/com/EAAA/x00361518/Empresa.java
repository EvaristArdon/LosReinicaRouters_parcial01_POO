package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;
    public class Empresa {
        private String nombre="";
        private ArrayList<Empleado> planilla = new ArrayList();

        public Empresa(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public ArrayList<Empleado> getPlanilla() { return planilla; }

        public void addEmpleado(Empleado a){

        }
        
        public void quitEmpleado(String quitar){

            quitar = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado que será despedido: ");

            for(Empleado s: planilla){
                if(s.getNombre().equalsIgnoreCase(quitar)){
                    planilla.remove(s);
                }
            }
        }

        @Override
        public String toString() {
            return "Empresa{" +
                    "nombre='" + nombre + '\'' +
                    ", planilla=" + planilla +
                    '}';
        }
    }

