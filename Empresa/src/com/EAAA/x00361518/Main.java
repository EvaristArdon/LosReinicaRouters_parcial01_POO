package com.EAAA.x00361518;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String menu = "1) Agregar empleado\n"+
                "2) Despedir empleado\n" +
                "3) Ver lista de empleados\n" +
                "4) Calcular sueldo\n" +
                "5) Mostrar totales\n" +
                "0) Salir\t";

        ArrayList<Empresa> empresa = new ArrayList<>();
        byte op = 0;

        do {
            op=Byte.parseByte(JOptionPane.showInputDialog(null,menu));

            switch (op){
                case 1:

            }

        }while (op != 0);

    }
}
