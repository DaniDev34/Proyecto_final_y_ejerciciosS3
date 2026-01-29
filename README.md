# Avance Proyecto Final 

Dentro de esta rama se detalla el avance del proyecto final para Programación Orientada a Objetos **(POO)**

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

1. La clase **Videojuego** representa los productos disponibles para préstamo y tiene información relevante como la identificación, título, género y disponibilidad del videojuego.

2. La clase **Cliente** representa a los usuarios que solicitan los préstamos y permite controlar el número de videojuegos prestados de forma activa.

3. La clase **Empleado** representa al personal encargado de registrar y administrar los préstamos dentro del sistema.

4. La clase **Prestamo** modela la transacción de préstamo, almacenando la información del cliente, empleado, videojuegos prestados y el estado del préstamo.

5.Finalmente, la clase **Inventario** centraliza la gestión de los videojuegos disponibles y su control de disponibilidad.

---

## Relación entre clases

---

## Diagrama UML 

---

## Documentación del diseño

---