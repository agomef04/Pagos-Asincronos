# Pagos-Asincronos
![Esquema aplicacion](Esquema.png)


## Esquema Base de Datos
![Esquema BD](BDPagosAsincronos.jpg)


## Diagramas de secuencia

![Diagrama secuencia - Crear usuario](DiagramaSecuencia_CrearUsuario.drawio.png)



## Versiones

* Java -> 11

* Spring Boot con maven -> 2.7.16

* ElasticSearch -> 7.17.14

* RabbitMQ -> 3.8.2

* MySQL -> 8.0.35

* Angular -> 16.2.9


## Direcciones backend

* Conexion -> /ws-endpoint
	
* Login -> /users/login
	
* Registrar -> /users/newUser 
	
* Listar transferencias -> /listTransfer
	
* Crear transferencia -> /app/createdTransfer , canal /topic/newTransfer/{email}


