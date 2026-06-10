package archivos_principales;
import Implementaciones.*;
import Interfaces.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        IGrafo red = new GrafoMatrizAdyacencia(8, false);

        Usuario uAna = new Usuario("Ana");
        Usuario uBruno = new Usuario("Bruno");
        Usuario uCarlos = new Usuario("Carlos");
        Usuario uDiana = new Usuario("Diana");
        Usuario uElena = new Usuario("Elena");
        Usuario uFede = new Usuario("Fede");
        Usuario uGabi = new Usuario("Gabi");

        red.insertarVertice(uAna);
        red.insertarVertice(uBruno);
        red.insertarVertice(uCarlos);
        red.insertarVertice(uDiana);
        red.insertarVertice(uElena);
        red.insertarVertice(uFede);
        red.insertarVertice(uGabi);

        red.insertarArista(uAna, uBruno);
        red.insertarArista(uAna, uCarlos);
        red.insertarArista(uBruno, uDiana);
        red.insertarArista(uCarlos, uDiana);
        red.insertarArista(uDiana, uElena);
        red.insertarArista(uElena, uFede);

        System.out.println("--- ESTADO INICIAL DE LA RED ---");
        red.mostrarVertices();
        System.out.println();
        red.mostrarMatriz();
        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- PRUEBA 1: ALCANCE DE LA RED (DFS) ---");
        red.dfsAlcance(uAna);

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- PRUEBA 2: CERCANÍA Y NIVELES (BFS) ---");
        red.bfsNiveles(uAna);

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- PRUEBA 3: MOTOR DE RECOMENDACIONES ---");
        red.recomendarAmigos(uAna);

        System.out.println();
        red.recomendarAmigos(uDiana);
    }
}