## Integrantes	

- Laura Alejandra Izquierdo Castro
- James Alexander Torres Segura

<br></br>

## MVC Primefaces Introduction

### Parte I. - Jugando a ser un cliente HTTP

En una terminal linux o consola de windows se realiza una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:

- host: www.escuelaing.edu.co
- puerto: 80 

Usando telnet realizamos la conexión de la siguiente forma:

```	

telnet <host> <puerto>	
	
telnet www.escuelaing.edu.co 80

```

#### GET
Realizando una petición GET. Con esto, solicitamos al servidor el recurso ‘sssss/abc.html’, usando la versión 1.0 de HTTP.
		

```	
GET /sssss/abc.html HTTP/1.1
Host: www.escuelaing.edu.co

```

*Resultado*

![](resources/error1.png)

```	
301 Moved Permanently
Esta y todas las solicitudes futuras deben dirigirse al URI dado

```	
Una *URI* es una cadena de caracteres que identifica inequívocamente un recurso particular.

#### Otros códigos de error

![](resources/tabla.png)

Realizando una nueva conexión con telnet, esta vez a:

- Host: www.httpbin.org
- Puerto: 80
- Versión HTTP: 1.1

```
telnet www.httpbin.org 80

```

Ahora, solicitamos (GET) el recurso /html.

```
GET /html HTTP/1.1 
Host: www.httpbin.org

```

Ahora Contamos las palabras del archivo con el contenido HTML.

*Resultado*

![](resources/palabras.png)

#### ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?

La diferencia entre los métodos get y post radica en la forma de enviar los datos a la página cuando se pulsa el botón “Enviar”. Mientras que el método GET envía los datos usando la URL, el método POST los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario).


#### Otros tipos de particiones

- **HEAD:** Pide una respuesta idéntica a la que correspondería a una petición GET, pero en la respuesta no se devuelve el cuerpo. Esto es útil para poder recuperar los metadatos de los encabezados de respuesta, sin tener que transportar todo el contenido.
- **PUT:** Envía datos al servidor, pero a diferencia del método POST la URI de la línea de petición no hace referencia al recurso que los procesará, sino que identifica al los propios datos. mientras que POST está orientado a la creación de nuevos contenidos, PUT está más orientado a la actualización de los mismos (aunque también podría crearlos)
- **DELETE:** Borra el recurso especificado.
- **TRACE:** Este método solicita al servidor que introduzca en la respuesta todos los datos que reciba en el mensaje de petición. Se utiliza con fines de depuración y diagnóstico ya que el cliente puede ver lo que llega al servidor y de esta forma ver todo lo que añaden al mensaje los servidores intermedios
- **OPTIONS:** Devuelve los métodos HTTP que el servidor soporta para un URL específico. Esto puede ser utilizado para comprobar la funcionalidad de un servidor web mediante petición en lugar de un recurso específico.
- **CONNECT:** Se utiliza para saber si se tiene acceso a un host, no necesariamente la petición llega al servidor, este método se utiliza principalmente para saber si un proxy nos da acceso a un host bajo condiciones especiales, como por ejemplo "corrientes" de datos bidireccionales encriptadas (como lo requiere SSL).

#### CURL

Se usa en líneas de comando o scripts para transferir datos. También se utiliza en automóviles, televisores, enrutadores, impresoras, equipos de audio, teléfonos móviles, tabletas, decodificadores, reproductores multimedia y es la columna vertebral de transferencia de Internet para miles de aplicaciones de software que afectan a miles de millones de seres humanos a diario.

```

curl options URLs

```

#### CURL -v

Hace que los curl sean prolijos durante la operación. Útil para depurar y ver lo que está pasando "bajo el capó". 
- Una línea que comienza con '>' significa "datos de encabezado" enviados por curl
- '<' significa "datos de encabezado" recibidos por curl que están ocultos en casos normales
- una línea que comienza con '*' significa información adicional proporcionada por curl.

Si solo desea encabezados HTTP en la salida, -i, --include podría ser la opción que está buscando.

*Resultado*

![](resources/error3.png)

#### CURL -i

Incluye los encabezados de respuesta HTTP en la salida. Los encabezados de respuesta HTTP pueden incluir cosas como el nombre del servidor, cookies, fecha del documento, versión HTTP y más.

Para ver los encabezados de la solicitud, considere la opción -v, --verbose.

*Resultado*

![](resources/error4.png)


### Parte II. - Haciendo una aplicación Web dinámica a bajo nivel

Abrimos el navegador, y en la barra de direcciones ponemos la URL con la cual se le enviarán peticiones al ‘SampleServlet’.

http://localhost:8080/helloServlet?name=luis

### Parte III.

### Punto 20
Abrimos el navegador, y en la barra de direcciones ingresamos: **http://localhost:8080/index.html**

![](resources/index.png)

Cambiando el formulario para que ahora en lugar de POST, use el método GET . Observamos que

### POST
![](resources/POST.png)
### GET
![](resources/GET.png)

Cuando el usuario ingresa información en un formulario y hace clic en Enviar, hay dos formas en que la información se puede enviar desde el navegador al servidor: en la URL o en el cuerpo de la solicitud HTTP.

### DIFERENCIAS
La diferencia radica en la forma en que cada método envía los datos. **GET** envía los datos usando la URL, indicando el id ingresado, mientras que **POST** los envía de forma que no podemos verlos, ocultos al usuario.


### EL MEJOR USO PARA CADA UNO

- **GET** cuando desee recuperar datos (OBTENER DATOS).
- **POST** cuando desee enviar datos (POST DATA).


Las solicitudes **GET**:
- Pueden almacenarse en caché
- Permanecen en el historial del navegador
- Se pueden marcar
- Nunca se deben usar cuando se trata de datos confidenciales
- Tienen restricciones de longitud
- Deben usarse solo para recuperar datos


Las solicitudes **POST**:
- Nunca se almacenan en caché
- No permanecen en el historial del navegador
- No pueden ser marcadas
- No tienen restricciones en la longitud de los datos


## REFERENCIAS

- https://tools.ietf.org/html/rfc2616#page-36
- https://en.wikipedia.org/wiki/Uniform_Resource_Identifier
- https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
- https://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=527:get-y-post-html-method-formas-de-envio-de-datos-en-formulario-diferencias-y-ventajas-ejemplos-cu00721b&catid=69&Itemid=192#:~:text=La%20diferencia%20entre%20los%20métodos,%22ocultos%22%20al%20usuario
- https://curl.haxx.se/
- https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
- https://tools.ietf.org/html/rfc2616
- https://www.dokry.com/1270
