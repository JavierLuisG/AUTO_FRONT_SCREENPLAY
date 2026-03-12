# AUTO_FRONT_SCREENPLAY: Automatización SofkianOS

## 📋 Índice
1. [Descripción del Proyecto](#-descripción-del-proyecto)
2. [Propuesta de Valor](#-propuesta-de-valor)
3. [Flujo E2E Automatizado](#-flujo-e2e-automatizado)
4. [Tecnologías y Stack](#-tecnologías-y-stack)
5. [Arquitectura y Patrones (Screenplay)](#-arquitectura-y-patrones-screenplay)
6. [Estructura del Proyecto](#-estructura-del-proyecto)
7. [Requisitos Previos](#-requisitos-previos)
8. [Manual de Instalación y Ejecución](#-manual-de-instalación-y-ejecución)
9. [Reportes](#-reportes)
10. [Equipo Original de Desarrollo](#-equipo-original-de-desarrollo)

---

## 🚀 Descripción del Proyecto
Este repositorio contiene la automatización de pruebas **Front-End E2E** para la aplicación **SofkianOS**, migrando la lógica del modelo tradicional (POM) al patrón **Screenplay** para lograr una mayor escalabilidad y robustez.

> **Sofkian** (nuestra esencia) + **OS** (Sistema Operativo de Kudos) = **Cultura de Recompensa**.

El sistema transforma la identidad Sofkiana en **Kudos** tangibles (honor, reconocimiento y prestigio), celebrando los aportes reales de cada persona en equipos distribuidos.

## 💎 Propuesta de Valor
*   **Reconocimiento Instantáneo:** Envío inmediato de Kudos sin esperas visibles.
*   **No Bloqueante:** Arquitectura asíncrona con RabbitMQ que procesa miles de reconocimientos.
*   **Gamificación Justa:** Categorías con puntos y trazabilidad completa.

## 🔄 Flujo E2E Automatizado
La automatización valida el camino crítico del usuario mediante el patrón del **Actor**:
1.  **Acceso:** El Actor ingresa a la plataforma y navega al formulario.
2.  **Creación:** Registro de un nuevo reconocimiento (Remitente, Destinatario, Categoría, Mensaje).
3.  **Envío Especial:** Ejecución de la acción de envío mediante el **óvalo deslizante** (interacción personalizada).
4.  **Verificación:** El Actor valida que el Kudo sea visible y persistente en el muro.

## 🛠️ Tecnologías y Stack
### Automatización (QA)
*   **Lenguaje:** Java 17+.
*   **Framework de Automatización:** Serenity BDD.
*   **Test Runner:** Cucumber.
*   **Gestión de Dependencias:** Gradle.
*   **Patrón:** Screenplay.

### Sistema bajo Prueba - SofkianOS
*   **Frontend:** React + Vite.
*   **Backend:** Spring Boot (Java 17).
*   **Mensajería:** RabbitMQ.
*   **Infraestructura:** Docker (Multi-stage).

## 🏗️ Arquitectura y Patrones (Screenplay)
Siguiendo las pautas del reto, se implementan los componentes centrales de Screenplay:
*   **Actor:** Protagonista de la prueba que "tiene" capacidades y "realiza" tareas.
*   **Tasks (Tareas):** Unidades de negocio de alto nivel que cumplen con el **Principio de Responsabilidad Única**.
*   **Hooks (Acciones):** Interacciones directas con la UI (ej. abrir navegador).
*   **Questions (Preguntas):** Componentes para verificar el estado de la aplicación y realizar aserciones.
*   **UI (Targets):** Mapeo de elementos de la interfaz desacoplados de la lógica.

## 📂 Estructura del Proyecto
Siguiendo una organización limpia y modular:
```text
src/test
└── java
    └── com.sofkianos
        ├── interactions    <-- Acciones personalizadas (ej. Deslizar Óvalo)
        ├── hooks           <-- Preparar el escenario (abrir navegador)
        ├── questions       <-- Verificaciones de la UI (Aserciones)
        ├── runners         <-- Ejecutores de Cucumber
        ├── stepdefinitions <-- Mapeo de Gherkin al Actor
        ├── tasks           <-- Tareas de negocio (Responsabilidad única)
        ├── ui              <-- Mapeo de elementos (Targets)
        └── util            <-- Utilidades comunes (ej. Configuración de Actor)
└── resources
    ├── features            <-- Escenarios declarativos en Gherkin
    ├── logback-test.xml    <-- Configuración de logging para Serenity
    └── serenity.conf       <-- Configuración del Driver y Navegador
```

## 📋 Requisitos Previos
Para ejecutar este proyecto, necesitas tener instalado:

1.  **Java JDK 17 o superior**.
2.  **Docker & Docker Compose** (para levantar la aplicación SofkianOS).
3.  **Git** (para clonar los repositorios).

## ⚙️ Manual de Instalación y Ejecución

### 1. Levantar el Sistema (SofkianOS)
Para que las pruebas tengan éxito, primero debes iniciar el ambiente local de la aplicación:
```bash
git clone https://github.com/ElyRiven/sofkianos-mvp.git

# Se recomienda descargar el archivo comprimido del proyecto o clonar el repo original
docker compose up --build
```
*   **Frontend Cliente:** `http://localhost:5173`.

### 2. Ejecutar la Automatización
Una vez que el entorno esté activo, clona este repositorio de pruebas y ejecuta:
```bash
# Clonar repositorio de automatización
git clone https://github.com/tu-usuario/AUTO_FRONT_SCREENPLAY.git

# Ejecutar pruebas y generar reporte
gradle clean test aggregate
```

## 📊 Reportes
Serenity BDD genera una narrativa visual de las acciones del Actor en:
`target/site/serenity/index.html`

---
## 👥 Equipo Original de Desarrollo
Validación del sistema construido por:
> Christopher Pallo, Elian Condor, Leonel, Jean Pierre Villacis, Hans Ortiz.