# AREP-LAB3

[![CircleCI](https://circleci.com/gh/jnicolasct/AREP-LAB-HEROKU.svg?style=svg)](https://circleci.com/gh/jnicolasct/AREP-LAB3)

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://server-arep.herokuapp.com/)

## Insatalacion y compilacion

Para instalar el programa se debe clonar el proyecto con el comando git clone URL del proyecto o descargar el zip de este y extraer los archivos en su computador y finalamente abrirlo desde cualquier IDE

Para la compilacion, dentro del directorio del proyecto desde la cmd ejecutar el comando mvn package.

### Requisitos

  - JDK instalado
  - maven instalado
  
 
## Uso

### RETO 1

Escriba un servidor web que soporte múlltiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo páginas html e imágenes. Construya un sitio web con javascript para probar su servidor. Despliegue su solución en Heroku. NO use frameworks web como Spark o Spring use solo Java y las librerías para manejo de la red.

Para usar el programa se debe ingresar al link de heroku he hacer los siguientes request a la pagina:

Para documento html: "/prueba.html"

![prHtml](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/prHtml.PNG)

Para documento javsScript: "/prueba2.js" en este caso se debe dar click "ver autor" para ver la funcion que relaiza el archivo javaScript

![prJs](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/prJs.PNG)

Para Imagen: "/imagen.jpg" o "/imagen.png"

Prueba jpg:

![prJpg](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/prJpg.PNG)

Prueba png:

![prPng](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/prPng.PNG)

### RETO 2

Usando su  servidor y java (NO use frameworks web como Spark o Spring). Escriba un framework similar a Spark que le permita publicar servicios web "get" con funciones lambda y le permita acceder a recursoso estáticos como páginas, javascripts, imágenes, y CSSs. Cree una aplicación que conecte con una base de datos desde el servidor para probar su solución. Despliegue su solución en Heroku.

Para ver la prueba de la base de datos, se debe ingresar al link de heroku y hacer el siguiente request:

"/baseMongo"

![prMongo](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/prMongo.PNG)

## Reporte

El reporte fue generado mediante latex, su nombre es Media y Desviacion estadar. Se encuentra en la raiz del proyecto

[report](https://github.com/jnicolasct/AREP-LAB3/blob/master/src/main/resources/Web_Server.pdf)

## Autor
  Johan Nicolas Cortes Torres
