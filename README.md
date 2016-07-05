# Desarrollo de Software

Prácticas de la asignatura Desarrollo de Software cursada en el Grado en Informática de la **Universidad de Granada**

----------

## Índice de Prácticas

### Práctica 1: Implementación de distintos patrones de diseño
En esta práctica se aborda tanto el diseño como la implementación de diferentes patrones de diseño.

> **Consideraciones:**

> - Los diseños han sido realizados con *Visual Paradigm*.
> - Las GUI no era necesario implementarlas pero si aconsejable para tener una mayor claridad en cuanto a los resultados.
> - Se ha utilizado el IDE *Eclipse* para el desarrollo de estas prácticas bajo sugerencia del profesor (ya que él ejecuta las prácticas en este IDE).
> - Se ha usado el plugin *WindowBuilder* para *Eclipse* con el que se ha desarrollado las GUI de los distintos ejercicios.
>
> **Implementaciones:**
>
> - Carrera de bicicletas - Factoria Abstracta
> - Monitor de temperaturas - Observable Observador
> - Configuración de equipos - Visitante
> - Simulador de coche - Interceptor (intercepting filter pattern)


### Práctica 2: Arquitectura de Software

Se encuentra en un repositorio aparte: [FarmaciaDS](https://github.com/romanarranz/FarmaciaDS)

En esta práctica se ha realizado una implementación del supuesto práctico 1 que se nos proporionaba en la asignatura.

Consistía en realizar un sistema de farmacias en el cual el usuario a través de su dispositivo móvil pudiera seleccionar entre las farmacias cercanas a él para acceder a ella y visualizar su catálogo de productos y comprar cuantos productos quisiera, además que esta operación la podría hacer en distintas farmacias para rellenar su cesta.

Una vez que ya ha terminado de rellenar su cesta, se procesa el pago para cada una de las farmacias en las cuales se han adquirido productos.

También se pedia realizar un backend para el farmaceutico y que pudiera realizar una gestión de su farmacia de forma amigable mediante una interfaz web.

> **Consideraciones**

> - La implementación de la aplicación para dispositivos móviles sólo se ha contemplado en la plataforma Android.
> - La implementación del backend se ha realizado con jsp y servlets.
> - El despliegue se ha hecho en un entorno real, más concretamente en Azure para el webservice.
> - La aplicación Android no se llegó a subir al market.

### Práctica 3: Pruebas unitarias y de Integración
En esta práctica se aborda tanto la implementación de una suite de pruebas para los distintos paquetes de test unitarios que tenemos que desempeñar para probar cada uno de las clases de nuestro SCAV (Sistema de Conduccion Automatica de Vehiculos).

> **Consideraciones:**

> - La implementación de SCAV fue proporcionada previamente.
> - Se permite realizar cambios en las clases en cuanto a obtencion de atributos o cambios de visibilidad, asi como arreglar defectos del software, pero **NO se permiten cambios de funcionalidad**.
> - Se ha utilizado el IDE *Eclipse* para el desarrollo de estas prácticas bajo sugerencia del profesor (ya que él ejecuta las prácticas en este IDE).
> - Se pide implementar una interfaz **"Pedal"** que será implementada por las clases `Acelerador` y `Freno`.
>
> **Implementaciones:**
>
> - `testControlVelocidad` - Paquete con los test para probar cada una de las clases del paquete `controlVelocidad`.
> - `testMonitorizacion` - Paquete con los test para probar cada una de las clases del paquete `monitorizacion`.
> - `testSimulador` - Paquete con los test para probar cada una de las clases del paquete `simulador`.
> - `testSuite` - Conjunto de pruebas que lanza cada una de las pruebas de los paquetes `testControlVelocidad`, `testMonitorizacion`, `testSimulador` todos de una vez.

Para probar el paquete Simulador tenemos que realizar una serie de cambios en cuanto al patrón Observable Observador, ya que tenemos implementarle una lista de Observadores y para probar este paquete tenemos que implementar las pruebas con TestListener.

## Licencia

Los detalles se encuentran en el archivo `LICENSE`. En resumen, todo el contenido tiene como licencia **GPLv2 License** por lo tanto es totalmente gratuito su uso para proyectos privados o de uso comercial, salvo por la restricción de que si usted modifica, vende o distribuye este código debe saber que ese código debe ser código abierto (*open-source*) igualmente (*deja de ser propietario a ser open-source*).
