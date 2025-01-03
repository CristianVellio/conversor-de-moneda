<H1 align="center"> Conversor de Moneda 🟡 </H1>

El **Conversor de Moneda** es una aplicación diseñada para realizar conversiones de divisas de manera sencilla y eficiente. El proyecto permite convertir entre diferentes monedas utilizando datos actualizados proporcionados por una API de terceros. Esta herramienta no solo es útil para cálculos rápidos, sino también para aprender buenas prácticas de programación en Java, como la modularidad, el manejo de excepciones y la integración con APIs externas.

---

<H2 align="center"> Descripción del Proyecto <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40"/> </H2>

El proyecto está construido sobre una arquitectura modular y robusta en Java. Cada componente del sistema tiene un propósito específico y está diseñado para facilitar la comprensión y el mantenimiento del código.

1. **Principal**: Es la clase principal del programa que actúa como punto de entrada. Proporciona un menú interactivo para que los usuarios seleccionen el tipo de conversión deseada, maneja las excepciones y orquesta las interacciones entre las demás clases.

2. **Consulta**: Esta clase es responsable de interactuar con la API de conversión de divisas. Envía solicitudes HTTP y procesa las respuestas en formato JSON para obtener las tasas de cambio actualizadas.

3. **Conversion**: Encargada de realizar las conversiones entre monedas. Gestiona los datos obtenidos de la API y realiza las operaciones basadas en las entradas del usuario. También encapsula métodos que permiten calcular valores finales y manejar conversiones específicas.

4. **Historial**: Gestiona el almacenamiento y consulta de registros de las conversiones realizadas. Esto se logra mediante la creación y manipulación de un archivo JSON que sirve como bitácora del historial de operaciones.

---

<H2 align="center"> API Utilizada <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" width="40" height="40"/> </H2>

El Conversor de Moneda utiliza una API de terceros para obtener tasas de cambio precisas y actualizadas. Esto garantiza la fiabilidad de las conversiones y permite mantener la aplicación alineada con las fluctuaciones del mercado en tiempo real.

Características principales de la API:
- Soporte para múltiples monedas.
- Respuestas en formato JSON.
- Actualizaciones periódicas de las tasas de cambio.

El acceso a la API está gestionado mediante claves almacenadas de forma segura en variables de entorno utilizando la biblioteca **dotenv**. Esto asegura que las credenciales no se expongan innecesariamente en el código fuente. Además, se recomienda el uso de herramientas como **Postman** para probar y verificar las solicitudes a la API durante el desarrollo y depuración.

---

<H2 align="center"> Stack Tecnologico y Dependencias Utilizadas <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" width="40" height="40"/> </H2>

El proyecto emplea las siguientes dependencias para garantizar su funcionalidad:

- **Java**: Lenguaje principal para el desarrollo de la lógica del programa.
- **Gson**: Biblioteca para la manipulación de datos en formato JSON.
- **HTTPClient**: Utilizado para realizar las solicitudes a la API externa.
- **dotenv**: Usada para gestionar variables de entorno y proteger información sensible como claves de API.
- **Java I/O**: Manejo de archivos para registrar el historial de conversiones.

---

<H2 align="center"> Lógica de Programación 💻 </H2>

El programa sigue principios fundamentales de programación estructurada y orientada a objetos. Algunas características clave incluyen:

- **Modularidad**: Cada clase tiene una responsabilidad única, facilitando la legibilidad y el mantenimiento.
- **Manejo de Excepciones**: Se implementan bloques try-catch para manejar errores comunes como entradas no válidas o problemas de conexión con la API.
- **Interactividad**: Un menú interactivo basado en la consola permite al usuario seleccionar opciones de manera intuitiva.
- **Persistencia**: Las operaciones realizadas se registran en un archivo JSON, lo que permite consultar el historial de conversiones.

---
