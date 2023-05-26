/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_brandonhernandez;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author brhb2
 */
public class Lab6P1_BrandonHernandez {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean menu = true;

        while (menu) {

            int opcion;
            opcion = menu();

            switch (opcion) {

                case 1:

                    System.out.println("Ingrese el tamaño del arreglo a generar: ");
                    int size = sc.nextInt();

                    while (size < 1) {
                        System.out.println("El tamaño del arreglo debe ser mayor a 1");
                    }

                    System.out.println("Ingrese el limite inferior: ");
                    int inferior = sc.nextInt();

                    while (inferior < 1) {
                        System.out.println("El limite inferior del arreglo debe ser mayor a 1");
                    }

                    System.out.println("Ingrese el limite superior: ");
                    int superior = sc.nextInt();

                    while (superior < inferior) {
                        System.out.println("El limite superior debe ser mayor al limite inferior");
                    }

                    System.out.print("Arreglo generado: ");
                    int[] arreglo = genRandArray(size, inferior, superior);
                    imprimir(arreglo);
                    System.out.println();
                    System.out.print("No. divisores primos: ");
                    int[] arreglo2 = getTotalPrimeCount(arreglo);
                    imprimir(arreglo2);
                    System.out.println();
                    break;

                case 2:

                    String palabra;
                    System.out.println("Ingrese una palabra:");
                    palabra = sc.next().toLowerCase();
                    
                    imprimir (extraerFrecuencias(palabra));
                    System.out.println();
                    
                    break;

                case 3:

                    menu = false;

                    break;

                default:
                    System.out.println("Opcion Invalida!!!!");

            }

        }

    }

    public static int menu() {

        int opcion = 0;
        System.out.println("== MENU ==");
        System.out.println("1. ¿Cuantos primos tienes?");
        System.out.println("2. Frecuencia de letras");
        System.out.println("3. Salir");
        System.out.println("Ingrese su opcion:");
        opcion = sc.nextInt();

        return opcion;

    }

    // Metodo de "Lectura"
    public static int[] genRandArray(int tam, int infe, int supe) {

        int[] temp = new int[tam];
        for (int i = 0; i < tam; i++) {

            temp[i] = infe + ran.nextInt(supe);

        }

        return temp;

    }

    public static void imprimir(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {

            System.out.print("[" + arreglo[i] + "]");

        }

    }

    public static boolean isPrime(int numero) {

        int contador = 1;
        int contador2 = 0;
        while (contador <= numero) {
            if (numero % contador == 0) {
                contador2++;
            }
            contador++;
        }
        boolean primos = false;
        if (contador2 == 2) {
            primos = true;
        } else {
            primos = false;
        }

        return primos;

    }

    public static int countPrimeFactors(int arreglo) {

        int cont = 0;
        for (int i = 2; i <= arreglo; i++) {

            if (isPrime(i) && arreglo % i == 0) {
                cont++;
            }

        }
        return cont;
    }

    public static int[] getTotalPrimeCount(int[] arreglo) {

        int[] temp = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            int contador = countPrimeFactors(arreglo[i]);

            temp[i] = contador;

        }
        return temp;

    }

    public static int[] extraerFrecuencias(String cad) {

        int[] frecuencia = new int[27];
        for (int i = 0; i < cad.length(); i++) {

            char x = cad.charAt(i);

            if ((int) x >= 97 && x <= 122) {

                frecuencia[(int) x - 97]++;

            } else if ((int) x == 65533) {
//                switch (x){
//                    
//                    case 'ñ':
//                        frecuencia[26]++;
//                        break;
//                        
//                    case 'á':
//                        frecuencia[26]++;
//                        break;
//                        
//                        
//                    
//                }
                frecuencia[26]++;
            
        
        

                
            }

        }
        return frecuencia;

    }

}
