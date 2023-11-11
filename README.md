# BACK DEL PROYECTO LAT

¡Bienvenido al Backend de la aplicación 'LAT', totalmente en Spring! 
Una plataforma web que conecta profesores particulares con usuarios que buscan aprender.

## Características

### Registro de Usuarios

La aplicación permite a los usuarios registrarse proporcionando su nombre de usuario, rol, correo electrónico y contraseña. Estos datos se guardan para su almacenamiento seguro en la base de datos, si la bbdd no existe la crea.

### Inicio de Sesión de Usuarios

Los usuarios pueden iniciar sesión en el front utilizando su nombre de usuario y contraseña. El frontend envía la información de inicio de sesión al backend, que verifica las credenciales y emite un JWT válido en caso de éxito que se guardará en localStorage.

### Spring Security en el Backend

La aplicación utiliza Spring Security en el backend para reforzar la seguridad y gestionar la autenticación y autorización de los usuarios. Spring Security proporciona una capa robusta de protección para las API y recursos, garantizando un acceso seguro a los datos y funcionalidades del servidor.

---

**Nota**: Asegúrate de tener el entorno de desarrollo de Angular configurado correctamente para poder utilizar la aplicación correctamente.

## Configuración de la Base de Datos

La aplicación utiliza una base de datos MySQL para almacenar la información. Asegúrate de seguir estos pasos para configurar la conexión con la base de datos:

1. **Configuración en el Archivo application.properties:**
   - Abre el archivo `src/main/resources/application.properties` en tu proyecto.
   - Verifica que las propiedades de la base de datos estén configuradas correctamente:

2.   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/proyecto_lat?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=usuario
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   
## Instalación
1. Debes levantar el backend de la anterior aplicación
2. Clona el repositorio desde tu IDE (En mi caso uso IntelliJ): `git clone https://github.com/Obi-V/ProyectoLAT`
3. El JDK puede dar problemas, yo utilizo el 'Oracle OpenJDK version 20.0.1' porque el 21 daba fallos
4. Ejecutar la aplicación mediante el método main 'LatApplication' en la carpeta **\ProyectoLAT\src\main\java\org\lat\LatApplication.java
5. Tu back ya está ejecutándose y listo para conectarse con el front

## Uso

1. Regístrate como profesor o estudiante.
2. Explora la lista de profesores o publica tus habilidades como profesor.
3. Inicia sesión y comunícate con otros usuarios mediante la función de mensajería interna.
4. Asiste a clases en directo dentro de la plataforma.
5. Deja calificaciones y reseñas después de cada interacción.

