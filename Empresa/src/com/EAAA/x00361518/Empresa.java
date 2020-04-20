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

<<<<<<< HEAD
        public void addEmpleado(Empleado a){
            planilla.add(a);
        }

        public void quitEmpleado(String quitar){
=======
        public void addEmpleado(Empleado a) throws AlreadyExistEmployeeNameException{
            try{
                //Se recorre la lista para ver si el empleado no existe previamente en la lista
                boolean siesta = false;
                for(Empleado b: planilla){
                    if (b.getNombre().equalsIgnoreCase(a.getNombre())) {
                        siesta = true;
                        if (siesta==true){
                            throw new AlreadyExistEmployeeNameException("¡Lo sentimos! Ese nombre ya esta agregado en la" +
                                    " lista de empleados.");
                        } else {
                            planilla.add(b);
                        }
                    }
                }
            }catch (AlreadyExistEmployeeNameException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        public void removeEmpleado(String quitar) throws NotExistNameEmployeeException {
            try{
                //Se recorre la lista para ver si el empleado existe y asi eliminarlo
                Empleado s = null;
                for(Empleado a: planilla){
                    if(a.getNombre().equalsIgnoreCase(quitar))
                        s=a;
                }
                    if(s != null){
                        planilla.remove(s);
                    }else
                        throw new NotExistNameEmployeeException("¡Lo sentimos! No existe el nombre del empleado a despedir.");

                }catch(NotExistNameEmployeeException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad

            }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

