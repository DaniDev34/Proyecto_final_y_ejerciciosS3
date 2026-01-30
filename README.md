# Avance Proyecto Final 

Dentro de esta rama se detalla el avance del proyecto final para Programación Orientada a Objetos **(POO)**
---

## Introducción

Esta documentación describe un avance del diseño y análisis de un sistema de **préstamos de videojuegos**
En este avance se realiza un análisis de los requerimientos del sistema, el diseño de clases y sus relaciones, así como la elaboración del diagrama UML que los representa a detalle. El objetivo principal es definir de manera clara cómo debe funcionar el sistema antes de llegar a la etapa funcional, para asegurar así que se cumplan los requisitos solicitados y se facilite su comprensión.

## Análisis de Requerimientos 

Este sistema tiene como objetivo gestionar préstamos de videojuegos, que permita **registrar y consultar videojuegos**, así como también gestionar préstamos realizados. El sistema debe garantizar la coherencia de la informaicón, validar los datos ingresados y controlando disponibilidades de productos.  

Una de las reglas principales de este sistema es que se limita a un máximo de **2 videojuegos prestados por cliente** de manera simultánea, para evitar que un mismo usuario exceda el límite establecido. También, este sistema debe impedir el préstamo de videojuegos que no se encuentran disponibles en el inventario y generar reportes en pantalla sobre el estado del inventario.

## Requisitos funcionales 
Para garantizar una gestión básica del **sistema de préstamos de videojuegos** se definen los siguientes requisitos funcionales:

1. El sistema debe permitir registrar y consultar videojuegos disponibles para un préstamo.

2. El sistema debe permitir registrar y consultar clientes que hacen uso del sistema.

3. El sistema debe permitir registrar y consultar empleados acargo de los préstamos.

4. El sistema debe permitir registrar préstamos de videojuegos, asociando un cliente, un empleado y uno o más videojuegos.

5. El sistema debe validar la disponibilidad de los videojuegos antes de realizar un préstamo.

6. El sistema debe limitar el número de videojuegos prestados, permitiendo un máximo de dos videojuegos por cliente.

7. El sistema debe permitir registrar la devolución de videojuegos, y actualizar la disponibilidad del inventario.

8. El sistema debe mostrar reportes en pantalla con información básica sobre los videojuegos y los préstamos realizados.

## Requisitos no funcionales

Asímismo el sistema debe cumplir con los siguientes requisitos no funcionales:

1. El sistema debe ser fácil de usar, mediante un menú sencillo y opciones claras.

2. El sistema debe estar optimizado, validando los datos ingresados y evitando errores durante su uso.

4. El sistema debe ser eficiente, permitiendo que se hagan consultas rápidas de la información registrada.

5. El sistema debe ser escalable, para facilitar la incorporación de nuevas funcionalidades a futuro.

---

## Diseño de Clases y Objetos

Para este sistema existen 5 clases:


1. La clase **Persona** representa a los individuos que interactúan con el sistema. Esta clase agrupa tanto como a los usuarios que solicitan préstamos como a los empleados que los registran, ya que ambos comparten atributos comunes como identificación y datos personales. La diferencia entre un usuario y un empleado se puede definir a través de un atributo que indique su tipo o rol dentro del sistema. La unificación de estas clases en una sola ayuda a reducir las clases, simplificar el diseño y reducir información duplicada. 

1. La clase **Videojuego** representa los productos disponibles para préstamo y tiene información relevante como la identificación, título, género y disponibilidad del videojuego. Es importante para el control del inventario y validar si un producto puede ser prestado. 


4. La clase **Prestamo** es la transacción mediante el cual la persona **Cliente** puede solicitar un préstamo de un0 o dos videojuegos. Esta clase relaciona a la persona **Empleado**, que realiza el préstamo con los videojuegos prestados y almacena la información relevante como el Ticket de préstamo, fecha de devolución, fecha de préstamo, y el estado del préstamo. Éste mismo puede aplicar la regla principal del sistema que limita a un máximo de 2 videojuegos por persona.  

5.Finalmente, la clase **Inventario** se encarga de gestionar el conjunto de videojuegos registrados detro del sistema. Esta clase permite almacenar, consultar, y actualizar la disponibilidad de los videojuegos, garantizando así que toda la información sea coherente y sólida durante los préstamos y devoluciones. 

---

## Relación entre clases

En este sistema, las clases se relacionan entre sí para representar el funcionamiento del proceso. Además, permiten que la información fluya de manera correcta entre los distintos objetos del sistema y garantizan la coherencia de los datos.

- La clase **Persona** se relaciona con la clase **Prestamo**, ya que una persona puede participar en uno o varios préstamos en el sistema. Cada préstamo está asociado a una persona, quien puede desempeñar el rol de unusuario o de un empleado, dependiendo del contexto en el préstamo. 

La clase **Prestamo** se relaciona con la clase **Videojuego**, ya que un préstamo puede incluir uno o varios videojuegos. En base a las reglas del sistema, un préstamo puede contener un máximo de 2 videojuegos, permitiendo controlar el uso del inventario y evitar que se exceda el límite establecido.

La clase **Inventario** se relaciona con la clase **Videojuego**, debido a que el inventario es el encargado de almacenar y gestionar los videojuegos disponibles para un préstamo. Esta relación permite consultar la disponibilidad de los videojuegos y actualizarse cuando se realiza un préstamo o una devolución.

---

## Diagrama UML 

---

## Documentación del diseño

El diseño del sistema de **préstamos de videojuegos** se hizo con el objetivo de mantener una estructura clara y organizada, sienfdo fácil su comprensión y posteriormente su implementación. Para ello, se definieron las clases con **responsabilidades específicas**, evitar la **duplicación de información** y separando adecuadamente las funciones del sistema.

La unificación de **usuarios** y **empleados** en la clase **Persona** permite simplificar el diseño, ya que ambos comparten atributos y métodos comunes. Usando un atributo que define el rol de la persona, el sistema podrá distinguir entre quien solicita un préstamo y quien lo registra, sin tener la necesidad de crear clases separadas.

En la clase **Videojuego** se encarga de representar los productos disponibles para préstamo, mientras que la clase **Inventario** se centra en la gestión y disponibilidad de los videojueogos. Esto asegura que la información del inventario se mantenga sólida y que los préstamos solo se realicen cuando los videojuegos tengan ejemplares disponibles.

La clase **Prestamo** modela la transacción de préstamo y permite aplicar las reglas principales del sistema, como el límite máximo de videojuegos por préstamo y el control de fechas y estado. Siendo así, el diseño garantiza que los requisitos funcionales se cumplan de manera adecuada.

---

## Conclusión 

En este avance se presentó el análisis y diseño de un sistema de **préstamos de videojuegos**, identificando los requerimientos funcionales y no funcionales, así como también las clases principales y sus relaciones. El uso del modelado correcto **orientado a objetos** y de **diagramas UML** permitió representar de manera clara la estructura de este sistema y su funcionamiento en general. Este diseño servirá posteriormente como base para la implementación del sistema, permitiendo desarrollar una solución bien organizada y fácil de mantener.