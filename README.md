# Pagos-Asincronos
![Esquema aplicacion](Esquema.png)

![Esquema BD](BDPagosAsincronos.jpg)

Version Java 11

Spring Boot con maven -> 2.7.16

Elastic -> 7.17.14

RabbitMQ -> 3.8.2

Comentario en linea 42 UserService para que no use elastic

DIRECCION SPRINGBOOT

	- Conexion -> /ws-endpoint
	
	- Login -> /users/login
	
	- Registrar -> ../users/newUser 
	
	- Listar transferencias -> ../listTransfer
	
	- Crear transferencia -> /app/createdTransfer , canal /topic/newTransfer


