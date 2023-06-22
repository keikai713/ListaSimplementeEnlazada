package ed1p3;

/* Autores: Alejandro Pérez Durán.
 * Fecha de creación: 30 de Septiembre de 2014.
 */
public class Lista {

    //Declaración de una variable
    private Nodo primero;

    //Constructor de la clase Lista
    public Lista() {
        primero = null;
    }

    public Lista insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada); // crea nuevo nodo
        nuevo.enlace = primero;
        System.out.println("\nEl enlace: " + nuevo.enlace);
        System.out.println("El dato es: " + nuevo.dato);
        primero = nuevo;
        System.out.println("El enlace primero es: " + primero.enlace);
        System.out.println("El dato primero es: " + primero.dato);
        return this;
    }

    public Lista insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
        return this;
    }

    public Lista insertarUltimo(Nodo ultimo, int entrada) {
        ultimo.enlace = new Nodo(entrada);
        ultimo = ultimo.enlace;
        return this;
    }

    public void visualizar() {
        Nodo n;
        n = primero;
        System.out.println("\nDirección del primero: " + n);
        while (n != null) {
            System.out.print("Dato: " + n.dato + " ");
            System.out.println("Direccción: " + n.enlace + " ");
            n = n.enlace;
        }
    }

    public Nodo buscarLista(int destino) { //Destino: Dato que se busca en la lista.
        //primero: miembro de Lista, referencia al nodo inicial
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (destino == indice.dato) {
                return indice;
            }
        }
        return null;
    }

    public Lista eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        //Bucle de búsqueda
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.dato == entrada);
            if (!encontrado) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        //Enlace del nodo anterior con el siguiente
        if (actual != null) { // Se distingue entre que el nodo sea cabecera o del resto de la lista.
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null; //No es neceseario a ser una variable local
        }
        return this;
    }
}