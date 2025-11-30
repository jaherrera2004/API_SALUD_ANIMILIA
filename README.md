# 🐾 Salud Animalia - API REST

Sistema de gestión de citas veterinarias desarrollado con Spring Boot 3.

## 📋 Descripción

**Salud Animalia** es una API REST diseñada para gestionar citas veterinarias, permitiendo a los usuarios registrar sus mascotas, agendar citas con veterinarios y administrar turnos disponibles. El sistema implementa autenticación JWT y un sistema de roles para controlar el acceso a las diferentes funcionalidades.

> 📖 **Documentación completa de la API disponible en [API_DOCUMENTACION.md](API_DOCUMENTACION.md)**

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| Java | 21 | Lenguaje de programación |
| Spring Boot | 3.3.5 | Framework principal |
| Spring Security | - | Seguridad y autenticación |
| Spring Data JPA | - | Persistencia de datos |
| MySQL | - | Base de datos relacional |
| JWT (jjwt) | 0.11.5 | Tokens de autenticación |
| MapStruct | 1.6.3 | Mapeo de objetos |
| Lombok | - | Reducción de código boilerplate |
| Maven | - | Gestión de dependencias |

## 📁 Estructura del Proyecto

```
src/main/java/com/SaludAnimalia/
├── config/
│   ├── app/                    # Configuración de beans
│   └── security/               # Configuración de seguridad (JWT, Security)
├── persistence/
│   ├── entity/                 # Entidades JPA
│   └── repository/             # Repositorios Spring Data
├── service/
│   ├── impl/                   # Implementación de servicios
│   ├── interfaces/             # Interfaces de servicios
│   └── strategy/               # Patrón Strategy para envío de emails
├── util/                       # Utilidades y constantes
└── web/
    ├── advice/                 # Manejo global de excepciones
    ├── controller/             # Controladores REST
    └── dto/                    # Objetos de transferencia de datos
        ├── request/            # DTOs de entrada
        └── response/           # DTOs de salida
```

## 🗄️ Modelo de Datos

### Entidades Principales

| Entidad | Descripción |
|---------|-------------|
| `Usuario` | Usuarios del sistema (clientes y veterinarios) |
| `Mascota` | Mascotas registradas por los usuarios |
| `Cita` | Citas agendadas para atención veterinaria |
| `Turno` | Horarios disponibles de los veterinarios |
| `Animal` | Catálogo de tipos de animales |
| `TipoCita` | Tipos de citas disponibles |
| `CitaEstado` | Estados posibles de una cita |
| `Rol` | Roles de usuario para control de acceso |

### Diagrama de Relaciones

```
Usuario (1) ----< (N) Mascota
Usuario (1) ----< (N) Turno (veterinarios)
Mascota (1) ----< (N) Cita
Turno (1) ---- (1) Cita
Cita (N) >---- (1) TipoCita
Cita (N) >---- (1) CitaEstado
Mascota (N) >---- (1) Animal
Usuario (N) >---- (1) Rol
```

## 🔌 Endpoints de la API

**Base URL:** `/salud-animalia/api/v1`

### 🔓 Autenticación (Públicos)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/auth` | Iniciar sesión |

### 👤 Usuarios

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| POST | `/usuarios` | Registrar nuevo usuario | Público |
| GET | `/usuarios/{id}` | Obtener usuario por ID | `usuario:obtener-id` |

### 🐕 Mascotas

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| POST | `/mascotas` | Registrar mascota | `mascota:registrar-mascota` |
| GET | `/mascotas/{id}` | Obtener mascota por ID | `mascota:obtener-id` |
| GET | `/mascotas/usuario/{idUsuario}` | Listar mascotas de un usuario | `mascota:obtener-lista-usuario` |
| DELETE | `/mascotas/{id}` | Eliminar mascota | `mascota:eliminar` |

### 📅 Citas

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| POST | `/citas` | Agendar nueva cita | `cita:agendar` |
| GET | `/citas/usuario/{idUsuario}` | Obtener citas de un usuario | `cita:obtener-citas-usuario` |
| PUT | `/citas/{idCita}/{idEstado}` | Actualizar estado de cita | `cita:actualizar-estado` |

### 🕐 Turnos

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| GET | `/turnos?fecha={fecha}` | Obtener turnos por día | `turno:obtener-por-dia` |
| GET | `/turnos/{idVeterinario}` | Obtener turnos de veterinario | `turno:obtener-veterinario` |

### 📋 Tipos de Cita

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| GET | `/tipo-citas` | Listar tipos de cita | `tipo-citas:obtener-lista` |

### 🐾 Animales

| Método | Endpoint | Descripción | Permisos |
|--------|----------|-------------|----------|
| GET | `/animales` | Listar tipos de animales | `animal:obtener-lista` |

## ⚙️ Configuración

### Requisitos Previos

- Java 21 o superior
- MySQL 8.0 o superior
- Maven 3.8+

### Variables de Configuración

Configura las siguientes propiedades en `application.properties`:

```properties
# Base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/salud_animalia?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# Configuración de correo (Gmail)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu_email@gmail.com
spring.mail.password=tu_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Crear Base de Datos

```sql
CREATE DATABASE salud_animalia;
```

## 🚀 Instalación y Ejecución

### Clonar el repositorio

```bash
git clone https://github.com/jaherrera2004/API_SALUD_ANIMILIA.git
cd API_SALUD_ANIMILIA
```

### Compilar el proyecto

```bash
# Windows
.\mvnw.cmd clean install

# Linux/Mac
./mvnw clean install
```

### Ejecutar la aplicación

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080/salud-animalia/api/v1`

## 🔐 Seguridad

El sistema implementa:

- **Autenticación JWT**: Tokens de acceso para usuarios autenticados
- **Autorización basada en permisos**: Control granular de acceso a endpoints
- **CORS configurado**: Permite peticiones desde cualquier origen
- **Sesiones Stateless**: Sin estado en el servidor

### Endpoints Públicos (Sin autenticación)

- `POST /salud-animalia/api/v1/usuarios` - Registro de usuarios
- `POST /salud-animalia/api/v1/auth` - Inicio de sesión
- `POST /salud-animalia/api/v1/mascotas` - Registro de mascotas

## 📧 Sistema de Notificaciones

El sistema incluye un servicio de envío de correos electrónicos con diferentes plantillas:

- **Registro**: Notificación de bienvenida al registrarse
- **Agenda**: Confirmación de cita agendada
- **Cancelación**: Notificación de cita cancelada

Implementado usando el **patrón Strategy** para flexibilidad en los tipos de correos.

## 🧪 Testing

```bash
# Ejecutar tests
.\mvnw.cmd test
```

## 📝 Características Adicionales

- ✅ Validación de datos con Bean Validation
- ✅ Manejo global de excepciones con `@ControllerAdvice`
- ✅ Mapeo automático de entidades con MapStruct
- ✅ Hot reload con Spring DevTools
- ✅ Logs de SQL detallados para debugging

## 👥 Autor

- **Juan Andres Herrera** - [jaherrera2004](https://github.com/jaherrera2004)

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

⭐ Si este proyecto te fue útil, ¡no olvides darle una estrella!
