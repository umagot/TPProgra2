public class GrafoMatrizAdyacencia<T> implements IGrafo<T> {

    private T[] usuarios;
    private int[][] matriz;
    private int cantidad;
    private int capacidad;
    private boolean dirigido;


    public GrafoMatrizAdyacencia(int capacidad, boolean dirigido) {
        this.capacidad = capacidad;
        this.dirigido = dirigido;
        this.cantidad = 0;

        this.usuarios = (T[]) new Object[capacidad];
        this.matriz = new int[capacidad][capacidad];
    }

    @Override
    public void insertarUsuario(T usuario) {
        if (cantidad == capacidad) {
            System.out.println("No se pueden insertar más usuarios.");
            return;
        }

        if (existeUsuario(usuario)) {
            System.out.println("El vértice ya existe.");
            return;
        }

        usuarios[cantidad] = usuario;
        cantidad++;
    }

    @Override
    public boolean existeUsuario(T usuario) {
        return obtenerIndice(usuario) != -1;
    }

    private int obtenerIndice(T usuario) {
        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].equals(usuario)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertarRelacion(T origen, T destino) {
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
    public void eliminarRelacion(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Uno de los usuarios no existe.");
            return;
        }

        matriz[posOrigen][posDestino] = 0;

        if (!dirigido) {
            matriz[posDestino][posOrigen] = 0;
        }
    }

    @Override
    public boolean existeRelacion(T origen, T destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }

        return matriz[posOrigen][posDestino] == 1;
    }

    @Override
    public void eliminarUsuario(T usuario) {
        int pos = obtenerIndice(usuario);

        if (pos == -1) {
            System.out.println("El usuario no existe.");
            return;
        }

        for (int i = pos; i < cantidad - 1; i++) {
            usuarios[i] = usuarios[i + 1];
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

        usuarios[cantidad] = null;

        for (int i = 0; i < capacidad; i++) {
            matriz[cantidad][i] = 0;
            matriz[i][cantidad] = 0;
        }
    }

    @Override
    public void mostrarUsuarios() {
        System.out.println("Usuarios:");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(usuarios[i] + " ");
        }

        System.out.println();
    }

    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia:");

        System.out.print("   ");

        for (int i = 0; i < cantidad; i++) {
            System.out.print(usuarios[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < cantidad; i++) {
            System.out.print(usuarios[i] + "  ");

            for (int j = 0; j < cantidad; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }

}