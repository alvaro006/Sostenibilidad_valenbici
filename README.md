🚲 Proyecto ValenBisi - Aplicación Android
Descripción

Este proyecto consiste en el desarrollo de una aplicación Android que permite visualizar en tiempo real la disponibilidad de bicicletas en los puntos de ValenBisi, el sistema de bicicletas públicas de la ciudad de Valencia. Utilizando los datos proporcionados por el dataset disponible en la plataforma OpenDataSoft de Valencia, la aplicación muestra información relevante sobre:

Dirección de la estación

Bicicletas disponibles

Espacios libres

Además, la aplicación incluye:

Un mapa interactivo que muestra la ubicación de las estaciones de ValenBisi.

Colores dinámicos para indicar la disponibilidad de bicicletas en cada estación.

Carga dinámica de los datos desde un archivo CSV para garantizar que la información esté siempre actualizada.

Características

🌍 Visualización de Disponibilidad: Muestra la dirección, las bicicletas disponibles y los espacios libres en cada estación de ValenBisi.

🎨 Colores Dinámicos: La disponibilidad se visualiza mediante colores que indican el estado de cada estación:

✅ Verde: Alta disponibilidad de bicicletas.

⚠️ Amarillo: Disponibilidad media.

❌ Rojo: Baja disponibilidad de bicicletas.

💡 Material Design 3: Implementación de las guías de diseño de Google, proporcionando una interfaz de usuario moderna, limpia y responsiva.

📱 Material Icons: Uso de iconos de Google Material para mejorar la experiencia visual e interacción.

🗺️ Mapa Interactivo: Cada estación está representada en un mapa interactivo con su ubicación geográfica exacta y su disponibilidad en tiempo real.

🔄 Carga Dinámica de Datos: La información de la disponibilidad se obtiene de un archivo CSV actualizado automáticamente desde la URL del dataset de ValenBisi.

Tecnologías Utilizadas

Android Studio: IDE principal para desarrollar la aplicación.

Kotlin: Lenguaje de programación utilizado para la lógica y la interacción de la aplicación.

Google Maps API: Para integrar un mapa interactivo donde se muestran las estaciones de ValenBisi.

OpenDataSoft API: Proporciona el acceso a los datos actualizados de la disponibilidad de las estaciones en formato CSV.

Material Design 3: Framework de diseño para una interfaz de usuario atractiva y funcional.

CSV Parsing: Utilizado para leer y procesar el archivo CSV que contiene los datos de disponibilidad.
