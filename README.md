# Kevin_Semana_8

## Descripción del proyecto
Este proyecto es parte de la evaluación de la semana 8. Es una aplicación Android que muestra un mapa de Google Maps con la localización del usuario y funcionalidades adicionales como captura de imágenes usando hilos y sensores.

## Funcionalidad principal
- Visualización en tiempo real de la ubicación exacta del usuario
- Marcar ubicaciones en el mapa manteniendo pulsado un botón en el lugar deseado
- Capturar y descargar imágenes en un activity usando hilos y sensores extras (threads)

## Cómo ejecutar la aplicación

1. Clona este repositorio. En otras palabras, descarga el proyecto en ZIP desde GitHub, extráelo y ábrelo en Android Studio.
2. Abre el proyecto en Android Studio.
3. Configura tu clave API de Google Maps en el archivo correspondiente (API 26).
4. Espera a que el proyecto se indexe.
5. Conecta un dispositivo Android o configura un emulador.
6. Haz clic en el botón "Run" en Android Studio para compilar y lanzar la app.
7. Aparecerá la pantalla de `activity_main.xml` con dos botones: uno para Google Maps y otro para Hilos.
8. Selecciona el botón de Google Maps para ver tu ubicación y agregar marcadores.

## Implementación
- Se implementaron dos dependencias: una para Maps y otra para Location, con sus versiones correspondientes.
- Se utilizó una API Key válida desde Google Console.
- Se implementó `ViewMap` para visualizar el mapa.
- Se otorgaron permisos necesarios como acceso a Internet.

## Instalación en el dispositivo Android
Para instalar la app en tu celular Android:

1. Ve a "Build" > "Generate App Bundles or APKs"
2. Selecciona "Generate APKs"
3. Espera a que el proceso de Gradle finalice
4. Haz clic en "Locate" cuando aparezca el mensaje de éxito
5. Se abrirá una carpeta con el archivo `app-debug.apk`
6. Puedes enviar ese archivo por WhatsApp y luego instalarlo en tu dispositivo Android.
