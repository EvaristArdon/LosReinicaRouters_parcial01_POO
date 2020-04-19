package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Empresa empresa= new Empresa(nombreEmpresa());
        ArrayList<Empleado> planillaAux = new ArrayList();
        ArrayList<Documento> documentoAux =new ArrayList();

        String menu = "1) Agregar empleado\n"+
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n" +
                "0) Salir\t";

        byte op = 0;

        do {
            op=Byte.parseByte(JOptionPane.showInputDialog(null,menu));

            switch (op){
                case 1:
                    planillaAux.add(addEmpleado());
                    documentoAux.add(addDocumento());
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;


            }

        }while (op != 0);

    }
static String nombreEmpresa(){
        String nombre;
        nombre=JOptionPane.showInputDialog(null, "Bienvenido, introduce el nombre de " +
                "tu empresa que deseada: ");
        return nombre;
}
static Documento addDocumento(){
    String num="";
    String nom="";
    nom=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su tipo de documento: ");
    num=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su numero de " + nom + " :");
    return new Documento(nom,num);
}
    static Empleado addEmpleado(){
        String nomb = "";
        String pues = "";
        double sala = 0;
        byte opciontipo=0;
        Empleado tipo;

        nomb = JOptionPane.showInputDialog(null,"Bienvenido, ingrese su nombre: ");
        pues=JOptionPane.showInputDialog(null,"Bienvenido " + nomb +  " , ingrese su puesto de trabajo: ");
        sala= Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese su salario: "));

        String[]opciones={"​Servicio Profesional​","​Plaza Fija​"};
        int aux =JOptionPane.showOptionDialog(null,"​Tipo de trabajador​",
                "​Agregar empleado​",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,opciones[0]);
        if(opciontipo==1){
            int MesesContrato=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese sus meses de contrato: "));
            return new ServicioProfesional(nomb, pues, sala, MesesContrato);

        }else {
            int extension=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su número telefónico de su oficina: "));
            return new PlazaFija(nomb,pues, sala, extension);
        }

    }
    static void removeDocumento(ArrayList<Documento> documentoAux){

        String rem = JOptionPane.showInputDialog(null, "Ingrese número de documento a remover: ");

        documentoAux.removeIf((doc)->{
            JOptionPane.showMessageDialog(null,"Se elimino el documento correctamente.");
        return doc.getNúmero()== rem;
        });
    }
    static void removeEmpleado(ArrayList<Empleado> planillaAux){

        String rem = JOptionPane.showInputDialog(null, "Ingrese nombre del empleado a despedir de la empresa: ");

        planillaAux.removeIf((doc)->{
            JOptionPane.showMessageDialog(null,"Se despidio al empleado satisfactoriamente.");
            return doc.getNombre()== rem;
        });
    }



}
