# ActivosApp
Proyecto para el manejo de activos fijos de una organización.

EL proyecto está desarrollado bajo Java con `Spring boot` y `JPA`, `MySQL` y `JWT`.
Los logs de la aplicación están generados en el directorio /logs.

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
> java -jar target\activos_fijos-0.0.1-SNAPSHOT.jar

Cuando se tenga todo listo se pueden ejecutar los servicios desde Postman para revisar su funcionamiento. 

La colección de Postman está disponible en la carpeta raíz del repositorio.
