# 🚲 Proyecto ValenBisi - Aplicación Android

## 📌 Descripción

Este proyecto consiste en el desarrollo de una aplicación Android que permite visualizar en tiempo real la **disponibilidad de bicicletas** en los puntos de **ValenBisi**, el sistema de bicicletas públicas de la ciudad de Valencia. Utilizando los datos proporcionados por el **dataset** disponible en la plataforma **OpenDataSoft** de Valencia, la aplicación muestra información relevante sobre:

- 📍 **Dirección de la estación**
- 🚲 **Bicicletas disponibles**
- 🅿️ **Espacios libres**

Además, la aplicación incluye:

- 🗺️ Un **mapa interactivo** con la ubicación de cada estación.
- 🎨 **Colores dinámicos** según disponibilidad.
- 🔄 **Carga dinámica** del CSV con los datos en tiempo real.

---

## 🌟 Características

- ✅ **Visualización completa** de cada estación:
  - Dirección
  - Bicicletas disponibles
  - Espacios libres

- 🎨 **Colores según disponibilidad**:
  - 🟢 Verde: Alta disponibilidad
  - 🟡 Amarillo: Media disponibilidad
  - 🔴 Rojo: Baja disponibilidad

- 📱 **Diseño moderno** con **Material Design 3** para una interfaz intuitiva y responsiva.

- 🧩 **Material Icons** desde [Google Fonts](https://fonts.google.com/icons) para mejorar la experiencia visual.

- 🗺️ **Mapa interactivo** con marcadores personalizados para cada estación.

- 🔄 **Carga dinámica del CSV** desde el portal oficial de datos abiertos del Ayuntamiento de Valencia:
  [https://valencia.opendatasoft.com](https://valencia.opendatasoft.com/explore/dataset/valenbisi-disponibilitat-valenbisi-dsiponibilidad/table/)

---

## 🛠️ Tecnologías Utilizadas

- **Android Studio**: IDE principal para el desarrollo.
- **Kotlin**: Lenguaje de programación de la app.
- **Google Maps API**: Para la visualización geográfica de estaciones.
- **OpenDataSoft API**: Fuente oficial de datos de ValenBisi.
- **Material Design 3**: Framework UI moderno de Google.
- **CSV Parsing**: Para lectura y procesamiento de los datos en tiempo real.

---

## ✅ Requisitos

- Android Studio (versión recomendada: +2022.3)
- API Key de Google Maps
- Conexión a internet para cargar el CSV dinámicamente

---

## ⚙️ Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/tuusuario/valenbisi-app.git
