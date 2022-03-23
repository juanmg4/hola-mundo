package prueba;

public class SubMatriz {

    public static void main(String[] args) {

        int[][] matriz = 
        {{1, 26, 36, 47, 5, 6, 72, 81, 95, 10},
        {11, 12, 13, 21, 41, 22, 67, 20, 10, 61},
        {56, 78, 87, 90, 9, 90, 17, 12, 87, 67},
        {41, 87, 24, 56, 97, 74, 87, 42, 64, 35},
        {32, 76, 79, 1, 36, 6, 67, 96, 12, 11},
        {99, 13, 54, 88, 89, 90, 75, 12, 41, 76},
        {67, 78, 87, 45, 14, 22, 26, 42, 56, 78},
        {98, 45, 34, 23, 32, 56, 74, 36, 5, 67},
        {24, 67, 97, 46, 87, 13, 67, 89, 90, 75},
        {21, 68, 78, 98, 90, 67, 12, 14, 22, 26}};

        int[][] sub_matriz = 
        {{36, 5, 67},
        {89, 90, 75},
        {14, 22, 26}};
        //int matriz[][] = new int[5][5];
        //int sub_matriz[][] = new int[3][3];
        int i, j, k;
        int cantidad_busquedas; //Distintas ubicaciones donde se puede encontar la sub matriz
        int posicion_inicial_i = 0;
        int posicion_inicial_j = 0;
        int posicion_inicial_sub_matriz_i = 0;
        int posicion_inicial_sub_matriz_j = 0;
        boolean encontrado = false;
        int contador;
        String indices_sub_matriz[] = new String[sub_matriz.length * sub_matriz.length];

        cantidad_busquedas = matriz.length - sub_matriz.length + 1;
        cantidad_busquedas *= cantidad_busquedas;

        System.out.println("la cantidad de busquedas es: " + cantidad_busquedas);

        mostrar_matriz(matriz);
        mostrar_matriz(sub_matriz);

        for (k = 0; k < cantidad_busquedas; k++) {
            contador = 0;
            if (k != 0) {
                //Si llego al final de la tabla en cada pasada, empiezo desde el principio pero en una fila mas abajo
                if (k % (matriz.length - sub_matriz.length + 1) == 0) {
                    posicion_inicial_i++;
                    posicion_inicial_j = 0;
                }
            }
            for (i = posicion_inicial_i; i < sub_matriz.length + posicion_inicial_i; i++) {
                for (j = posicion_inicial_j; j < sub_matriz.length + posicion_inicial_j; j++) {
                    if (matriz[i][j] == sub_matriz[posicion_inicial_sub_matriz_i][posicion_inicial_sub_matriz_j]) {
                        indices_sub_matriz[contador] = i + "," + j;
                        contador++;
                    }
                    posicion_inicial_sub_matriz_j++;

                }//fin for j
                posicion_inicial_sub_matriz_j = 0;
                posicion_inicial_sub_matriz_i++;
            }//fin for i
            posicion_inicial_sub_matriz_i = 0;
            posicion_inicial_sub_matriz_j = 0;

            if (contador == sub_matriz.length * sub_matriz.length) {
                encontrado = true;
                break;
            }
            posicion_inicial_j++;
        }//fin for k

        if (encontrado == true) {
            System.out.println("Hay submatriz!");
        } else {
            System.out.println("No hay submatriz");
        }

        if (encontrado) {
            mostrar_indices(indices_sub_matriz);
        }

    }//fin main

    //mostrar matriz
    public static void mostrar_matriz(int[][] matriz) {
        int i, j;
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
    }

    //muestra los indices donde se encuentra la sub matriz
    public static void mostrar_indices(String[] vector) {
        int i;
        System.out.print("Indices: ");
        for (i = 0; i < vector.length; i++) {
            if (i == vector.length - 1) {
                System.out.print(vector[i]);
                System.out.println("");
            } else {
                System.out.print(vector[i] + " - ");
            }
        }
    }
}//fin clase
