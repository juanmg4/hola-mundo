package prueba;

import java.util.Scanner;

public class Matriz_Magica {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Integer num;
        Integer matriz[][] = new Integer[3][3];
        int sumFila;
        int sumColumna;
        int sumDiagonalPrincipal = 0;
        int sumDiagonalSecundaria = 0;
        int sumatoria = 0;
        Boolean validar = true;
        int i;
        int j;

        //cargar matriz por consola
        /* for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                System.out.print("Ingrese un numero del 1 al 9: ");
                num = leer.nextInt();

                while (num < 1 || num > 9) {
                    System.out.print("Numero invalido, ingrese un numero entre 1 y 9: ");
                    num = leer.nextInt();

                }
                matriz[i][j] = num;
            }
        }*/
        //lote de prueba, matriz cargada a mano
        matriz[0][0] = 2;
        matriz[0][1] = 7;
        matriz[0][2] = 6;
        matriz[1][0] = 9;
        matriz[1][1] = 5;
        matriz[1][2] = 1;
        matriz[2][0] = 4;
        matriz[2][1] = 3;
        matriz[2][2] = 8;

        //mostrar matriz
        System.out.println("");
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
                System.out.print("\t");

                if (j == matriz.length - 1) {
                    System.out.println();
                }
            }
            System.out.println("");
        }

        //evaluar matriz
        //sumatoria de una de las columnas, la cual uso como parametro para comparar contra el resto y determinar si la matriz es magica o no.
        for (i = 0; i < matriz.length; i++) {
            sumatoria += matriz[i][0];
        }

        for (i = 0; i < matriz.length; i++) {
            //pongo las sumatorias en 0 para evaluar la siguiente fila y la siguiente columna.
            sumFila = 0;
            sumColumna = 0;
            for (j = 0; j < matriz.length; j++) {
                sumFila += matriz[i][j];
                sumColumna += matriz[j][i];

                if (i == j) {
                    sumDiagonalPrincipal += matriz[i][j];
                }

                if (i + j == matriz.length - 1) {
                    sumDiagonalSecundaria += matriz[i][j];
                }

            }
            if (sumFila != sumatoria || sumColumna != sumatoria) {
                validar = false;
                break;
            }

        }

        //Si las filas y columnas son magicas (validar==true), entonces evaluo las diagonales.
        //Si alguna fila o columna no es magica (validar==false), no hace falta evaluar las diagonales.
        if (validar) {
            if (sumDiagonalPrincipal != sumatoria || sumDiagonalSecundaria != sumatoria) {
                System.out.println("la matriz NO ES MAGICA");

            } else {
                System.out.println("la matriz ES MAGICA!");
            }

        } else {
            System.out.println("la matriz NO ES MAGICA");
        }

    } //fin main

} // fin clase
