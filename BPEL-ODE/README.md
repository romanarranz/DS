Orquestacion de Procesos de Negocio
===================================

## Instalación

Para realizar este ejercicio contamos con los siguientes requisitos:

- Eclipse Java EE
- Plugin de BPEL para Eclipse
- Apache Tomcat7
- Apache ODE

### Configuracion de las variables de entorno Java

Necesitaremos como minimo tener configurada la variable de entorno JAVA_HOME.

Como el despliegue se ha realizado en Windows 10 para configurar dicha variable se ha hecho lo siguiente:

1. Nos dirigimos a **Mi PC -> Propiedades -> Configuracion avanzada del sistema -> Variables de Entorno**.
2. Ahora en el cuadro de **Variables del sistema** introducimos un nueva variable pulsando *Nueva...*.
3. **Nombre: JAVA_HOME**
4. **Valor: C:\Program Files\Java\jdk1.8.0_73**.
5. Incluimos en la variable PATH la siguiente entrada al final de la misma **%JAVA_HOME%/bin**.

### Plugin BPEL

Para instalar el plugin BPEL lo instalaremos directamente desde la web que ofrece eclipse.

Para ello en el propio Eclipse nos dirigimos a **Help -> Install New Software ...** y en *Work with:* introducimos la siguiente URL:

`http://download.eclipse.org/bpel/site/1.0.4`

Seleccionamos todos los paquetes que vamos a instalar y le damos a **Finish**.

Para comprobar que lo hemos instalado bien podemos hacer lo siguiente:

**File -> New -> Other... -> BPEL 2.0** si visualizamos esta entrada nos aseguramos de que está bien instalado.

### Tomcat 7

Para instalar tomcat lo descargamos directamente de su página oficial en este link: [Tomcat](http://tomcat.apache.org/download-70.cgi).

El link de descarga del zip se deja aqui: [Descarga](http://ftp.cixug.es/apache/tomcat/tomcat-7/v7.0.68/bin/apache-tomcat-7.0.68.zip)

Una vez lo hemos descargado lo movemos a C:/ y le cambiamos el nombre de la carpeta a `apache`, de manera que tendremos lo siguiente:

```bash
C:/apache/apache-tomcat-7.0.68
```

### Apache ODE

- Descargamos ODE de su página web: [ODE](http://ode.apache.org/getting-ode.html)
- Elegimos la opcion de WAR, se deja el enlace de descarga aqui: [ODE-WAR](http://www.apache.org/dyn/closer.cgi/ode/apache-ode-war-1.3.6.zip).

Ahora tenemos que extraer este .zip y mover el archivo `ode.war` a `C:/apache/apache-tomcat-7.0.68/webapps`.

Una vez hecho esto tenemos que desplegar el WAR, para ello haremos uso de `Catalina` que es el servicio de tomcat para lanzar los recursos que se ofrecen en webapps.

```bash
c:\\apache\\apache-tomcat-7.0.68\\bin>catalina run
```

Se nos habrá desplegado el war en una carpeta llamada ode alojada en el directorio `webapps`.

### Cambiamos la vista de Eclipse a BPEL

Esta tarea se realiza en **Window -> Perspective -> Open perspective -> Other... -> BPEL**.

### Definimos un nuevo servidor de ODE

Para ello en la parte de abajo del IDE tenemos una sección de **Servers**, haciendo clic derecho -> New -> Server se nos abrirá un asistente.

**New Server parametros**

- Apache -> Ode v1.x Server
- Server's hostname: localhost
- Server name : Ode v1.x Server at localhost
- Server runtime environment : Apache Ode 1.x Runtime

Ahora simplemente inicializamos el servidor ODE que acabamos de configurar.

#### NOTA

Si no nos apareciera el runtime ya por defecto tendremos que configurarlo. Para ello nos dirigimos a **Window -> Preferences -> Server -> Runtime Environment -> Add...**.

Y lo añadimos con los siguientes parametros:

- JRE: Default JRE
- ODE's home directory: C:/apache/apache-tomcat-7.0.68/webapps/ode
- Tomcat's home directory: C:/apache/apache-tomcat-7.0.68
- Server address: localhost
- Port: 8080
- VM arguments: -Xms128m -Xmx512m -XX:MaxPermSize=256m

#### IMPORTANTE

Tenemos que tener el tomcat apagado cuando queramos iniciar el servidor desde eclipse.

Como antes inicializamos `Catalina` debemos de apagar el servicio con un simple `Ctrl + C`.

### Creando un proyecto BPEL

Nos dirigimos a **File -> New -> Other... -> BPEL 2.0 -> BPEL Project**.

Se abrirá un asistente en el que nos preguntará el nombre del proyecto etc...
- Nombre: `HelloWorld`.
- Project Contens: Use Default
- Target Runtime: Apache Ode 1.x Runtime
- Configurations: Default Configuration for Apache Ode 1.x Runtime

Y le damos a **Finish**.

Ahora tenemos que crear el nuevo proceso `HelloWorld` en **File -> New -> Other... -> BPEL 2.0 -> BPEL Process**.

- Creation Mode: Create a BPEL process from a template.
- Process Name: HelloWorld
- Namespace: http://HelloWorld

Next, Next y lo alojamos este proceso en la carpeta de nuestro proyecto BPEL en `bpelcontent`.
