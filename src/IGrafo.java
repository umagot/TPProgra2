public interface IGrafo <T> {

        void insertarVertice(T vertice);

        void eliminarVertice(T vertice);

        void insertarArista(T origen, T destino);

        void eliminarArista(T origen, T destino);

        boolean existeVertice(T vertice);

        boolean existeArista(T origen, T destino);

        void mostrarMatriz();

        void mostrarVertices();
//        public void bfs();
//        public void dfs();
}
