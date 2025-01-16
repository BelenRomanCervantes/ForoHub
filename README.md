<h1> ForoHub </h1>
Aplicación de backend basada en el tercer challenge de Oracle Next Education (ONE).  
Esta aplicación se centra en la creación de un foro.  
Un foro es un lugar donde todos los participantes de una plataforma
pueden colocar sus preguntas sobre determinados asuntos. 

## 🛠️ Funcionalidades.

* Crear un nuevo tópico [POST]  
* Mostrar todos los tópicos creados [GET]  
* Mostrar un tópico específico [GET BY ID]  
* Actualizar un tópico [PUT]  
* Eliminar un tópico [DELETE]  
* Autenticación/autorización para restringir el acceso a la información [JWT]  

## 📋 Tecnologías utilizadas.
- [ ] Java 21
- [ ] Spring Boot
- [ ] MySQL
- [ ] MySQL Workbench
- [ ] Spring Security
- [ ] JWT

## 🚀 ¿Cómo usarlo?
1. Clonar este repositorio `https://github.com/BelenRomanCervantes/ForoHub.git`.
2. Crear la base de datos en MySQL:
    * Usando MySQL Workbench, crear una base de datos de nombre `foro` o algo similar.
    * Configurar el archivo application.properties del proyecto según tus credenciales de MySQL:
    ```
    spring.application.name=ForoHub
    spring.datasource.url=jdbc:mysql://${DB_HOST}/foro
    spring.datasource.username=${MYSQL_USER}
    spring.datasource.password=${MYSQL_PASSWORD}
    hibernate.dialect=org.hibernate.dialect.HSQLDialect
   
    spring.jpa.hibernate.ddl-auto=update
   
    api.security.secret=${JWT_SECRET:123456}
    ```
3. Configurar las variables de entorno en tu computadora
   ```
   DB_HOST: <TU_HOST>
   MYSQL_USER: <TU_USUARIO_DE_MYSQL>
   MYSQL_PASSWORD: <TU_PASSWORD_DE_MYSQL>
   JWT_SECRET: <TU_SECRET>
   ```
4. Ejecutar la aplicación.
   `./mvnw spring-boot:run`
5. Utiliza Postman o Insomnia para probar la publicación.

## 👩 Desarrollado por:
[Belén Itzel Román Cervantes](https://github.com/BelenRomanCervantes)   

## ✉️ Contacto 
[Linkedin](https://www.linkedin.com/in/belen-roman-cervantes/)   
[Instagram](https://www.instagram.com/belenitzelroman/)
   
   


