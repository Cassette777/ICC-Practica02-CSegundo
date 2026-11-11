# ICC-Practica02-CSegundo
Repositorio sobre la segunda práctica del semestre I de Ciencias de la Computación

# Práctica 02 
#### Datos del alumno

Alumno: Cassandra Guadalupe Segundo Faustino

Número de cuenta: **324140561**

Correo: cassandra.fausg@ciencias.unam.mx

#### Profesorado e información de entrega
*Grupo: 7033*

*Materia: Introducción a Ciencias de la Computación* 

 Institución: Universidad Nacional Autónoma de México
 
  - Profesor  : Salvador López Mendoza
  - Ayud. T.a : Yanahí Demetrio Torres
  - Ayud. Lab: Rosa Victoria Villa Padilla

   Fecha límite de entrega: 13/11/2026
   
   Fecha de inicio de práctica: 3/11/2026
   
#### Información sobre la práctica
###### Objetivos de la práctica:

- Que el alumno ejercite la teoría del uso y aplicación de las instrucciones condicionales dentro de un programa.

- Que el alumno practique la creación y uso de objetos de clases existentes.

### Programas elaborados

###### TiempoDeInversion.java:
Un programa donde se lleva acabo una interacción usuario-programa en el que a base de fechas, se cálcula un redimiento con los días de diferencia entre las mismas y un monto dado.

-> Ubicado en: /CSegundo/practica02/src/icc/

###### Fecha.java:
Una clase donde establecemos todos los métodos necesarios para ser usados por TiempoDeInversion.java y poder realizar los incisos solicitados en la práctica:

-> Ubicado en: /CSegundo/practica02/src/icc/

###### Constructores de la clase fecha
``` Java

//Constructor por defecto
Fecha() 
//Constructor mediante int
Fecha(int dia, int mes, int year)
//Constructor con mes en String
Fecha(int dia, String mes, int year)

```

###### Métodos pertenecientes a la clase fecha

``` Java
//Setters
asignarDia(int dia)
asignarMes(int mes)
asignarYear(int year)
asignarFecha(int dia, int mes, int year)

//Getters
obtenerDia() @return dia/
obtenerMes()  @return mes/
obtenerYear() @return year/
obtenerFecha() @return fecha dd/mm/aaaa/
obtenerFechaFormato() @return dd/mes/aaaa/

//Auxiliares
obtenerNombreMes(int numeroMes) @return String mes/
obtenerNumMes(String mes) @return mes/
igualdad(Fecha otraFecha) @return boolean/
validez(int d, int m) @return boolean/
dias(int mes, int year) @return int (muestra los días que debe tener un mes)/

//Calculadores
sumaTotal() @return int sumaTotal/
sumaOresta(int cantidadDias) @return Fecha/
obtenerDiferencia(Fecha nuevaFecha) @return int (dias entre cada fecha)/
calcularDiasMes(int dia, int mes) @return int (dias entre mes)/
calcularDiasYear(int year) @return int (dias en el año)/
```


### Incisos solicitados en la práctica 

a) Crear fecha inicial
- Podemos hacerlo mediante:
	- Fecha() [Constructor por defecto]  
	- Fecha(int dia, int mes, int year) [Constructor con int]
	- Fecha(int dia, String mes, int year) [Constructor con String mes]

b) Asignar valor a los campos de una fecha
- Podemos hacerlo mediante:
	- asignarDia(int dia)
	- asignarMes(int mes)
	- asignarYear(int year)
	- asignarFecha(int dia, int mes, int year)

c) Obtener los campos de una fecha
- Podemos hacerlo mediante:
	- obtenerDia()
	- obtenerMes()
	- obtenerYear()
	- obtenerFecha() -> Si son puros int
	- obtenerFechaFormato() -> Si mes es String

d) Obtener la diferencia, en días, entre dos fechas.
- Podemos hacerlo con:
	- obtenerDiferencia(Fecha nuevaFecha)
	- p.ej: fecha1.obtenerDiferencia(fecha2);

e) Dada una fecha inicial y un número entero, obtener la fecha que corresponde:
- Podemos hacerlo con:
	- sumaOresta(int cantidadDias) 
	- Pero para obtener una nueva fecha visible en dd/mm/aaaa necesitaremos el método auxiliar:
		- obtenerFecha()

``` Java

System.out.println((fecha2.sumaOresta((-9))).obtenerFecha());
// Prueba parte de TiempoDeInversion
```

f) Determinar si dos fechas son iguales:
- Podemos hacerlo con:
	- igualdad(Fecha otraFecha)

g) Devolver el número correspondiente a un mes a partir de que reciba una cadena.
- Podemos hacerlo mediante:
	- obtenerNumMes(String mes)

h) Devolver la cadena correspondiente a un mes a partir de que reciba un número.
- Podemos hacerlo mediante:
	- obtenerNombreMes(int numeroMes)

i) Dada una fecha, especificar los días transcurridos en el año.
- Podemos hacerlo mediante:
	- calcularDiasMes(int dia, int mes)

j) Representar una fecha en el formato dd/mes/aaaa
- Podemos hacerlo mediante:
	- obtenerFechaFormato()

En caso de que mes sea int siempre podemos mandar llamar a obtenerNombreMes().

#### Incisos parte de la clase TiempoDeInversion

Para ello veremos un ejemplo práctico del funcionamiento del programa:

##### Ejemplo de interacción

``` Java

// (a) Dar bienvenida
Bienvenido a BanCoppel, ¿cuál es su nombre?
// (b) Recabar nombre del inversionista 
Cassette
// (c) Saludar al inversionista y preguntar por el monto a invertir
Saludos, Cassette.
¿Cuánto deseas invertir?
// (d) Recabar monto
10000
// (e) Preguntar por una fecha de inversión
¿Desde que fecha inicia su inversión?
// (f) Recabar fecha de inicio de inversión
Introduzca el dia
24
Introduzca el mes
10
Introduzca el año
2026
// (g) Preguntar por una fecha de fin de inversión
¿Cuándo desea terminar esta inversión?
// (h) Recabar fecha fin de inversión
Introduzca el dia
29
Introduzca el mes
12
Introduzca el año
2026
// (i) Mostrar al usuario los días de inversión y el rendimiento al 12%
Su inversión duraría: 66 días.
Su rendimiento a un 12% sería de: 216.986301369863
// (j) Preguntar si desea hacer otra simulación. En caso de si, volver a 3(c).
Desea hacer otra simulación?


```

Cómo parte de nuestro main aceptamos para hacer otra simulación aceptamos: {"si", "sí", "SI", "Si", "Sí", SÍ}, ante otra respuesta terminará el problema.

Además tenemos diversas reglas que pueden darnos algún mensaje o comportamiento que simula un error.

#### Casos con pseudoerrores
1. Si la fecha inicial es posterior a la fecha final
- La forma que tenemos para mostrar un error es marcar la duración de la inversión y el monto como 0.0
``` Java
¿Cuánto deseas invertir?
12000
¿Desde que fecha inicia su inversión?
Introduzca el dia
10
Introduzca el mes
3
Introduzca el año
2024
¿Cuándo desea terminar esta inversión?
Introduzca el dia
15
Introduzca el mes
1
Introduzca el año
2023
Favor de introducir fechas válidas, el año inicial debe ser anterior al final.
Su inversión duraría: 0 días.
Su rendimiento a un 12% sería de: 0.0
Desea hacer otra simulación?

```

2. Si el mes que ingresamos es mayor a 12
- El programa únicamente considera el primer dígito del número que ingresemos.

``` Java

¿Cuánto deseas invertir?
10000
¿Desde que fecha inicia su inversión?
Introduzca el dia
12
Introduzca el mes
15
Introduzca el año
2026
¿Cuándo desea terminar esta inversión?
Introduzca el dia
3
Introduzca el mes
6
Introduzca el año
2027
//Nuestro cálculo es correcto para la fecha 12/1/2026, es decir, se ignora el 5 del 15.
Su inversión duraría: 507 días.
Su rendimiento a un 12% sería de: 1666.8493150684933
Desea hacer otra simulación?

```
###### Nota:
Si nosotros ingresamos un número de días mayor al límite del mes igual funcionará pero arrojará un mensaje.

Por ejemplo: Si introducimos algún número como 40, lo que hará es sumar los días extra al siguiente mes de tal forma que ese 40 nos de una fecha correcta. Pero, si es inválido alguno de los parámetros, el programa regresará:

> "Sus datos de entrada son incorrectos en mes o día, recuerde que el cálculo puede ser erróneo."


### Forma de compilación y ejecución (Linux)
``` Java
//Para compilar TiempoDeInversion (main)
javac TiempoDeInversion.java
//Para ejecutar el main, es decir, TiempoDeInversion
java TiempoDeInversion

//Para compilar Fecha (clase con métodos)
javadoc Fecha.java
//Dado que Fecha no contiene main no hay que ejecutar el main.

```

###### Notas:
- El código se documentó en Javadoc según lo visto en clase y en referencia al marco del libro de _Introducción al desarrollo de programas con Java by Amparo García & [comandos](https://ranger.uta.edu/~tiernan/CSE1325/spring14/Javadoc%20Tutorial.htm)._
    
- Los _archivos.java_ se encuentran contenidos en la secuencia de carpetas: /CSegundo/practica02/src/icc/
    
- El código fue probado en Java 24.

- El programa funciona con int ante el monto, por lo que se debe considerar su rango al dar un monto de inversión.
