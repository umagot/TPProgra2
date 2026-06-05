public class MainMatrizAdyacencia {
    public static void main(String[] args) {

        IGrafo<String> grafo = new GrafoMatrizAdyacencia<>(5, false);

        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B");
        grafo.insertarArista("A", "C");
        grafo.insertarArista("B", "D");
        grafo.insertarArista("C", "D");

        grafo.mostrarVertices();
        grafo.mostrarMatriz();

        System.out.println();

        System.out.println("Existe vértice A: " + grafo.existeVertice("A"));
        System.out.println("Existe arista A-C: " + grafo.existeArista("A", "C"));

        System.out.println();

        grafo.eliminarArista("A", "C");

        System.out.println("Después de eliminar la arista A-C:");
        grafo.mostrarMatriz();

        System.out.println();

        grafo.eliminarVertice("B");

        System.out.println("Después de eliminar el vértice B:");
        grafo.mostrarVertices();
        grafo.mostrarMatriz();

    }
}