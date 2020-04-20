package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

<<<<<<< HEAD
    public static void main(String[] args) {
        ArrayList<Empleado> planillaAux = new ArrayList();
        ArrayList<Documento> documentoAux =new ArrayList();
=======
static Empresa empresa;

    public static void main(String[] args) {
         empresa = new Empresa(nombreEmpresa());
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad

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

<<<<<<< HEAD

            }
            catch (NonInputException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
=======
        String Menudespedir =
        "1. Eliminar empleado\n" +
                "2. Eliminar documento del empleado\n"+
                "0. Salir\t";

        byte op = 0, op2 =0;
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad

        do {
            op=Byte.parseByte(JOptionPane.showInputDialog(null,menu));

            switch (op) {
                case 1:
                    addEmpleado();
                    break;
                case 2:
<<<<<<< HEAD
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


=======
                    do {
                        op2 =Byte.parseByte(JOptionPane.showInputDialog(null, Menudespedir));
                        switch (op2){
                        case 1:
                            try {
                            String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del " +
                                    "empleado a despedir: ");
                            empresa.removeEmpleado(nombre);
                        } catch (NotExistNameEmployeeException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                            break;

                            case 2:
                        try {
                            String numero = JOptionPane.showInputDialog(null, "Ingrese el numero de" +
                                    " documento del empleado a despedir: ");
                            for(Empleado s: empresa.getPlanilla()){
                                s.removeDocumento(numero);
                            }
                        } catch (NotExistNumbreDocumentException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                            break;
                        default :
                            JOptionPane.showMessageDialog(null, "Opción ingresada erronea.");
                        }
                    }while (op2 != 0);

                case 3:
                    mostrarEmpleados(empresa.getPlanilla());
                    break;
                case 4:
                    String name =JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado: ");
                    boolean siesta = false;
                    for (Empleado Pago : empresa.getPlanilla()) {
                    try {
                        if(Pago.getNombre().equalsIgnoreCase(name)) {
                                JOptionPane.showMessageDialog(null, "Bienvenido " + Pago.getNombre() +
                                        ", en la siguiente pagina se le dara detalle de su sueldo...");
                                CalculadoraImpuestos.calcularPago(Pago);
                                siesta=true;
                        }
                            }catch (Exception ex){
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } if(!siesta)
                    JOptionPane.showMessageDialog(null, "La persona no se encontro en la lista de empleados.");
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales());
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "Opción ingresada erronea.");

                default:
                    JOptionPane.showMessageDialog(null, "Opción ingresada erronea.");
            }
<<<<<<< HEAD

        }while (op != 6);

=======
        }while (op != 0);
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad
    }

static String nombreEmpresa(){
        String nombre;
        nombre=JOptionPane.showInputDialog(null, "Bienvenido, introduce el nombre de " +
                "tu empresa que deseada: ");
        return nombre;
}
<<<<<<< HEAD
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
=======

  public static void addEmpleado(){
        String nomb = "",pues = "", nom="", num="";
        double sala = 0;
        byte opciontipo=0;
        Empleado tipo;

        try{
            nomb = JOptionPane.showInputDialog(null, "Bienvenido, ingrese su nombre: ");
            pues = JOptionPane.showInputDialog(null, "Bienvenido " + nomb + " , ingrese su puesto de trabajo: ");
            sala = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese su salario: "));
            nom=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su tipo de documento: ");
            num=JOptionPane.showInputDialog(null,"Bienvenido, ingrese su numero de " + nom + " :");

            String[] opciones = {"Servicio Profesional", "Plaza Fija"};
            int aux = JOptionPane.showOptionDialog(null, "​Tipo de trabajador​",
                    "​Agregar empleado​", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, opciones[0]);
            if (aux == 0) {
                int MesesContrato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese sus meses de contrato: "));
               Empleado empleado = new ServicioProfesional(nomb, pues, sala, MesesContrato);
               empresa.addEmpleado(empleado);
               empleado.addDocumento(new Documento(nom, num));

            } else {
                int extension = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su número telefónico de su oficina: "));
                Empleado empleado = new PlazaFija(nomb, pues, sala, extension);
                empresa.addEmpleado(empleado);
                empleado.addDocumento(new Documento(nom, num));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad
        }
        }
        catch(NonInputException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return Return;

    }

<<<<<<< HEAD

    static void mostrarEmpleados(ArrayList<Empleado> plantillaAux, ArrayList<Documento>documentoAux){
        for (Empleado x: plantillaAux
=======
    static void mostrarEmpleados(ArrayList<Empleado> empresa){
        for (Empleado s: empresa
>>>>>>> be08f65fe7f565be86c3001f51ba740946f588ad
             ) {
            String mostrar ="Nombre: "+s.getNombre()+
                    "\nPuesto: "+s.getPuesto()+
                    "\nSalario: "+s.getSalario();
            if(s instanceof ServicioProfesional)
                mostrar += "\nMeses de contrato: "+((ServicioProfesional)s).getMesesContrato();
            else if (s instanceof PlazaFija)
                mostrar += "\nExtension: "+ ((PlazaFija)s).getExtensión();
            for (Documento doc: s.getDocumentos()){
                mostrar += "\nNombre del Documento: "+ doc.getNombre();
                mostrar += "\nNumero de identificacion: "+ doc.getNúmero();
            }
            JOptionPane.showMessageDialog(null,mostrar);
        }
    }
}
