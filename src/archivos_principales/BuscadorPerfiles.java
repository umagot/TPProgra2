package archivos_principales;

import Implementaciones.Arbol_Categoria;

/**
 * BuscadorPerfiles: Módulo de búsqueda avanzada de usuarios.
 * 
 * Permite buscar usuarios según criterios:
 * - Especialidad (opcional)
 * - Subespecialidad (opcional)
 * - Habilidad específica (opcional)
 * 
 * La búsqueda es exacta pero case-insensitive.
 * Ejemplo: buscar "java" encontrará "Java" pero no "JavaScript"
 * 
 * Complejidad: O(n * m) donde n = cantidad de usuarios, m = cantidad de habilidades
 */
public class BuscadorPerfiles {

    /**
     * Busca usuarios según los filtros proporcionados.
     * Los filtros son opcionales (null = sin filtro en ese campo).
     * 
     * @param usuarios Array de todos los usuarios
     * @param nombreEspecialidad Nombre de especialidad a buscar (null para ignorar)
     * @param nombreSubespecialidad Nombre de subespecialidad a buscar (null para ignorar)
     * @param nombreHabilidad Nombre de habilidad a buscar (null para ignorar)
     * @return Array de usuarios que coinciden con los criterios
     */
    public static Usuario[] buscarPorFiltros(
            Usuario[] usuarios,
            String nombreEspecialidad,
            String nombreSubespecialidad,
            String nombreHabilidad) {

        if (usuarios == null || usuarios.length == 0) {
            return new Usuario[0];
        }

        // Normalizamos los filtros a lowercase para comparación case-insensitive
        String espNorm = nombreEspecialidad != null ? nombreEspecialidad.toLowerCase().trim() : null;
        String subNorm = nombreSubespecialidad != null ? nombreSubespecialidad.toLowerCase().trim() : null;
        String habNorm = nombreHabilidad != null ? nombreHabilidad.toLowerCase().trim() : null;

        // Arreglo temporal para almacenar resultados
        Usuario[] resultados = new Usuario[usuarios.length];
        int cantidadResultados = 0;

        // Iteramos sobre cada usuario
        for (int i = 0; i < usuarios.length; i++) {
            Usuario usuario = usuarios[i];

            // Saltamos usuarios sin perfil
            if (usuario.getPerfil() == null) {
                continue;
            }

            // Verificamos si coincide con todos los filtros
            if (cumpleConjuntoFiltros(usuario, espNorm, subNorm, habNorm)) {
                resultados[cantidadResultados] = usuario;
                cantidadResultados++;
            }
        }

        // Retornamos array exacto del tamaño de resultados
        Usuario[] resultadosFinal = new Usuario[cantidadResultados];
        for (int i = 0; i < cantidadResultados; i++) {
            resultadosFinal[i] = resultados[i];
        }

        return resultadosFinal;
    }

    /**
     * Verifica si un usuario cumple con TODOS los filtros proporcionados.
     * Solo se verifica un filtro si está presente (no null).
     */
    private static boolean cumpleConjuntoFiltros(
            Usuario usuario,
            String especialidadNorm,
            String subespecialidadNorm,
            String habilidadNorm) {

        Perfil perfil = usuario.getPerfil();

        // Filtro 1: Especialidad
        if (especialidadNorm != null) {
            if (perfil.getEspecialidad() == null) {
                return false;
            }
            if (!perfil.getEspecialidad().getNombre().toLowerCase().equals(especialidadNorm)) {
                return false;
            }
        }

        // Filtro 2: Subespecialidad
        if (subespecialidadNorm != null) {
            if (perfil.getSubespecialidad() == null) {
                return false;
            }
            if (!perfil.getSubespecialidad().getNombre().toLowerCase().equals(subespecialidadNorm)) {
                return false;
            }
        }

        // Filtro 3: Habilidad (búsqueda exacta en el arreglo)
        if (habilidadNorm != null) {
            if (!tieneHabilidad(perfil, habilidadNorm)) {
                return false;
            }
        }

        // Si llegamos aquí, el usuario cumple con todos los filtros
        return true;
    }

    /**
     * Verifica si un perfil contiene una habilidad específica (búsqueda exacta, case-insensitive).
     */
    private static boolean tieneHabilidad(Perfil perfil, String habilidadNorm) {
        Habilidad[] habilidades = perfil.getHabilidades();

        if (habilidades == null || habilidades.length == 0) {
            return false;
        }

        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i].getNombre().toLowerCase().equals(habilidadNorm)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Imprime los resultados de búsqueda de forma legible
     */
    public static void imprimirResultados(Usuario[] usuarios, String nombreBusqueda) {
        System.out.println("\n========================================");
        System.out.println("   RESULTADOS DE BÚSQUEDA: " + nombreBusqueda);
        System.out.println("========================================");

        if (usuarios == null || usuarios.length == 0) {
            System.out.println("❌ No se encontraron usuarios que coincidan con los criterios.");
            return;
        }

        System.out.println("✅ Se encontraron " + usuarios.length + " usuario(s):\n");

        for (int i = 0; i < usuarios.length; i++) {
            System.out.println((i + 1) + ". " + usuarios[i]);
            System.out.println("   └─ Especialidad: " + usuarios[i].getPerfil().getEspecialidad().getNombre());
            System.out.println("   └─ Subespecialidad: " + usuarios[i].getPerfil().getSubespecialidad().getNombre());
            System.out.println();
        }
    }

}
