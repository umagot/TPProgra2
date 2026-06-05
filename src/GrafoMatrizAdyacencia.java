public class GrafoMatrizAdyacencia<T> implements IGrafo<T> {

    private T[] vertices;
    private int[][] matriz;
    private int cantidad;
    private int capacidad;
    private boolean dirigido;



    public GrafoMatrizAdyacencia(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.dirigido = dirigido;
        this.cantidad = 0;

        this.vertices = (T[]) new Object[capacidad];
        this.matriz = new int[capacidad][capacidad];
    }

    @Override
    public void insertarVertice(T vertice) {
        if (cantidad == capacidad) {
            System.out.println("No se pueden insertar más vértices.");
            return;
        }

        if (existeVertice(vertice)) {
            System.out.println("El vértice ya existe.");
            return;
        }

        vertices[cantidad] = vertice;
        cantidad++;
    }

    @Override
    public boolean existeVertice(T vertice) {
        return obtenerIndice(vertice) != -1;
    }

    private int obtenerIndice(T vertice) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertarArista(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 1;

        if (!dirigido) {
            matriz[posDestino][posOrigen] = 1;
        }
    }

    @Override
    public void eliminarArista(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los vértices no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 0;

        if (!dirigido) {
            matriz[posDestino][posOrigen] = 0;
        }
    }

    @Override
    public boolean existeArista(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }

        return matriz[posOrigen][posDestino] == 1;
    }

    @Override
    public void eliminarVertice(T vertice) {
        int pos = obtenerIndice(vertice);

        if (pos == -1) {
            System.out.println("El vértice no existe.");
            return;
        }

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
        System.out.println("Vértices:");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
        }

        System.out.println();
    }

    @Override
    public void BuscarGenteEnComun(){

    }

    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        System.out.print("   ");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + "  ");

            for (int j = 0; j < cantidad; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }
    /// / bfs

}