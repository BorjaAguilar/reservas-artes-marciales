# Modelo de datos inicial

## Usuario

- Nombre
- Apellidos
- Correo_Electrónico
- Id_Usuario

## Disciplina

- Nombre_Disciplina
- Id_Disciplina

## Clase programada

- Id_Disciplina
- Fecha_Completa
- Hora_Inicio
- Id_Clase_Programada

## Reserva

- Id_Reserva
- Id_Usuario
- Id_Clase_Programada
- Estado_Reserva:
  - activa
  - cancelada

## Valores fijos de la primera versión

- Todas las clases tienen una capacidad de 30 plazas.
- Todas las clases duran 90 minutos.
- La hora de finalización se calcula sumando 90 minutos
  a la hora de inicio.
