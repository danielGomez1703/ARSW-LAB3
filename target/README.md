# OO Design 
este programa es una muestra de los diferentes sockets de java. como ejemplo podra encontrar sokets de tipo
 - HTTPServer
 - locales

se muestran mediante ejemplos en los cuales puede hacer la solcitud mediante un browser.

tambien podra realizar operaciones matematicas donde el servidor le respondera la respuesta esperada ya se:
    -seno
    -coseno
    -tangente
   
## requsites
    -java version 1.7+
    -maven installed

## Installation
 ```sh
$ git clone https://github.com/danielGomez1703/ARSW-LAB3
$ cd ARSW-LAB3
$ mvn package
```

# MANUAL
  una vez instalado el programa debe ejecutar el programa de acuerdo al servidor que desee probar primero sera el servidor y luego el cliente
 
    servidor web    java -cp target/TallerNet-1.0-SNAPSHOT.jar  co/edu/escuelaing/arsw/tallernet/sockets/HTTPServer
    servidor remoto funciones math  java -cp target/TallerNet-1.0-SNAPSHOT.jar  co/edu/escuelaing/arsw/tallernet/sockets/MathServer
    servidor remoto  basico java -cp target/TallerNet-1.0-SNAPSHOT.jar  co/edu/escuelaing/arsw/tallernet/sockets/EchoServer

  posteriormente se hara la prueba con el cliente.

    java -cp target/TallerNet-1.0-SNAPSHOT.jar  co/edu/escuelaing/arsw/tallernet/sockets/EchoClient
  

    
## Modelo
![Modelo](https://github.com/danielGomez1703/ARSW-LAB3/blob/master/resources/Umodel.JPG)

    Este modelo describe la interaccion del programa a nivel de sus componentes. en el modelo destacan **calculator** y el **LinkedList**
    el contendor es un implementacion propia de una lista en base a la implementacion LIST de java.
    CalculatorMain tiene la clase anonima de calculator, en el codigo podemos ver como se hace mediante una funcion lambda y tambien mediante una clase anonima.
    
    
#pruebas 
  
 la siguiente imagen refleja a nivel general el funcionamiento de los socket en este caso con el servidor que atiende funciones matematicas.

![pruebaM](https://github.com/danielGomez1703/ARSW-LAB3/blob/master/resources/pMath.JPG)

## Descripion

el objetivo del programa es abrir sockets para la comunicacion, esto se hace mediante un servidor y uno o mas clientes
para el caso del servidor web es el unico caso que alno ser concurrente puede atender mas de un cliente en diferentes momentos.

hay una clase que hace los procesos de envio de imagenes o de archivos html. esto para que se visualicen de forma correcta en el navegador al recibir el GET.

en cuanto a los servidores restantes hacen operaciones matematicas con los valores dados arrancando inicialmente con el coseno, si lo desea cambiar es poner el nombre de a funcion y el compilador lo interpretara como un cambio de funcion.
posteriormente en consola se evidenciara el resultado de las operaciones


## Author
    Daniel Felipe Gomez Suarez
    
## BUILT IN
   Proyecto construido en [Maven](https://maven.apache.org/)
## License
----
para consultar su licencia vaya al link 
[leer aqui](https://github.com/danielGomez1703/ARSW-Primer/blob/master/LICENSE.txt)