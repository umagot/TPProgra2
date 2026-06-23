Nombre del proyecto: CUF Code

Integrantes del grupo: Gotfryd Uma, Nasute Candelaria y Rodriguez Herrero Francisco

Alternativa elegida: A - Ecosistema de Red Social Profesional

Estructuras de datos utilizadas: Hasta la segunda entrega: diccionarios (que funcionan como si fuesen Hashes), grafos (matriz de adyacencias), listas enlazadas y pilas. Luego implementaremos arboles y colas para las siguientes funcionalidades.

Funcionalidades implementadas en la segunda etapa: Identificación inmediata, Red de Contactos, Historial de cambios y Jerarquía de habilidades (esta última parcialmente implementada) 

Funcionalidades implementadas en la tercera etapa:Terminamos la jerarquia de habilidades, Gestion de postulacion y validaciones

Link del repositorio: https://github.com/umagot/TPProgra2

Actividades realizadas por cada integrantes: no nos dividimos por actividades sino que fuimos haciendo todo en conjunto y repartiendonos tareas secundarias.

## 🧪 Guía Recomendada de Pruebas

Al iniciar la aplicación, el sistema precarga automáticamente 3 usuarios (ID: 1, 2, 3) para facilitar la evaluación de las estructuras. Se sugiere seguir este flujo para probar todas las funcionalidades:

**1. Verificación del Diccionario (Tabla Hash):**
* Seleccionar la **Opción 2** y buscar el ID `1` para comprobar la recuperación instantánea de un perfil existente.
* Seleccionar nuevamente la **Opción 2** e ingresar un ID inexistente (ej. `99`) para verificar el manejo de errores del sistema.

**2. Verificación de la Pila (Historial de Cambios):**
* Ingresar a la **Opción 3** (Editar usuario), ingresar el ID `3` y modificar su nombre o mail.
* Volver al menú principal, seleccionar la **Opción 4** (Deshacer cambio), ingresar el mismo ID y comprobar que el perfil recupera su estado original.

**3. Verificación del Árbol N-ario (Búsqueda por Jerarquía):**
* Ingresar a la **Opción 9** (Buscar usuarios por perfil).
* Seleccionar el filtro por Especialidad y elegir `Tecnologia`. Comprobar que el sistema recorre el árbol y lista únicamente al usuario correspondiente a esa rama.

**4. Verificación del Grafo (Red de Contactos):**
* Utilizar la **Opción 6** para conectar a los usuarios `1` y `2`.
* Luego, acceder a la **Opción 7** con el ID `1` para visualizar la matriz/lista de adyacencia funcionando: se visualizará al nuevo contacto y las recomendaciones automáticas de la plataforma.

**5. Verificación de la Cola (Gestión de Postulaciones):**
* Ingresar a la **Opción 8** para abrir el submenú de empleos.
* Registrar una nueva postulación usando uno de los ID válidos (ej. `2`) y seleccionar un puesto.
* En el mismo submenú, elegir evaluar la próxima postulación. Verificar que el sistema muestra el perfil completo por orden de llegada (FIFO) y proceder a aceptarla o rechazarla para desencolarla.
