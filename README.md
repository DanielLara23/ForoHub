# Foro Hub

Foro Hub es una aplicación web para la gestión de discusiones, permitiendo a los usuarios crear, leer, actualizar y eliminar tópicos. Utiliza Spring Boot y JWT (JSON Web Token) para garantizar un acceso seguro y eficiente a los recursos.

## Tabla de Contenidos

- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Modifica](#documentación)
- [Autenticación](#autenticación)
- [Licencia](#licencia)

## Características

- **Gestión de Tópicos:** CRUD completo para crear, listar, actualizar y eliminar tópicos.
- **Seguridad:** Autenticación y autorización mediante JWT para un acceso seguro.
- **Validaciones:** Uso de Jakarta Bean Validation para asegurar la calidad de los datos ingresados.

## Requisitos

- JDK 17 o superior
- Maven 3.8.1 o superior
- MySQL 8.0 o superior

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/foro-hub.git
   cd foro-hub

## Modifica 
    src/main/resources/application.properties:


spring.datasource.url=jdbc:mysql://localhost/"Tu base de datos"

spring.datasource.username="Tu usuario"

spring.datasource.password="tu contraseña"

server.error.include-stacktrace=never

api.security.secret=${JWT_SECRET:123456}

## Autenticación
Envía una solicitud POST a /login con las credenciales del usuario. 
Recibirás un token JWT que debes incluir en el encabezado de autorización para todas las solicitudes.

Endpoints Principales

- POST /topicos: Crea un nuevo tópico.

- GET /topicos: Obtiene la lista de tópicos.
  
- GET /topicos/{id}: Obtiene un tópicos.

- PUT /topicos/{id}: Actualiza un tópico existente.

- DELETE /topicos/{id}: Elimina un tópico.

## Licencia

Este proyecto está bajo la Licencia MIT.
