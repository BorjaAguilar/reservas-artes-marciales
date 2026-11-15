# Reglas de reserva

## Ejemplos de comportamiento

### Última plaza

- Una clase tiene 29 plazas reservadas y un usuario sin conflictos de horario intenta reservar

- Resultado esperado: El usuario podrá reservar correctamente la clase, y no se permitirán más reservas, ya que se habrá alcanzado el número máximo de asistentes a la clase. La clase permanecerá completa mientras no se libere ninguna plaza.

### Clase completa

- Una clase tiene todas las plazas reservadas y un usuario intenta reservar

- Resultado esperado: Aparecerá un mensaje de error indicando que las plazas para esa clase están completas. No se crea ninguna reserva y las existentes permanecen iguales

### Solapamiento

- Un usuario tiene una clase de 18:00 a 19:30 e intenta reservar otra clase de 19:00 a 20:30

- Resultado esperado: Aparecerá un mensaje de error indicando que tiene reservada una clase que interfiere con el horario de la clase que quiere reservar. No se crea ninguna reserva nueva y las existentes permanecen iguales

### Clases consecutivas

- Un usuario tiene una clase reservada de 18:00 a 19:30 e intenta reservar otra clase de 19:30 a 21:00

- Resultado esperado: El usuario podrá reservar correctamente las dos clases siempre y cuando haya plazas disponibles en la segunda. La nueva reserva se acepta y la anterior se conserva

### Cancelación

- La clase empieza a las 18:00. Indicar qué ocurre si el usuario cancela a las 17:59. Indicar qué ocurre si cancela a las 18:00

- Resultado esperado: El usuario podrá cancelar a las 17:59 y se liberará una plaza. Desde las 18:00, la aplicación rechaza la cancelación y mantiene la reserva activa. La interfaz deshabilita la opción de cancelar.
