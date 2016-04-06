Fachada
=======

##Intención

Proporciona una interfaz unificada que engloba un conjunto de interfaces de un subsistema. Lo que hace más fácil usar el subsistema gracias a esta interfaz.

##Problema

El cliente necesita una interfaz sencilla para acceder a la funcionalidad general de un subsistema.

##Discusión

Encapsula un subsistema complejo dentro de un único objeto interfaz. esto reduce el hecho de conocer bien al subsistema. Si la fchada es el único puente con el subsistema limitará las características y fleixibilidad que los clientes avanzados podrían utilizar.

##Verificación

1. Identificar una interfaz más sencilla que unifique el subsistema o componente.
2. Diseñar una clase envoltorio que encapsule el subsistema.
3. Los clientes sólo interactuan con la fachada.

##Conclusiones

- Fachada define una nueva interfaz, mientras que el patrón **Adaptador** utiliza dos interfaces existentes.
- **Mediador** es similar a Fachada en que abstrae la funcionalidad de las clases existenes, este centraliza las comunicaciones entre objetos arbitrarios "amigos" y puede añadir nueva funcionalidad. Sin embargo Fachada no añade nueva funcionalidad y no entiende de las clases relacionadas con el subsistema más que con la que se comunica directamente.
- Fachada tiene **sinergia con Singleton** ya que normalmente solo suele haber una única fachada.
- Factoria Abstracta se podría usar como alternativa a Fachada para ocultar las clases específicas del subsistema.