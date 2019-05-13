# ActivosApp
Proyecto para el manejo de activos fijos de una organización.

El proyecto está desarrollado bajo Java con `Spring boot` y `JPA`, `MySQL` y `JWT`.
Los logs de la aplicación están generados en el directorio /logs.

El desarrollo del aplicativo se hizo bajo la estructura de `Gitflow Workflow`, utilizando una rama extra entre master y develop para pruebas funcionales.
<p align="center">
  <img width="460" height="300" src="https://wac-cdn.atlassian.com/dam/jcr:b5259cce-6245-49f2-b89b-9871f9ee3fa4/03%20(2).svg?cdnVersion=331">
</p>

## Configuración
El motor de base de datos es MySQL(Version: 8.0.16), gestionado mediante MySQL Workbench 8. Es necesario crear un esquema en local con la siguiente información:
* Nombre del esquema: activosapp
* Usuario: root
* Host: localhost
* Port: 3306
* Contraseña: Frontier7865

El aplicativo trae por defecto inserts para pruebas del funcionamiento de los servicios, dichas inserciones se encuentran en el archivo: 
> imports.sql

## Compilación
Se debe contar con el gestor de dependencias Maven instalado previamente ([Instalar Maven](http://maven.apache.org/download.cgi)) y ejecutar la siguiente línea desde la raíz del proyecto en la consola de comandos:
> mvn clean install

## Despliegue

Desde la ubicación donde se encuentra el .jar generado en el paso anterior ejecute desde la consola de comandos la siguiente línea:
> java -jar .\target\activos_fijos-0.0.1-SNAPSHOT.jar

Es indispensable que se tenga configurado el jdk para Maven, de lo contrario lanzará el siguiente error: `No compiler is provided in this environment.` - [Solución](http://roufid.com/no-compiler-is-provided-in-this-environment/). En caso de modificar las variables de entorno es necesario reiniciar el ordenador para que tome los cambios.

Cuando se tenga todo listo se pueden ejecutar los servicios desde Postman para revisar su funcionamiento. 

## Uso
Para poder consumir los servicios del API, primero es necesario solicitar un token a la direccion `http://localhost:8080/users/auth`, con los siguientes datos:
* Usuario: Admin
* Contraseña: Infinite
La información en detalle de como consumir los servicios se puede ver en la colección de Postman disponible en la raíz del repositorio.

## Swagger
Para visualizar la documentación del API se debe dirigir a la dirección: `http://localhost:8080/swagger-ui.html`.
