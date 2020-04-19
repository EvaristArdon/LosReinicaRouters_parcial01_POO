package com.EAAA.x00361518;

import javax.swing.*;

public class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;

    private CalculadoraImpuestos() {

    }


    public static double cacularPago(Empleado Pago) {
        double salario;
        double pago;
        double renta;
        double afp;
        double isss;
        double restante;

    if (Pago instanceof PlazaFija){
        salario= Pago.getSalario();
        afp= 0.0625*salario;
        isss=0.03*salario;
        restante= salario-isss-afp;
        if(restante >=0.01 && restante <= 472.00){
            //no se descuenta la renta...
            pago=restante;
            JOptionPane.showMessageDialog(null,"tu salario es de: $"+pago+" por lo tanto, se te aplicaran los descuentos:");
            totalAFP+=afp;
            totalISSS+=isss;
            return pago;
        }
        else if(restante >=472.01 && restante <= 895.24){
            renta=0.1*(salario-472)+17.67;
            pago= restante-renta;
            JOptionPane.showMessageDialog(null,"tu salario es de: $"+pago+" por lo tanto, se te aplicaran los descuentos:");
            totalAFP+=afp;
            totalISSS+=isss;
            totalRenta+=renta;
            return pago;
        }
        else if(restante >=895.25 && restante <= 2038.10){
            renta=0.2*(salario-895.24)+60;
            pago= restante-renta;
            JOptionPane.showMessageDialog(null,"tu salario es de: $"+pago+" por lo tanto, se te aplicaran los descuentos:");
            totalAFP+=afp;
            totalISSS+=isss;
            totalRenta+=renta;
            return pago;
        }
        else {
            renta = 0.3 * (salario - 2038.10) + 288.57;
            pago = restante - renta;
            JOptionPane.showMessageDialog(null,"tu salario es de: $"+pago+" por lo tanto, se te aplicaran los descuentos:");
            totalAFP+=afp;
            totalISSS+=isss;
            totalRenta+=renta;
            return pago;
        }

    }
    else{
        salario= Pago.getSalario();
        renta=0.1*salario;
        pago= salario-renta;
        JOptionPane.showMessageDialog(null,"tu salario es de: $"+pago+" por lo tanto, se te aplicaran los descuentos:");
        totalRenta+=renta;
        return  pago;
    }

}
public static String mostrarTotales(){
String total= "El total de descuento a empleados de renta ciudadana " +
        "es de: $"+totalRenta+" dolares."+
    "El total de descuento a empleados por parte del AFP " +
            "es de: $"+totalAFP+" dolares."+
    "El total de descuento a empleados por parte del ISSS " +
            "es de: $"+totalISSS+" dolares.";
return  total;

}



}
