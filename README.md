# Reservas de clases de artes marciales

## Descripción

Aplicación web en desarrollo para gestionar las reservas de clases de un gimnasio de artes marciales y deportes de combate.

Los usuarios podrán iniciar sesión, consultar las clases en un calendario semanal y reservar plazas. El calendario permitirá consultar las semanas hasta el último día del mes actual.

Antes de guardar una reserva, la aplicación pedirá confirmación al usuario. Después mostrará si la reserva se ha realizado correctamente.

El gimnasio será responsable de dar de alta a los usuarios.

## Disciplinas

- Boxeo.
- Muay Thai.
- BJJ gi.
- BJJ no gi.
- MMA.

## Reglas de reserva previstas

- Cada clase tendrá una capacidad máxima de 30 usuarios.
- Todas las clases tendrán una duración de 90 minutos.
- Será necesario iniciar sesión para realizar una reserva.
- Podrá haber clases de distintas disciplinas al mismo tiempo.
- Un usuario podrá reservar varias clases el mismo día, siempre que sus horarios no se solapen.
- Una clase podrá empezar justo cuando termine otra que el usuario tenga reservada.
- Un usuario no podrá reservar dos veces la misma clase.
- No se admitirán reservas cuando las 30 plazas estén ocupadas.
- El usuario podrá cancelar una reserva antes del inicio de la clase.
- Desde el instante de inicio, no se permitirá cancelar.
- Una cancelación liberará la plaza para otro usuario.

## Tecnologías

### Implementadas

- Java y Spring Boot para el servidor.
- Maven Wrapper para compilar, ejecutar pruebas y arrancar la aplicación.
- JUnit Jupiter para las pruebas automatizadas.
- Git y GitHub para gestionar y publicar el historial del proyecto.

### Previstas

- React y TypeScript para la interfaz.
- PostgreSQL para almacenar los datos.

## Estado del proyecto

El servidor Spring Boot dispone de tres rutas:

| Método | Ruta | Función |
|---|---|---|
| GET | `/api/saludo` | Comprobación inicial del servidor. |
| GET | `/api/disciplinas` | Consulta de todas las disciplinas. |
| GET | `/api/disciplinas/{id}` | Consulta de una disciplina por su identificador. |

Las disciplinas se representan mediante objetos de la clase `Disciplina`. Los datos están definidos en el código y se mantienen en memoria, sin conexión con una base de datos.

`DisciplinaController` atiende las peticiones HTTP y delega las consultas en `DisciplinaService`, que recibe mediante inyección por constructor.

Existen tres pruebas automatizadas: una de carga del contexto de Spring Boot y dos de búsqueda en el servicio. Las respuestas HTTP se han comprobado manualmente.

Las reservas, la autenticación, la integración con PostgreSQL y la interfaz están pendientes de implementación.

## Requisitos de desarrollo

- JDK que permita compilar para Java 21. El entorno comprobado utiliza JDK 24.
- Conexión a Internet durante la primera ejecución para descargar Maven y las dependencias.
- Puerto 8080 disponible para arrancar el servidor.

El repositorio incluye Maven Wrapper, por lo que no es necesario instalar Maven por separado.

## Ejecución local en Windows

Desde la raíz del repositorio, abrir PowerShell y ejecutar:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

Cuando aparezca el mensaje `Started BackendApplication`, abrir esta dirección en el navegador:

[Comprobar el servidor](http://localhost:8080/api/saludo)

La respuesta esperada es:

```text
Servidor de reservas de clases de artes marciales en funcionamiento
```

La ruta raíz `/` no tiene una respuesta definida y devuelve HTTP 404.

Para detener el servidor, pulsar **Ctrl + C** en la terminal. Si Windows solicita confirmar la finalización del trabajo por lotes, aceptar.

## Consulta de disciplinas

### Listar todas las disciplinas

Con el servidor en ejecución, realizar una petición GET a:

[Consultar disciplinas](http://localhost:8080/api/disciplinas)

La respuesta esperada devuelve HTTP `200 OK`, con tipo de contenido `application/json`:

```json
[
  {"id": 1, "nombre": "Boxeo"},
  {"id": 2, "nombre": "Muay Thai"},
  {"id": 3, "nombre": "BJJ gi"},
  {"id": 4, "nombre": "BJJ no gi"},
  {"id": 5, "nombre": "MMA"}
]
```

Cada elemento contiene:

- `id`: identificador numérico de la disciplina.
- `nombre`: nombre de la disciplina.

Los identificadores se asignan manualmente en el código. Actualmente, la consulta utiliza una lista fija de objetos `Disciplina`; todavía no utiliza PostgreSQL.

### Consultar una disciplina por identificador

Realizar una petición GET a `/api/disciplinas/{id}`, sustituyendo `{id}` por el identificador deseado.

Por ejemplo:

[Consultar Boxeo](http://localhost:8080/api/disciplinas/1)

La respuesta esperada devuelve HTTP `200 OK`, con tipo de contenido `application/json`:

```json
{
  "id": 1,
  "nombre": "Boxeo"
}
```

Si el identificador numérico no corresponde a ninguna disciplina, como en `/api/disciplinas/999`, la respuesta devuelve HTTP `404 Not Found`, sin cuerpo.

### Comprobación manual en PowerShell

Con el servidor en ejecución, abrir otra terminal y ejecutar:

```powershell
$respuesta = Invoke-WebRequest -Uri "http://localhost:8080/api/disciplinas" -UseBasicParsing
$respuesta.StatusCode
$respuesta.Headers["Content-Type"]
$respuesta.Content
```

Los resultados esperados son:

- Estado HTTP: `200`.
- Tipo de contenido: `application/json`.
- Contenido: un array de cinco objetos con las propiedades `id` y `nombre`.

Para comprobar las consultas individuales, utilizar los siguientes casos:

| Petición | Resultado esperado |
|---|---|
| `GET /api/disciplinas/1` | HTTP `200`, con el objeto de Boxeo. |
| `GET /api/disciplinas/3` | HTTP `200`, con el objeto de BJJ gi. |
| `GET /api/disciplinas/999` | HTTP `404`, sin cuerpo. |

## Pruebas

Las clases de pruebas se encuentran en `backend/src/test/java`.

Desde la carpeta `backend`, ejecutar:

```powershell
.\mvnw.cmd test
```

Para eliminar los resultados compilados anteriores y ejecutar las pruebas desde una compilación limpia:

```powershell
.\mvnw.cmd clean test
```

Actualmente se ejecutan tres pruebas:

| Clase | Comprobación |
|---|---|
| `BackendApplicationTests` | El contexto de Spring Boot carga correctamente. |
| `DisciplinaServiceTests` | Buscar el identificador `5` devuelve la disciplina MMA con sus datos esperados. |
| `DisciplinaServiceTests` | Buscar el identificador `999` devuelve un resultado vacío. |

La última ejecución comprobada terminó con:

```text
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Las pruebas del servicio validan la búsqueda directamente, sin arrancar Spring. Todavía no se comprueban automáticamente los estados HTTP, la serialización JSON ni las reglas de reserva.

## Importación en IntelliJ IDEA

Abrir la carpeta `backend` como proyecto Maven y esperar a que termine la importación de las dependencias.

En el entorno comprobado, la importación mediante Maven Wrapper produjo el error `No implementation for ArtifactHandlerManager was bound`. Se resolvió seleccionando:

**Settings → Build, Execution, Deployment → Build Tools → Maven → Maven home path → Bundled (Maven 3)**

Después del cambio, ejecutar **Reload All Maven Projects** desde el panel Maven.

Este ajuste afecta a la integración de Maven con IntelliJ. El wrapper del proyecto, configurado con Maven 3.10.1, se ha utilizado correctamente desde PowerShell para compilar, ejecutar las pruebas y arrancar el servidor.

## Documentación

- [Reglas y ejemplos de reserva](docs/reglas-reserva.md).
- [Modelo de datos inicial](docs/modelo-datos.md).
