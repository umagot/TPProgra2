package Interfaces;

public interface IGrafo <T> {

        void insertarUsuario(T usuario);

        void eliminarUsuario(T usuario);

        void insertarRelacion(T origen, T destino);

        void eliminarRelacion(T origen, T destino);

        boolean existeUsuario(T usuario);

        boolean existeRelacion(T origen, T destino);

        void mostrarMatriz();

        void mostrarUsuarios();
//        public void bfs();
//        public void dfs();

}
