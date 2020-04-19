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
            String nomb = "";
            String pues = "";
            double sala = 0;

            nomb = JOptionPane.showInputDialog(null,"Bienvenido, ingrese su nombre: ");
            pues=JOptionPane.showInputDialog(null,"Bienvenido " + nomb +  " , ingrese su tipo" +
                    " de puesto (Plaza fija o Servicio profesional): ");
            sala= Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese su salario: "));

            if(pues.equalsIgnoreCase("Servicio profesional")){
                int MesesContrato=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese sus meses de contrato: "));
                a = new ServicioProfesional(nomb, pues, sala, MesesContrato){};
                planilla.add(a);
            }else if(pues.equalsIgnoreCase("Plaza fija")){
                int extension=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su número telefónico de su oficina: "));
                a = new PlazaFija(nomb,pues, sala, extension);
                planilla.add(a);
            }
        }
        
        public void quitEmpleado(String quitar){

            quitar = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado que será despedido: ");

            for(Empleado s: planilla){
                if(s.getNombre().equalsIgnoreCase(quitar)){
                    planilla.remove(s);
                }
            }
        }
    }

