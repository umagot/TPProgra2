package Implementaciones;
import archivos_principales.Usuario;
import Interfaces.IGrafo;

public class GrafoMatrizAdyacencia implements IGrafo {

    private Usuario[] vertices;
    private int[][] matriz;
    private int cantidad;
    private int capacidad;
    private boolean dirigido;

    public GrafoMatrizAdyacencia(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.dirigido = dirigido;
        this.cantidad = 0;

        this.vertices = new Usuario[capacidad];
        this.matriz = new int[capacidad][capacidad];
    }

    @Override
    public void insertarVertice(Usuario vertice) {
        if (cantidad == capacidad) {
            System.out.println("La red social está llena.");
            return;
        }
        if (existeVertice(vertice)) {
            System.out.println("El usuario ya existe en la red.");
            return;
        }
        vertices[cantidad] = vertice;
        cantidad++;
    }

    @Override
    public boolean existeVertice(Usuario vertice) {
        return obtenerIndice(vertice) != -1;
    }

    private int obtenerIndice(Usuario vertice) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i] != null && vertices[i].esIgual(vertice)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los usuarios no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 1;
        if (!dirigido) {
            matriz[posDestino][posOrigen] = 1;
        }
    }

    @Override
    public void eliminarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return;
        }

        matriz[posOrigen][posDestino] = 0;
        if (!dirigido) {
            matriz[posDestino][posOrigen] = 0;
        }
    }

    @Override
    public boolean existeArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }
        return matriz[posOrigen][posDestino] == 1;
    }

    @Override
    public void eliminarVertice(Usuario vertice) {
        int pos = obtenerIndice(vertice);
        if (pos == -1) return;

        for (int i = pos; i < cantidad - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        for (int i = pos; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad; j++) {
                matriz[i][j] = matriz[i + 1][j];
            }
        }
        for (int j = pos; j < cantidad - 1; j++) {
            for (int i = 0; i < cantidad; i++) {
                matriz[i][j] = matriz[i][j + 1];
            }
        }

        cantidad--;
        vertices[cantidad] = null;
        for (int i = 0; i < capacidad; i++) {
            matriz[cantidad][i] = 0;
            matriz[i][cantidad] = 0;
        }
    }

    @Override
    public void mostrarVertices() {
        System.out.print("Usuarios registrados: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de Conexiones:");
        System.out.print("         ");
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-9s", vertices[i].getNombre());
        }
        System.out.println();

        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-9s", vertices[i].getNombre());
            for (int j = 0; j < cantidad; j++) {
                System.out.printf("%-9d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    // --- RECORRIDO DFS (Recursividad sin arreglos adicionales complejos) ---
    @Override
    public void dfsAlcance(Usuario usuario) {
        int inicio = obtenerIndice(usuario);
        if (inicio == -1) {
            System.out.println("El usuario no existe.");
            return;
        }

        boolean[] visitados = new boolean[cantidad];
        System.out.print("Alcance de red de " + usuario + " (DFS): ");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(int v, boolean[] visitados) {
        visitados[v] = true;
        System.out.print(vertices[v] + " ");

        for (int i = 0; i < cantidad; i++) {
            if (matriz[v][i] == 1 && !visitados[i]) {
                dfsRecursivo(i, visitados);
            }
        }
    }

    // --- RECORRIDO BFS Y RECOMENDACIONES ---
    @Override
    public void bfsNiveles(Usuario usuario) {
        int[] niveles = calcularNivelesBFS(usuario);
        if (niveles == null) return;

        System.out.println("Niveles de conexión para " + usuario + " (BFS):");
        for (int i = 0; i < cantidad; i++) {
            if (niveles[i] > 0) {
                System.out.println(" - Nivel " + niveles[i] + " (" + getNivelDesc(niveles[i]) + "): " + vertices[i]);
            }
        }
    }

    @Override
    public void recomendarAmigos(Usuario usuario) {
        int[] niveles = calcularNivelesBFS(usuario);
        if (niveles == null) return;

        System.out.println("Recomendaciones de amistad para " + usuario + ":");
        boolean hayRecomendaciones = false;

        for (int i = 0; i < cantidad; i++) {
            if (niveles[i] == 2) {
                System.out.println(" - Conectar con: " + vertices[i] + " (Tienen amigos en común)");
                hayRecomendaciones = true;
            }
        }

        if (!hayRecomendaciones) {
            System.out.println(" - No hay recomendaciones en este momento.");
        }
    }

    // Método que implementa una COLA MANUAL con arreglos
    private int[] calcularNivelesBFS(Usuario origen) {
        int inicio = obtenerIndice(origen);
        if (inicio == -1) {
            System.out.println("El usuario no existe.");
            return null;
        }

        int[] niveles = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            niveles[i] = -1; // -1 significa que aún no ha sido visitado
        }

        // --- INICIO DE COLA MANUAL ---
        // Un arreglo estándar hace la función de la cola
        int[] cola = new int[capacidad];
        int frente = 0;
        int fin = 0;

        // Encolamos el nodo de inicio
        cola[fin] = inicio;
        fin++;
        niveles[inicio] = 0;

        // Mientras la cola no esté vacía (el frente no ha alcanzado al fin)
        while (frente < fin) {
            // Desencolamos
            int actual = cola[frente];
            frente++;

            // Exploramos conexiones
            for (int i = 0; i < cantidad; i++) {
                if (matriz[actual][i] == 1 && niveles[i] == -1) {
                    niveles[i] = niveles[actual] + 1;

                    // Encolamos el nuevo nodo
                    cola[fin] = i;
                    fin++;
                }
            }
        }
        // --- FIN DE COLA MANUAL ---

        return niveles;
    }

    private String getNivelDesc(int nivel) {
        if (nivel == 1) return "Amigo directo";
        if (nivel == 2) return "Amigo de amigo";
        return "Conexión lejana";
    }
}