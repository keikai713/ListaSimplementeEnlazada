package ed1p3;

/* Autores: Alejandro Pérez Durán.
 * Fecha de creación: 4 de Octubre de 2014.
 * Descripción del programa: Este programa es el proyecto ED1P3.
 */
import java.util.Random;
import java.util.Scanner;

public class ED1P3 {

    //Creación de un objeto de la clase Scanner
    Scanner escaner = new Scanner(System.in);
    Lista lista = new Lista(); // Se crea lista vacia
    Random r = new Random(); // Se crea generador de números aleatorios

    void Menu() {
        //Declaración de la varible que se lee en el menú
        byte opcion;
        do {
            System.out.println("\nMENÚ\n");
            System.out.println("1.- Insertar");
            System.out.println("2.- Visualizar");
            System.out.println("3.- Eliminar");
            System.out.println("4.- Búsqueda");
            System.out.println("5.- Salir");
            System.out.println("\nSelecciona una opción");
            opcion = escaner.nextByte();
            switch (opcion) {

                case 1: {
                    MenuInsertar();
                }
                break;
                case 2: {
                    // son mostrados los elementos
                    System.out.println("\nELEMENTOS DE LA LISTA");
                    lista.visualizar();
                }
                break;
                case 3: {
                    System.out.println("\nEscribe el dato del nodo que quieres eliminar:");
                    int datoe = escaner.nextInt();
                    lista.eliminar(datoe);
                }
                break;
                case 4: {
                    System.out.println("\nEscribe el dato del nodo que quieres buscar en la lista:");
                    int datob = escaner.nextInt();
                    Nodo nodob = lista.buscarLista(datob);
                    if (nodob == null) {
                        System.out.println("\nEl nodo no se encontró en la lista");
                    } else {
                        System.out.println("\nLa dirección del nodo buscado es:");
                        System.out.println(nodob);
                    }
                }
                break;
                case 5: {
                    System.out.println("\n[PROGRAMA FINALIZADO]");
                }
                break;
                default:
                    System.out.println("\n[ERROR, VALOR NO VÁLIDO]");
            }
        } while (opcion != 5);
    }

    void MenuInsertar() {
        //Declaración de la varible que se lee en el menú
        byte opcioni;

        do {
            System.out.println("\nSUBMENÚ INSERTAR\n");
            System.out.println("1.- Insertar a la cabeza de la lista");
            System.out.println("2.- Insertar lista");
            System.out.println("3.- Insertar última");
            System.out.println("4.- Salir");
            System.out.println("\nSelecciona una opción");
            opcioni = escaner.nextByte();

            switch (opcioni) {
                case 1: {
                    //Declaración de variables
                    int d;
                    int k = 5; //Número de nodos son insertados elementos en la lista
                    for (; k > 0; k--) {
                        System.out.println("\nEscribe el dato del nodo:");
                        d = escaner.nextInt();
                        System.out.println("Dato del nodo: " + d);
                        lista.insertarCabezaLista(d); //Elemento que lo inserta a la cabeza
                        //Se va a la clase lista en el metodo insertarCabezaLista
                    }
                }
                break;
                case 2: {
                    //Declaración de una variable
                    int d;
                    //Entrada de dato
                    System.out.println("\nEscribe el dato del nuevo nodo:");
                    d = escaner.nextInt();
                    System.out.println("Dato del nuevo nodo: " + d);
                    System.out.println("\nEscribe el dato del nodo anterior de la lista:");
                    int dato = escaner.nextInt();
                    //La variable "anterior" contendrá la dirección del nodo anterior de la lista generada con el método insertarCabezaLista
                    Nodo anterior = lista.buscarLista(dato);
                    //Llamada al método insertarLista con la variable "anterior" y el dato del nuevo nodo
                    lista.insertarLista(anterior, d);
                }
                break;
                case 3: {
                    //Declaración de una variable
                    int d;
                    //Entrada de dato
                    System.out.println("\nEscribe el dato del nuevo nodo:");
                    d = escaner.nextInt();
                    System.out.println("Dato del nuevo nodo: " + d);
                    System.out.println("\nEscribe el dato del último nodo de la lista:");
                    int dato = escaner.nextInt();
                    //La variable "ultimo" contendrá la dirección del último nodo de la lista generada con el método insertarCabezaLista e insertarLista
                    Nodo ultimo = lista.buscarLista(dato);
                    //Llamada al método insertarUltimo con la variable "ultimo" y el dato del nuevo nodo
                    lista.insertarUltimo(ultimo, d);
                }
                break;
                case 4: {
                    System.out.println("\n[SUBMENPU INSERTAR FINALIZADO]");
                }
                break;
                default:
                    System.out.println("\n[ERROR, VALOR NO VÁLIDO]");
            }
        } while (opcioni != 4);
    }

    public static void main(String[] args) {
        //Creación del objeto que hace instancia con la clase ED1P3
        ED1P3 ed1p3 = new ED1P3();
        ed1p3.Menu();
    }
}