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
- Git y GitHub para gestionar y publicar el historial del proyecto.

### Previstas

- React y TypeScript para la interfaz.
- PostgreSQL para almacenar los datos.

## Estado del proyecto

El servidor Spring Boot arranca y dispone de `GET /api/saludo` como comprobación inicial. La prueba de carga del contexto de la aplicación pasa correctamente.

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

La ruta `/api/saludo` es una comprobación inicial del servidor. La ruta raíz `/` no tiene una respuesta definida y devuelve HTTP 404.

Para detener el servidor, pulsar **Ctrl + C** en la terminal. Si Windows solicita confirmar la finalización del trabajo por lotes, aceptar.

## Pruebas

Desde la carpeta `backend`, ejecutar:

```powershell
.\mvnw.cmd test
```

Actualmente existe una prueba que comprueba que el contexto de Spring Boot puede cargarse correctamente. Todavía no se comprueban automáticamente la respuesta de `/api/saludo` ni las reglas de reserva.

Una ejecución correcta debe finalizar con `BUILD SUCCESS` y sin fallos ni errores en el resumen de pruebas.

## Importación en IntelliJ IDEA

Abrir la carpeta `backend` como proyecto Maven y esperar a que termine la importación de las dependencias.

En el entorno comprobado, la importación mediante Maven Wrapper produjo el error `No implementation for ArtifactHandlerManager was bound`. Se resolvió seleccionando:

**Settings → Build, Execution, Deployment → Build Tools → Maven → Maven home path → Bundled (Maven 3)**

Después del cambio, ejecutar **Reload All Maven Projects** desde el panel Maven.

Este ajuste afecta a la integración de Maven con IntelliJ. El wrapper del proyecto, configurado con Maven 3.10.1, se ha utilizado correctamente desde PowerShell para compilar, ejecutar las pruebas y arrancar el servidor.

## Documentación

- [Reglas y ejemplos de reserva](docs/reglas-reserva.md).
- [Modelo de datos inicial](docs/modelo-datos.md).
