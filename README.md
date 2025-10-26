# Kevin_Semana_8
Este es el Readme.md de la evaluación semana 8
Es una aplicación simple para mostrar un mapa de google maps con la localización

## Funcionalidad principal
- Visualización en tiempo real de la ubicacíón exacta del usuario
- Marcar ubicaciones en el mapa manteniendo pulsado un botón en el lugar deseado.
- Capturar y Descargar imágenes en un activity usando hilos y sensores extras(threads).

## Cómo ejecutar la aplicación

1. Clona este repositorio. En simple palabras descarga mi proyecto en zip de mi respositorio, después extraer y dezplazarlo a Android Studio
2. Abre el proyecto en Android Studio.
3. Configura tu clave API de Google Maps en el archivo correspondiente. En este caso API 26
4. Esperamos que se importe el proyecto y lo de index. 
5. Conecta un dispositivo Android o configura un emulador.
6. Haz clic en el botón "Run" (Ejecutar) en Android Studio para compilar y lanzar la app.
7. Ahora aparecera la pantalla de activity_main.xml con las opciones de 2 botones que serían uno de Google Maps y Otro de Hilos.
8. Seleccionar el botón de Google Maps para ver tu ubicación y puedes agregar marcadores en diferentes sitios.

## Implemetanción
Implementamos 2 dependecias una de maps y otra de location con sus versiones correspondientes.
Utilizamos una api key valida de google console.
Implementamos ViewMap que sin ella no podriamos ver el mapa.
Damos permisos necesarios como el permiso de Internet, etc.


## Instalación en el dispositivo android
Si quiere descargar mi aplicación en su celular, primero debe ir a "Build", después a "Generate App Bundles or APKs" y cuando ya estemos ahí le damos a "Generate APKs"
Al momento de darle clic, estará activado el modo: Gradle build running, debe esperar unos minutos, 
hasta que le aparezca el siguiente mensaje: Generate APKs Build completed successfully for 1 module.....
saldrán 2 palabras de color azul, debe darle clic a "locate" ya cuando se le ha dado clic se abrira una carpeta.
En donde se encontrará un archivo con este nombre preterminado: app-debug.apk
En ese instante puede dezpalzar ese archivo, por ejemplo a su WhatsAppm y instala finalmente la aplicación.
Por supuesto que su celular debe ser Android.
