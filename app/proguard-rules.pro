# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# REGLAS PARA GOOGLE MAPS Y SEGURIDAD
-keep class com.google.android.gms.** { *; }
-keep class com.google.maps.** { *; }

# Mantener clases necesarias para Google Maps
-keep public class com.google.android.gms.maps.** { public *; }
-keep public class com.google.maps.api.** { public *; }

# Mantener clases de location services
-keep class com.google.android.gms.location.** { *; }

# Ofuscar pero mantener funcionalidad de actividades
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Mantener métodos de callback de maps
-keep class * implements com.google.android.gms.maps.OnMapReadyCallback {
    public void onMapReady(com.google.android.gms.maps.GoogleMap);
}

# Preservar información para debugging (solo en desarrollo)
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
-renamesourcefileattribute SourceFile