# Piedra, Papel o Tijera — Proyecto en Java

## Descripción general

Este proyecto implementa el juego clásico **Piedra, Papel o Tijera** utilizando el lenguaje de programación **Java** y aplicando tres patrones de diseño: **Strategy**, **Factory Method** y **Singleton**.  
El objetivo principal es demostrar la aplicación práctica de estos patrones dentro de una arquitectura orientada a objetos clara, modular y extensible.

El sistema permite jugar desde la consola o mediante una interfaz gráfica construida con **Swing**. El jugador humano se enfrenta a la computadora, la cual realiza su elección de manera aleatoria.

---

## Estructura del proyecto
```
src/
├── estrategia/
│ ├── Estrategia.java
│ ├── EstrategiaAleatoria.java
│ ├── EstrategiaConstante.java
│ └── EstrategiaHumano.java
│
├── modelo/
│ ├── Jugador.java
│ ├── JugadorFactory.java
│ └── GameManager.java
│
├── vista/
│ └── GameGUI.java
│
└── principal/
└── Main.java

```

---



---


---

## Patrones de diseño utilizados

### 1. Strategy

Define una familia de algoritmos (en este caso, estrategias de jugada) que pueden ser intercambiados dinámicamente sin modificar el código del cliente.  
Cada estrategia implementa la interfaz `Estrategia` y define su propia manera de seleccionar una jugada.

**Implementaciones:**
- `EstrategiaHumano`: permite al usuario ingresar manualmente su elección.
- `EstrategiaAleatoria`: genera una jugada aleatoria para la computadora.
- `EstrategiaConstante`: devuelve siempre la misma jugada (por ejemplo, "Piedra").

**Ubicación:** `src/estrategia/`

---

### 2. Factory Method

Encapsula la creación de objetos `Jugador` y asigna la estrategia correspondiente según el tipo solicitado.  
De esta forma, se evita el acoplamiento directo entre la creación de instancias y el código cliente.

**Clase principal:** `JugadorFactory.java`  
**Ubicación:** `src/modelo/`

---

### 3. Singleton

Asegura que solo exista una única instancia del controlador del juego (`GameManager`) durante la ejecución.  
Esta clase se encarga de coordinar las rondas y determinar los resultados.

**Clase principal:** `GameManager.java`  
**Ubicación:** `src/modelo/`

---

## Ejecución del programa

 Interfaz gráfica (Swing)
Ejecutar la clase `GameGUI.java` ubicada en `src/vista/`.  
Esta versión incluye botones para seleccionar la jugada y etiquetas que muestran los resultados de cada ronda.

---

## Requisitos del sistema

- Java JDK 8 o superior  
- IDE recomendado: **NetBeans 12** o posterior  

---

## Autores

**Kaleth Molina** — Código: 20232020096  
**Nelson Molina** — Código: 20222020121

---

## Licencia

Este proyecto fue desarrollado con fines académicos.  

