# 📚 API Documentación - Salud Animalia

## 🌐 Información General

| Propiedad | Valor |
|-----------|-------|
| **Base URL** | `http://localhost:8080/salud-animalia/api/v1` |
| **Formato** | JSON |
| **Autenticación** | Bearer Token (JWT) |

---

## 🔐 Autenticación

Todos los endpoints protegidos requieren el header:

```
Authorization: Bearer <token>
```

---

## 📋 Endpoints

### 1. 🔑 Autenticación (`/auth`)

#### POST `/auth` - Iniciar Sesión

Autentica un usuario y devuelve un token JWT.

**🔓 Acceso:** Público

**Request Body:**

```json
{
  "username": "string",      // Obligatorio - Nombre de usuario
  "contrasenia": "string"    // Obligatorio - Contraseña
}
```

**Validaciones:**
| Campo | Validación |
|-------|------------|
| `username` | No puede estar vacío ni ser nulo |
| `contrasenia` | No puede estar vacía ni ser nula |

**Response (200 OK):**

```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "usuarioDatosResponse": {
    "id": 1,
    "cedula": "12345678",
    "email": "usuario@email.com",
    "username": "usuario123",
    "nombre": "Juan",
    "apellido": "Pérez",
    "telefono": "3001234567",
    "edad": 25,
    "rol": "CLIENTE"
  }
}
```

**Errores posibles:**
| Código | Descripción |
|--------|-------------|
| 400 | Datos de validación incorrectos |
| 401 | Credenciales inválidas |

---

### 2. 👤 Usuarios (`/usuarios`)

#### POST `/usuarios` - Registrar Usuario

Registra un nuevo usuario en el sistema.

**🔓 Acceso:** Público

**Request Body:**

```json
{
  "cedula": "string",        // Obligatorio
  "nombre": "string",        // Obligatorio
  "apellido": "string",      // Obligatorio
  "edad": 18,                // Obligatorio - Mínimo 18 años
  "telefono": "string",      // Obligatorio
  "email": "string",         // Obligatorio
  "username": "string",      // Obligatorio
  "contrasenia": "string",   // Obligatorio
  "idRol": 1                 // Obligatorio - Debe ser positivo
}
```

**Validaciones:**
| Campo | Validación |
|-------|------------|
| `cedula` | No puede estar vacío ni ser nulo |
| `nombre` | No puede estar vacío ni ser nulo |
| `apellido` | No puede estar vacío ni ser nulo |
| `edad` | Mínimo 18 años |
| `telefono` | No puede estar vacío ni ser nulo |
| `email` | No puede estar vacío ni ser nulo |
| `username` | No puede estar vacío ni ser nulo |
| `contrasenia` | No puede estar vacía ni ser nula |
| `idRol` | Debe ser un número positivo |

**Response (200 OK):**

```json
{
  "status": true,
  "message": "Te has registrado exitosamente!"
}
```

---

#### GET `/usuarios/{id}` - Obtener Usuario por ID

Obtiene la información de un usuario específico.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `usuario:obtener-id`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `id` | Integer | ID del usuario |

**Response (200 OK):**

```json
{
  "id": 1,
  "cedula": "12345678",
  "nombre": "Juan",
  "apellido": "Pérez",
  "edad": 25,
  "telefono": "3001234567",
  "email": "usuario@email.com",
  "username": "usuario123",
  "contrasenia": null,
  "rol": {
    "id": 1,
    "rol": "CLIENTE",
    "descripcion": "Usuario cliente del sistema"
  }
}
```

---

### 3. 🐕 Mascotas (`/mascotas`)

#### POST `/mascotas` - Registrar Mascota

Registra una nueva mascota en el sistema.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `mascota:registrar-mascota`

**Request Body:**

```json
{
  "id": null,                // Opcional - Para actualizaciones
  "nombre": "string",        // Obligatorio
  "raza": "string",          // Obligatorio
  "edad": 0,                 // Obligatorio - Debe ser >= 0
  "sexo": "M",               // Obligatorio - 'M' o 'F'
  "idAnimal": 1,             // Obligatorio - Debe ser positivo
  "idDuenio": 1              // Obligatorio - Debe ser positivo
}
```

**Validaciones:**
| Campo | Validación |
|-------|------------|
| `nombre` | No puede estar vacío ni ser nulo |
| `raza` | No puede estar vacía ni ser nula |
| `edad` | Debe ser cero o positivo |
| `sexo` | No puede ser nulo |
| `idAnimal` | Debe ser un número positivo |
| `idDuenio` | Debe ser un número positivo |

**Response (200 OK):**

```json
{
  "status": true,
  "message": "Firulais ha sido agregado a tu lista de mascotas!"
}
```

---

#### GET `/mascotas/{id}` - Obtener Mascota por ID

Obtiene la información de una mascota específica.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `mascota:obtener-id`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `id` | Integer | ID de la mascota |

**Response (200 OK):**

```json
{
  "id": 1,
  "nombre": "Firulais",
  "raza": "Labrador",
  "edad": 3,
  "sexo": "M",
  "duenio": {
    "id": 1,
    "cedula": "12345678",
    "nombre": "Juan",
    "apellido": "Pérez",
    "edad": 25,
    "telefono": "3001234567",
    "email": "usuario@email.com",
    "username": "usuario123",
    "contrasenia": null,
    "rol": {
      "id": 1,
      "rol": "CLIENTE",
      "descripcion": "Usuario cliente del sistema"
    }
  },
  "animal": {
    "id": 1,
    "animal": "Perro",
    "descripcion": "Canino doméstico"
  }
}
```

---

#### GET `/mascotas/usuario/{idUsuario}` - Obtener Mascotas de un Usuario

Lista todas las mascotas registradas por un usuario.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `mascota:obtener-lista-usuario`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `idUsuario` | Integer | ID del usuario dueño |

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "nombre": "Firulais",
    "raza": "Labrador",
    "edad": 3,
    "sexo": "M",
    "duenio": { ... },
    "animal": { ... }
  },
  {
    "id": 2,
    "nombre": "Michi",
    "raza": "Siamés",
    "edad": 2,
    "sexo": "F",
    "duenio": { ... },
    "animal": { ... }
  }
]
```

---

#### DELETE `/mascotas/{id}` - Eliminar Mascota

Elimina una mascota del sistema.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `mascota:eliminar`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `id` | Integer | ID de la mascota a eliminar |

**Response (200 OK):**

```json
{
  "status": true,
  "message": "Has eliminado a tu mascota"
}
```

---

### 4. 📅 Citas (`/citas`)

#### POST `/citas` - Agendar Cita

Agenda una nueva cita veterinaria.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `cita:agendar`

**Request Body:**

```json
{
  "idMascota": 1,            // Obligatorio
  "idTurno": 1,              // Obligatorio
  "idTipo": 1,               // Obligatorio
  "observaciones": "string"  // Opcional
}
```

**Validaciones:**
| Campo | Validación |
|-------|------------|
| `idMascota` | No puede ser nulo |
| `idTurno` | No puede ser nulo |
| `idTipo` | No puede ser nulo |

**Response (200 OK):**

```json
{
  "status": true,
  "message": "Tu cita ha sido agendada exitosamente"
}
```

---

#### GET `/citas/usuario/{idUsuario}` - Obtener Citas de un Usuario

Lista todas las citas de las mascotas de un usuario.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `cita:obtener-citas-usuario`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `idUsuario` | Integer | ID del usuario |

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "observaciones": "Vacunación anual",
    "estado": {
      "id": 1,
      "estado": "PENDIENTE",
      "descripcion": "Cita pendiente de atención"
    },
    "turno": {
      "id": 1,
      "fechaInicio": "2025-12-01T09:00:00",
      "fechaFin": "2025-12-01T09:30:00",
      "disponible": false,
      "veterinario": {
        "id": 2,
        "nombre": "Dr. García",
        "apellido": "Rodríguez",
        ...
      }
    },
    "mascota": {
      "id": 1,
      "nombre": "Firulais",
      "raza": "Labrador",
      ...
    },
    "tipoCita": {
      "id": 1,
      "tipoCita": "Vacunación",
      "descripcion": "Aplicación de vacunas"
    }
  }
]
```

---

#### PUT `/citas/{idCita}/{idEstado}` - Actualizar Estado de Cita

Actualiza el estado de una cita existente.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `cita:actualizar-estado`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `idCita` | Integer | ID de la cita |
| `idEstado` | Integer | ID del nuevo estado |

**Response (200 OK):**

```json
{
  "status": true,
  "message": "El estado de su cita ha sido actualizado!"
}
```

---

### 5. 🕐 Turnos (`/turnos`)

#### GET `/turnos` - Obtener Turnos por Día

Lista los turnos disponibles para una fecha específica.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `turno:obtener-por-dia`

**Query Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `fecha` | LocalDate | Fecha en formato `YYYY-MM-DD` |

**Ejemplo de solicitud:**
```
GET /salud-animalia/api/v1/turnos?fecha=2025-12-01
```

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "fechaInicio": "2025-12-01T09:00:00",
    "fechaFin": "2025-12-01T09:30:00",
    "disponible": true,
    "veterinario": {
      "id": 2,
      "cedula": "87654321",
      "nombre": "Dr. García",
      "apellido": "Rodríguez",
      "edad": 35,
      "telefono": "3009876543",
      "email": "veterinario@email.com",
      "username": "drgarcia",
      "contrasenia": null,
      "rol": {
        "id": 2,
        "rol": "VETERINARIO",
        "descripcion": "Veterinario del sistema"
      }
    }
  },
  {
    "id": 2,
    "fechaInicio": "2025-12-01T09:30:00",
    "fechaFin": "2025-12-01T10:00:00",
    "disponible": true,
    "veterinario": { ... }
  }
]
```

---

#### GET `/turnos/{idVeterinario}` - Obtener Turnos de un Veterinario

Lista los turnos de un veterinario específico.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `turno:obtener-veterinario`

**Path Parameters:**
| Parámetro | Tipo | Descripción |
|-----------|------|-------------|
| `idVeterinario` | Integer | ID del veterinario |

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "fechaInicio": "2025-12-01T09:00:00",
    "fechaFin": "2025-12-01T09:30:00",
    "disponible": true,
    "veterinario": { ... }
  }
]
```

---

### 6. 📋 Tipos de Cita (`/tipo-citas`)

#### GET `/tipo-citas` - Listar Tipos de Cita

Obtiene todos los tipos de cita disponibles.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `tipo-citas:obtener-lista`

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "tipoCita": "Consulta General",
    "descripcion": "Revisión médica general"
  },
  {
    "id": 2,
    "tipoCita": "Vacunación",
    "descripcion": "Aplicación de vacunas"
  },
  {
    "id": 3,
    "tipoCita": "Cirugía",
    "descripcion": "Procedimientos quirúrgicos"
  },
  {
    "id": 4,
    "tipoCita": "Urgencia",
    "descripcion": "Atención de emergencia"
  }
]
```

---

### 7. 🐾 Animales (`/animales`)

#### GET `/animales` - Listar Tipos de Animales

Obtiene todos los tipos de animales registrados.

**🔒 Acceso:** Requiere autenticación  
**🛡️ Permiso:** `animal:obtener-lista`

**Response (200 OK):**

```json
[
  {
    "id": 1,
    "animal": "Perro",
    "descripcion": "Canino doméstico"
  },
  {
    "id": 2,
    "animal": "Gato",
    "descripcion": "Felino doméstico"
  },
  {
    "id": 3,
    "animal": "Ave",
    "descripcion": "Aves domésticas"
  },
  {
    "id": 4,
    "animal": "Reptil",
    "descripcion": "Reptiles domésticos"
  }
]
```

---

## ⚠️ Códigos de Error

### Respuestas de Error Comunes

| Código HTTP | Descripción |
|-------------|-------------|
| 400 | Bad Request - Datos de entrada inválidos |
| 401 | Unauthorized - Token inválido o expirado |
| 403 | Forbidden - Sin permisos para acceder al recurso |
| 404 | Not Found - Recurso no encontrado |
| 500 | Internal Server Error - Error interno del servidor |

### Estructura de Error de Validación

```json
{
  "status": "400",
  "message": "Error de validación",
  "errors": [
    {
      "field": "username",
      "message": "El nombre de usuario no puede estar vacío."
    },
    {
      "field": "contrasenia",
      "message": "La contraseña es obligatoria."
    }
  ]
}
```

### Estructura de Error de Autenticación

```json
{
  "status": "401",
  "message": "Sesión inválida, inicie sesión nuevamente."
}
```

---

## 🛡️ Permisos del Sistema

Lista de permisos disponibles y su funcionalidad:

| Permiso | Descripción |
|---------|-------------|
| `usuario:obtener-id` | Obtener información de usuario por ID |
| `mascota:registrar-mascota` | Registrar nuevas mascotas |
| `mascota:obtener-id` | Obtener información de mascota por ID |
| `mascota:obtener-lista-usuario` | Listar mascotas de un usuario |
| `mascota:eliminar` | Eliminar mascotas |
| `cita:agendar` | Agendar nuevas citas |
| `cita:obtener-citas-usuario` | Listar citas de un usuario |
| `cita:actualizar-estado` | Actualizar estado de citas |
| `turno:obtener-por-dia` | Consultar turnos por fecha |
| `turno:obtener-veterinario` | Consultar turnos de veterinario |
| `tipo-citas:obtener-lista` | Listar tipos de cita |
| `animal:obtener-lista` | Listar tipos de animales |

---

## 📝 Ejemplos de Uso con cURL

### Registrar Usuario

```bash
curl -X POST http://localhost:8080/salud-animalia/api/v1/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "cedula": "12345678",
    "nombre": "Juan",
    "apellido": "Pérez",
    "edad": 25,
    "telefono": "3001234567",
    "email": "juan@email.com",
    "username": "juanperez",
    "contrasenia": "password123",
    "idRol": 1
  }'
```

### Iniciar Sesión

```bash
curl -X POST http://localhost:8080/salud-animalia/api/v1/auth \
  -H "Content-Type: application/json" \
  -d '{
    "username": "juanperez",
    "contrasenia": "password123"
  }'
```

### Agendar Cita (Autenticado)

```bash
curl -X POST http://localhost:8080/salud-animalia/api/v1/citas \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <tu_token_jwt>" \
  -d '{
    "idMascota": 1,
    "idTurno": 5,
    "idTipo": 2,
    "observaciones": "Vacunación anual"
  }'
```

### Consultar Turnos Disponibles

```bash
curl -X GET "http://localhost:8080/salud-animalia/api/v1/turnos?fecha=2025-12-01" \
  -H "Authorization: Bearer <tu_token_jwt>"
```

---

## 📊 Modelos de Datos

### UsuarioDto

```json
{
  "id": "Integer",
  "cedula": "String",
  "nombre": "String",
  "apellido": "String",
  "edad": "Integer",
  "telefono": "String",
  "email": "String",
  "username": "String",
  "contrasenia": "String (null en respuestas)",
  "rol": "RolDto"
}
```

### MascotaDto

```json
{
  "id": "Integer",
  "nombre": "String",
  "raza": "String",
  "edad": "Integer",
  "sexo": "char ('M' o 'F')",
  "duenio": "UsuarioDto",
  "animal": "AnimalDto"
}
```

### CitaDto

```json
{
  "id": "Integer",
  "observaciones": "String",
  "estado": "CitaEstadoDto",
  "turno": "TurnoDto",
  "mascota": "MascotaDto",
  "tipoCita": "TipoCitaDto"
}
```

### TurnoDto

```json
{
  "id": "Integer",
  "fechaInicio": "LocalDateTime (ISO 8601)",
  "fechaFin": "LocalDateTime (ISO 8601)",
  "disponible": "boolean",
  "veterinario": "UsuarioDto"
}
```

### RolDto

```json
{
  "id": "Integer",
  "rol": "String",
  "descripcion": "String"
}
```

### AnimalDto

```json
{
  "id": "Integer",
  "animal": "String",
  "descripcion": "String"
}
```

### TipoCitaDto

```json
{
  "id": "Integer",
  "tipoCita": "String",
  "descripcion": "String"
}
```

### CitaEstadoDto

```json
{
  "id": "Integer",
  "estado": "String",
  "descripcion": "String"
}
```

---

## 🔄 Flujo de Trabajo Típico

```
1. Usuario se registra         → POST /usuarios
2. Usuario inicia sesión       → POST /auth (obtiene token)
3. Registra su mascota         → POST /mascotas
4. Consulta tipos de cita      → GET /tipo-citas
5. Consulta turnos disponibles → GET /turnos?fecha=YYYY-MM-DD
6. Agenda una cita             → POST /citas
7. Consulta sus citas          → GET /citas/usuario/{id}
```

---

**Versión de la API:** 1.0  
**Última actualización:** Noviembre 2025
