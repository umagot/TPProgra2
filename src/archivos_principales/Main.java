package archivos_principales;
import Implementaciones.*;
import Interfaces.*;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el grafo (Capacidad para 5 personas, falso = No Dirigido)
        IGrafo redSocial = new GrafoMatrizAdyacencia(5, false);

        // 2. Crear usuarios con IDs únicos
        Usuario juan = new Usuario("Juan", 1, "juan@mail.com");
        Usuario maria = new Usuario("Maria", 2, "maria@mail.com");
        Usuario pedro = new Usuario("Pedro", 3, "pedro@mail.com");
        Usuario ana = new Usuario("Ana", 4, "ana@mail.com");
        Usuario lucas = new Usuario("Lucas", 5, "lucas@mail.com");

        System.out.println(" --- 1. Insertando Usuarios ---");
        redSocial.insertarVertice(juan);
        redSocial.insertarVertice(maria);
        redSocial.insertarVertice(pedro);
        redSocial.insertarVertice(ana);
        redSocial.insertarVertice(lucas);

        // Intento de duplicado (para probar validación)
        redSocial.insertarVertice(juan);

        redSocial.mostrarVertices();
        System.out.println();

        System.out.println("--- 2. Creando Conexiones ---");
        // Juan es amigo de Maria y Pedro
        redSocial.insertarArista(juan, maria);
        redSocial.insertarArista(juan, pedro);

        // Maria es amiga de Ana
        redSocial.insertarArista(maria, ana);

        // Pedro es amigo de Ana
        redSocial.insertarArista(pedro, ana);

        // Lucas queda aislado por ahora

        redSocial.mostrarMatriz();
        System.out.println();

        System.out.println("--- 3. Probando Recorrido DFS ---");
        // Debería alcanzar a Juan, Maria, Ana y Pedro (Lucas no)
        redSocial.dfsAlcance(juan);
        System.out.println();

        System.out.println("--- 4. Probando Recorrido BFS ---");
        // Debería mostrar: Nivel 1 a Maria/Pedro, Nivel 2 a Ana
        redSocial.bfsNiveles(juan);
        System.out.println();

        System.out.println("--- 5. Probando Recomendaciones de Amistad ---");
        // Juan es amigo de Maria y Pedro. Maria y Pedro son amigos de Ana.
        // A Juan se le debería recomendar a Ana (Amigo de amigo / Nivel 2)
        redSocial.recomendarAmigos(juan);
        System.out.println();

        System.out.println("--- 6. Eliminando un Vértice  ---");
        redSocial.eliminarVertice(pedro);

        redSocial.mostrarVertices();
        redSocial.mostrarMatriz();
    }
}