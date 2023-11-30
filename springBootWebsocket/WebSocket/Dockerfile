# Uso imagen base de OpenJDK para java 11
FROM openjdk:11

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR	/app

# Copia del archivo JAR generado por le mvn al contenedor
COPY target/WebSocket-0.0.1-SNAPSHOT.jar /app/WebSocket-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties /app/application.properties

# Puerto en el que el servicio va a escuchar
EXPOSE 8080

# Comando para ejecutar el sevicio al iniciar contenedor
CMD ["java", "-jar", "target/WebSocket-0.0.1-SNAPSHOT.jar"]
