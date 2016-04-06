Patrones
=========

Se han implementado y diseñado los distintos tipos de patrones arquitectónicos que se usan dentro del ámbito del **Desarrollo del Software**.

---------------

Los patrones de diseño aceleran el proceso de desarrollo y siguen los paradigmas de desarrollo. La reutilización de estos patrones de diseño ayuda a prevenir problemas y mejoran la legibilidad del código para los programadores y arquitectos familiarizados con los patrones.

##Clasificación de los Patrones

###Patrones de diseño Creacionales
Acerca de instanciaciones de clases. Se dividen en creaciones de patrones para clases y creación de patrones para enfocados a creación de objetos.

Mientras que la creación de clases usa herencia para el proceso de instanciación, la creación de objetos usa patrones de delegación.

- **Factoria Abstracta:** Crea una instancia de varias familias de clases.
- **Builder (Constructor):** Separa la construcción del objeto de su representación.
- **Factoria:** Crea una instancia de varias clases derivadas (que heredan de otra).
- **Prototipo:** Una instancia completamente inicializada para ser copiada o clonada.
- **Singleton:** Cuando sólo puede existir una instancia de una clase.
- **Objeto Piscina:** Evita el costo y la liberación de los recursos mediante el reciclaje de objetos que están ya no se usen.


###Patrones de diseño Estructurales
Acerca de la clase y composición de objetos. La creación de clases usan la herencia en la composición de interfaces. Los patrones estructurales de objetos definen formas de componer objetos que obtienen una nueva funcionalidad.

- **Adaptador:** Diferentes clases tienen la misma interfaz.
- **Puente (Bridge):** Separan la interfaz de los objetos de su implementación.
- **Compuesto (Composite):** Una estructura de árbol de objetos simples y compuestos.
- **Delegacion (Delegation):** Cuando un objeto de cara al exterior expresa cierto comportamiento pero en realidad delega la responsabilidad en otro.
- **Decorador (Decorator):** Añade responsabilidades a los objetos de forma dinámica. Es como delegacion pero más flexible y fuertemente tipada.
- **Fachada:** Una única clase que representa un subsistema.
- **Peso Mosca (Flyweight):** Cuando tenemos una clase muy pesada y queremos instanciarla varias veces con algún cambio en los objetos que la instancian.
- **Inmutable (Private Class Data):** Restringe el acceso ya que hace la clase solo lectura.
- **Proxy:** Un objeto que representa otro objeto.

###Patrones de diseño Comportamentales
Acerca de la comunicación de objetos con la clase. Estos patrones tienen que ver únicamente con la comunicación entre objetos.

- **Cadena de responsabilidad:** Una manera de transmitir una solicitud entre una cadena de objetos.
- **Comando (Command):** Encapsula una petición como un objeto.
- **Intérprete:** Una manera de incluir elementos del lenguaje de un programa.
- **Iterador:** Acceder de forma secuencial a los elementos de una colección.
- **Mediador:** Define una comunicación simple entre clases.
- **Memento:** Capta y restaura el estado interno de un objeto.
- **Null Object:** Diseñado para actuar como valor por defecto de un objeto.
- **Observador:** Una forma de notificar el cambio a un número de clases.
- **Estado:** Altera el comportamiento de un objeto cuando cambia su estado.
- **Estrategia:** Encapsula un algoritmo dentro de una clase.
- **Template Method:** Define los pasos de un algoritmo para una subclase.
- **Visitante:** Define una nueva operación aplicable a una serie de calses sin cambiar provocar cambios en dicha serie.

##Critica

###Problema equivocado
En ocasiones el lenguaje de programación o las técnicas no cuentan con la suficiente capacidad de abstracción. A veces los patrones no son una solución eficiente ó elegante.

###Carecen de fundamentos formales
El estudio de los patrons de diseño ha sido excesivamente ad-hoc y hay investigadores que han planteado que el concepto necesita estar expresado en un plano más formal.

###Conducen a soluciones ineficaces
La idea de patrón es un intento de estandarizar lo que ya son buenas prácticas aceptadas. Pero puede resultar de este proceso que tengamos código duplicado.

###No difieren significativamente de otras abstracciones
Según algunos autores la nueva terminologia para describir los fenomenos existentes en el campo de la programación es innecesaria. El paradigma MVC se promociona como un ejemplo de "patrón", aun siendo anterior al concepto de "patrones de diseño". Se afirma que la principal contribución de los patrones de diseño (sugerida por la Banda de los Cuatro) fue el uso de los patrones de Alexander como una forma de documentación.