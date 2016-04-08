Delegación
===========

##Intención

- Encapsular funcionalidad en otra clase.
- Cambiar el delegante en tiempo de ejecución.

##Problema

Se quiere separar los diferentes conjuntos de funcionalidad entre clases.
Se quiere además obtener una gran flexibilidad en cuanto a la realización de los cambios entre clases en tiempo de ejecución.

##Discusión

El patrón delegación se tiende a comparar con las propiedades de herencia. Ambas son técnicas de reutilización de gran magnitud salvo por algunas diferencias; la herencia presenta hoy en día compatibilidad con los lenguajes de programación orientados a objetos y que permiten el uso del polimorfismo pero se realiza en tiempo de compilación, mientras que el patrón delegación permite al delegado realizar cambios en tiempo de ejecución.

El patrón delegación suele no resultar tan trivial como el mecanismo de herencia.

##Estructura

![image1](uml.svg)

##Verificación

1. Crear clase de datos. Mover a la clase de datos todos los atributos que necesitamos proteger.
2. Crear en la clase principal una instancia de la clase de datos.
3. Clase principal debe inicializar la instancia de la clase de datos a través de del constructor de la clase de datos.
4. Exponer cada **atributo de la clase de datos** a través de un **getter**.
5. Exponer cada atributo que es susceptible de cambiar a través de un **setter**.
