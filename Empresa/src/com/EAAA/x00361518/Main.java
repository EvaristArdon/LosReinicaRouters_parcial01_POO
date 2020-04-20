package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Empleado> planillaAux = new ArrayList();
        ArrayList<Documento> documentoAux =new ArrayList();

        String menu = "1) Agregar empleado\n"+
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n" +
                "6) Salir\t";

        byte op ,  op2;

        String name=nombreEmpresa();
            try {
                if (name.equals("")) throw new NonInputException("No ingresate ningun dato... ");


            }
            catch (NonInputException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        do {
            op=Byte.parseByte(JOptionPane.showInputDialog(null,menu));

            switch (op) {
                case 1:
                    planillaAux.add(addEmpleado());
                    documentoAux.add(addDocumento());
                    break;
                case 2:
                    try {
                        if (planillaAux.isEmpty() )
                            throw new EmptyListException("Por el momento, no se ha contrado ningun empleado.");

                            try {

                                boolean exist=false;
                                String nombre = JOptionPane.showInputDialog(null, "Ingrese el empleado a despedir");
                                if (nombre.equals(""))
                                    throw new NonInputException("No ingresate ningun dato... ");


                                for (Empleado ex : planillaAux)
                                    if (ex.getNombre().equals(nombre)) {
                                        exist = true;
                                        break;
                                    }
                                JOptionPane.showMessageDialog(null, "El empleado solicitado" +
                                        " fue despedido.");

                                if (!exist)
                                    throw new NotExistNameEmployeeException("El empleado ingresado no existe.");

                                planillaAux.removeIf(obj-> obj.getNombre().equals(nombre));

                                documentoAux.removeIf(obj-> obj.getNúmero().equals(nombre));


                            } catch (NonInputException | NotExistNameEmployeeException ex) {
                                JOptionPane.showMessageDialog(null, ex);}
                    }
                    catch (EmptyListException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    break;

                case 3:
                    try{
                        if(planillaAux.isEmpty())
                            throw new EmptyListException("Por el momento, no se ha contrado ningun empleado.");
                        mostrarEmpleados(planillaAux,documentoAux);}
                    catch(EmptyListException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                    break;
                case 4:
                    try{
                        if(planillaAux.isEmpty())
                            throw new EmptyListException("Por el momento, no se ha contrado ningun empleado.");

                        for (Empleado Pago: planillaAux
                        ) {
                            JOptionPane.showMessageDialog(null, "Bienvenido "+ Pago.getNombre()+
                                    ", en la siguiente pagina se le dara detalle de su sueldo...");
                            CalculadoraImpuestos.calcularPago(Pago);
                        }
                    }
                    catch(EmptyListException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }


                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "Opción ingresada erronea.");


            }

        }while (op != 6);

    }

static String nombreEmpresa(){
        String nombre;
        nombre=JOptionPane.showInputDialog(null, "Bienvenido, introduce el nombre de " +
                "tu empresa que deseada: ");
        return nombre;
}
static Documento addDocumento(){

    String num;
    String nom;
    Documento  Return=null;

    try{



        nom=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su tipo de documento: ");
        num=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su numero de " + nom + " :");
        if (num.equals(""))
            throw new NonInputException("No ingresate ningun dato... ");

        Return= new Documento(nom,num);
        }
        catch(NonInputException  ex) {
        JOptionPane.showMessageDialog(null, ex);
        }
return Return;
}
    static Empleado addEmpleado(){
        String nomb;
        String pues;
        double sala;
        Empleado Return=null;


        try{

        nomb = JOptionPane.showInputDialog(null,"Bienvenido, ingrese su nombre: ");
        pues=JOptionPane.showInputDialog(null,"Bienvenido " + nomb +  " , ingrese su puesto de trabajo: ");
        sala= Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese su salario: "));

            if (nomb.equals(""))
                throw new NonInputException("No ingresate ningun dato... ");

        String[] opciones ={ "Servicio Profesional" , "Plaza Fija" };
        int aux =JOptionPane.showOptionDialog(null,"​Tipo de trabajador​",
                "​Agregar empleado​",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,opciones,opciones[0]);
        if(aux==0){
            int MesesContrato=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese sus meses de contrato: "));
            Return =new ServicioProfesional(nomb, pues, sala, MesesContrato);

        }else {
            int extension=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su número telefónico de su oficina: "));
            Return = new PlazaFija(nomb,pues, sala, extension);
        }
        }
        catch(NonInputException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return Return;

    }


    static void mostrarEmpleados(ArrayList<Empleado> plantillaAux, ArrayList<Documento>documentoAux){
        for (Empleado x: plantillaAux
             ) {
            String mostrar ="Nombre: "+x.getNombre()+
                    "\nPuesto: "+x.getPuesto()+
                    "\nSalario: "+x.getSalario();
            if(x instanceof ServicioProfesional)
                mostrar += "\nMeses de contrato: "+((ServicioProfesional)x).getMesesContrato();
            else if (x instanceof PlazaFija)
                mostrar += "\nExtension: "+ ((PlazaFija)x).getExtensión();
            for (Documento doc: documentoAux
                 ) {
                mostrar += "\nNombre del Documento: "+ doc.getNombre();
                mostrar += "\nNumero de identificacion: "+ doc.getNúmero();

            }
            JOptionPane.showMessageDialog(null,mostrar);
        }
    }
}