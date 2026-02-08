# ParaBank E2E Test Automation

Automatización de pruebas E2E para el portal bancario ParaBank usando **Serenity BDD** con el patrón **Screenplay**.

## Tecnologías

- Serenity BDD 4.0.46
- Screenplay Pattern
- Cucumber (Gherkin)
- Java 17
- Gradle

## Estructura

```
e2e-serenity-parabank/
├── src/
│   ├── main/java/com/sofka/
│   │   ├── userinterfaces/   # Targets de UI
│   │   ├── tasks/            # Tareas Screenplay
│   │   ├── questions/        # Questions Screenplay
│   │   ├── models/           # Modelos de datos
│   │   └── utils/            # Utilidades
│   └── test/
│       ├── java/com/sofka/
│       │   ├── stepdefinitions/  # Step Definitions
│       │   └── runners/          # Test Runner
│       └── resources/
│           ├── features/         # Archivos .feature
│           └── serenity.conf     # Configuración
├── build.gradle
├── README.md
└── conclusiones.txt              # Hallazgos y conclusiones
```

## Requisitos

- Java 17+
- Gradle 7.x+
- Google Chrome

## Ejecución

```bash
# Clonar y entrar al proyecto
git clone git@github.com:andresgranizo/e2eparaBankSofka.git
cd e2e-serenity-parabank

# Ejecutar todos los tests
./gradlew clean test aggregate

# Ejecutar por tag
./gradlew clean test aggregate -Dcucumber.filter.tags="@login"
./gradlew clean test aggregate -Dcucumber.filter.tags="@register"
./gradlew clean test aggregate -Dcucumber.filter.tags="@withdraw"
./gradlew clean test aggregate -Dcucumber.filter.tags="@transfer"

# Modo headless (sin abrir navegador)
./gradlew clean test aggregate -Dheadless.mode=true
```

## Reportes y Resultados

Después de ejecutar los tests, los reportes se generan en:

| Tipo | Ubicación |
|------|-----------|
| Reporte Serenity HTML | `target/site/serenity/index.html` |
| Reporte Cucumber | `target/cucumber-reports/` |
| Screenshots | `target/site/serenity/` |

## Casos de Prueba

| Feature | Escenarios |
|---------|------------|
| `register.feature` | Registro exitoso, Registro fallido |
| `login.feature` | Login exitoso, Login fallido |
| `withdraw.feature` | Pago de factura exitoso |
| `transfer.feature` | Transferencia entre cuentas |

## Documentación

| Archivo | Descripción |
|---------|-------------|
| `README.md` | Instrucciones de ejecución |
| `conclusiones.txt` | Hallazgos y conclusiones del ejercicio |

## Aplicación Bajo Prueba

- **URL**: https://parabank.parasoft.com/parabank/
- **Tipo**: Portal bancario demo de Parasoft

## Autor

Andrés Granizo
