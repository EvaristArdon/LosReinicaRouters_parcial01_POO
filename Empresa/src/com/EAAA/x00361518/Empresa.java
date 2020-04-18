package com.EAAA.x00361518;

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

        public ArrayList<Empleado> getPlanilla() {
            return planilla;
        }
        public void addEmpleado(Empleado agregar){


        }
        public void quitEmpleado(String quitar){

        }
    }

