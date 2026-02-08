# E2E ParaBank - Serenity BDD

Automatizacion E2E para ParaBank (https://parabank.parasoft.com/parabank/) con Serenity BDD y patron Screenplay.

## Requisitos

- Java 17+
- Gradle
- Chrome instalado

## Correr los tests

```bash
./gradlew clean test aggregate
```

Para correr solo un feature:

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@login"
./gradlew clean test aggregate -Dcucumber.filter.tags="@register"
./gradlew clean test aggregate -Dcucumber.filter.tags="@withdraw"
./gradlew clean test aggregate -Dcucumber.filter.tags="@transfer"
```

Para correr sin que se abra el navegador (headless):

```bash
./gradlew clean test aggregate -Dheadless.mode=true
```

## Features

- **register.feature** - Registro de usuario nuevo (exitoso y fallido)
- **login.feature** - Login con credenciales validas e invalidas
- **withdraw.feature** - Pago de factura
- **transfer.feature** - Transferencia entre cuentas

## Donde ver los reportes

El reporte principal de Serenity queda en `target/site/serenity/index.html`.
Tambien se guardan screenshots de los pasos en esa misma carpeta.

## Estructura del proyecto

Use Screenplay, asi que el codigo esta separado en:
- `tasks/` - las acciones (Login, Register, TransferFunds, etc)
- `questions/` - las verificaciones
- `userinterfaces/` - los selectores de cada pagina
- `features/` - los .feature en Gherkin
