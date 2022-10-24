# Arquitectura implementada 🌇

Hablando de código... 💻
☕ Arquitectura... se implementó la arquitectura Hexagonal de la mano de DDD y MVVM, sin olvidar los principios SOLID.
implementar esta arquitectura nos permite tener desacoplada la logica de negocio de la interfaz de usuario de estar forma es mas facil de mantener y testear.
La estrategia de modularizacion implementada permite que los componentes se puedan reutilizar en otros proyectos.

✍️ Lenguaje/tecnología... todo esto fue desarrollado en kotlin.

Y la base de datos... ¿qué? ⛅ Se utilizo Room
Si abrimos por primera vez la aplicacion se consultara si hay una lista de bancos, si esta vacia se realizara la solicitud
a la api, cuando este responda montara la data en la BaseDatos para que proximas veces no tenga que consultar nuevamente la api.


* API: https://dev.obtenmas.com/catom/api/challenge/banks

# Libraries used

### Network
- Retrofit -> https://square.github.io/retrofit/
### Dependency Injection
- Hilt -> https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419
### Database
- Room -> https://developer.android.com/training/data-storage/room
### Navigation
- Navigation Compose -> https://developer.android.com/jetpack/compose/navigation?hl=es-419
### UI
- Jetpack Compose -> https://developer.android.com/?hl=es-419
- Coil Compose Image Loader -> https://coil-kt.github.io/coil/compose/
### Testing
- Mockito -> https://site.mockito.org
- Coroutines Test -> https://developer.android.com/kotlin/coroutines/test
- Compose UI Test - > https://developer.android.com/jetpack/compose/testing?hl=es-419#setup
