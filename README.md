# PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS I
Primera parte de la Práctica Final para la Aplicación para Gestionar Cultivos de Bacterias de Nerea Quintanilla Blanco

LINK -> https://github.com/nquinbla/PF_GCB_I.git

**El jar que ha solicitado se encuentra de la siguiente manera**
```
out -> artifacts -> PF_GCB_I_jar -> PF_GCB_I_jar
```

***

## ÍNDICE

- [DESCRIPCIÓN](#descripción)
- [MÓDULOS](#módulos)
  - [1. Gestor Cultivos](#1-gestor-cultivos)
  - [2. Home](#2-home)
  - [3. Inicio Sesión](#3-inicio-sesión)
- [ANÁLISIS](#análisis)
  - [Análisis y descripción de la aplicación](#análisis-y-descripción-de-la-aplicación)
  - [Listado de fallos y funcionalidades](#listado-de-fallos-y-funcionalidades)
  - [Listado código](#listado-código)
  - [Listado pruebas](#listado-pruebas)
  - [Conclusiones](#conclusiones)
- [CONSEJOS](#consejos)
- [SOBRE LA ENTREGA Y EVALUACIÓN DE LA PRÁCTICA](#sobre-la-entrega-y-evaluación-de-la-práctica)
  - [ITEMS A ENTREGAR](#items-a-entregar)
 

***

## DESCRIPCIÓN
Para realizar un conjunto de experimentos en un laboratorio de biólogos necesitan una aplicación de escritorio que les ayude a recoger la información de los experimentos. Los experimentos consisten en realizar cultivos de bacterias. En cada experimento se parte de una población de bacterias inicial. En el medio donde viven las bacterias se añade una determinada cantidad de comida. Esta cantidad de comida inicial irá incrementando linealmente durante varios días, y a continuación disminuye linealmente hasta un valor final. Todos los experimentos duran 30 días.

La aplicación deberá permitir gestionar la información relativa a las poblaciones de bacterias asociadas con un experimento. Cada experimento se guardará en un archivo diferente, y cada experimento puede estar compuesto por múltiples poblaciones de bacterias. Para cada población de bacterias, inicialmente el científico indicará: un nombre asociado a esa población, la fecha de comienzo de la población, la fecha de fin de la población, el número de bacterias iniciales, la temperatura a la cual se van a someter las bacterias, las condiciones de luminosidad ("Alta", "Media" y "Baja") y la dosis de comida. Para indicar la dosis de comida, los biólogos deben introducir la cantidad inicial de comida que se le dará el primer día, el día (de entre los 30 días que duran las poblaciones) hasta el cual se debe incrementar la cantidad de comida y la comida de este día, y la cantidad final de comida en el día 30. A partir de estos datos, la aplicación irá calculando la cantidad de comida que hay que proporcionar cada día a las bacterias. Las cantidades de comida son valores enteros menores que 300.

 La aplicación deberá permitir realizar las siguientes acciones:

 1.     Abrir un archivo que contenga un experimento

2.     Crear un nuevo experimento

3.     Crear una población de bacterias y añadirla al experimento actual

4.     Visualizar los nombres de todas las poblaciones de bacterias del experimento actual

5.     Borrar una población de bacterias del experimento actual

6.     Ver información detallada de una población de bacterias del experimento actual

7.     Guardar (se supone que para usar esta opción previamente hemos abierto un archivo)

8.     Guardar como

> Cuando el usuario seleccione la opción 6, la aplicación deberá solicitar el nombre de la población de la cual quiere ver los detalles, y a continuación deberá mostrarse toda la información detallada del experimento, inclusive la dosis de alimento que se debe dar a las bacterias cada uno de los 30 días.

Necesariamente habrá que guardar en modo texto toda la información correspondiente con cada experimento.

---------------------------------------------------------------

## MÓDULOS


### 1. Gestor Cultivos
En este paquete encontramos el código que utilizaremos a lo largo de la práctica

#### `BacteriaPopulation`
Esta clase representa una población de bacterias en un experimento. Contiene información sobre la población, como el nombre de la especie, la fecha de inicio y fin del experimento, el recuento inicial de bacterias, la temperatura, las condiciones de luz y la dosis de alimento. También tiene un método para calcular la población de bacterias para un día específico.

#### `Experiment`
 Esta clase representa un experimento que contiene varias poblaciones de bacterias. Proporciona métodos para agregar y eliminar poblaciones de bacterias, y para obtener todas las poblaciones en el experimento.

#### `ExperimentLoader`
Esta clase se utiliza para cargar un experimento desde un archivo. Lee el archivo línea por línea, crea una nueva población de bacterias para cada línea y las agrega al experimento.

#### `ExperimentSaver`
Esta clase proporciona un método estático para guardar un experimento en un archivo. El archivo resultante contendrá información sobre todas las poblaciones de bacterias en el experimento.

#### `FoodDose`
Esta clase representa la dosis de alimento que se da a una población de bacterias en un experimento. Contiene información sobre la cantidad inicial de alimento, el día en que se aumenta la cantidad de alimento, la cantidad de alimento en el día de aumento y la cantidad final de alimento.  

#### `PopulationManager`
Esta clase es un singleton que mantiene un mapa de todas las poblaciones de bacterias que se han creado. Proporciona un método para obtener este mapa.

---------------------------------------------------------------

### 2. Home

#### `ExperimentWindow`
Esta clase representa una ventana de la interfaz de usuario que permite al usuario abrir un experimento existente o crear uno nuevo.  

#### `PopulationEvolutionWindow`
Esta clase representa una ventana de la interfaz de usuario que muestra la evolución de una población de bacterias en un experimento.  

#### `PopulationWindow`
Esta clase representa una ventana de la interfaz de usuario que permite al usuario crear, visualizar y eliminar poblaciones de bacterias.  

#### `SelectPopulationWindow`
Esta clase representa una ventana de la interfaz de usuario que permite al usuario seleccionar una población de bacterias para un experimento.  

#### `SharedData`
Esta clase es un contenedor para los datos compartidos entre varias clases, como las poblaciones de bacterias.  

#### `Window_Home`
Esta clase representa la ventana principal de la interfaz de usuario de la aplicación.

---------------------------------------------------------------

### 3. Inicio Sesión

#### `Contraseña`
Esta clase representa una contraseña de usuario. Verifica que la contraseña tenga una longitud de entre 6 y 8 cifras.  

#### `Usuario`
Esta clase representa un nombre de usuario. Verifica que el nombre de usuario contenga solo letras y números y que no tenga más de 8 caracteres.  

#### `UsuarioButtonAction`
Esta clase implementa un ActionListener que muestra una ventana de información cuando se hace clic en el botón de usuario.  

#### `Window_InicioSesión`
Esta clase representa una ventana de la interfaz de usuario que permite al usuario iniciar sesión en la aplicación.


---------------------------------------------------------------

## ANÁLISIS

### Análisis y descripción de la aplicación

La aplicación permite a los usuarios crear y gestionar poblaciones de bacterias, cada una con sus propias características, como la fecha de inicio y fin, el recuento inicial de bacterias, la temperatura y las condiciones de luz. También se puede configurar una dosis de alimento para cada población.  

Además, la aplicación permite calcular la población de bacterias para un día específico, basándose en el recuento inicial de bacterias y asumiendo que la población se duplica cada día.  

La aplicación también proporciona una *interfaz gráfica de usuario* (GUI) para interactuar con las funcionalidades. La GUI incluye ventanas para visualizar y seleccionar poblaciones de bacterias, crear nuevas poblaciones, y ver la evolución de una población a lo largo del tiempo.  

Además, la aplicación incluye funcionalidades para *guardar y cargar* experimentos desde archivos, lo que permite a los usuarios mantener un registro de sus experimentos y continuar con ellos más tarde.  

Finalmente, la aplicación también incluye una *funcionalidad de inicio de sesión*, que permite a los usuarios iniciar sesión con un nombre de usuario y una contraseña.

Las **decisiones de diseño** tomadas incluyen el uso de una clase singleton para mantener un mapa de todas las poblaciones de bacterias y el uso de clases separadas para representar el nombre de usuario y la contraseña de un usuario. Esto proporciona una clara separación de responsabilidades y hace que el código sea más fácil de mantener.  

Las **comprobaciones de integridad** se han implementado en las clases Usuario y Contraseña. Estas comprobaciones aseguran que el nombre de usuario y la contraseña cumplen con ciertos requisitos. Si no lo hacen, se lanza una excepción.  

En cuanto a las **técnicas de ordenación y búsqueda**, no se han utilizado en el código proporcionado. Sin embargo, se podría utilizar una búsqueda en el mapa de poblaciones de bacterias en la clase PopulationManager para encontrar una población de bacterias por su nombre.  

---

### Listado de fallos y funcionalidades
Funcionalidades:  
> - Gestión de experimentos: La aplicación permite la creación, visualización y eliminación de experimentos bacterianos.  
> - Gestión de poblaciones bacterianas: La aplicación permite la creación, visualización, eliminación y visualización de información detallada de poblaciones bacterianas.  
> - Cálculo de la evolución de la población: La aplicación puede calcular la población de bacterias para un día específico.  
> - Gestión de inicio de sesión: La aplicación tiene una funcionalidad de inicio de sesión con validación de nombre de usuario y contraseña.  
> - Modo oscuro y modo para daltónicos: La aplicación tiene la capacidad de cambiar a un modo oscuro y un modo para daltónicos, aunque estas funcionalidades parecen estar incompletas.  
> - Carga y guardado de experimentos: La aplicación puede cargar experimentos desde un archivo y guardar experimentos en un archivo.  

Fallos:  
> - La funcionalidad de inicio de sesión no parece estar completamente implementada. No hay ninguna funcionalidad para registrar un nuevo usuario o recuperar una contraseña olvidada.  
> - La funcionalidad de dosis de alimento en la población bacteriana parece estar incompleta. Hay un botón para configurar la dosis de alimento, pero no está claro cómo se utiliza esta información.  
> - La funcionalidad de cambio a modo oscuro y modo para daltónicos parece estar incompleta. Hay código para cambiar los colores de los botones, pero no parece haber ninguna forma de activar estos modos.  
> - La aplicación no valida la entrada del usuario en muchos lugares. Por ejemplo, no verifica que las fechas de inicio y fin sean válidas al crear una nueva población bacteriana.  
> - La aplicación no maneja correctamente los errores de formato de archivo al cargar un experimento desde un archivo.  
> - La aplicación no parece tener ninguna funcionalidad para editar un experimento o una población bacteriana existente.  
> - La aplicación no tiene funcionalidad para manejar múltiples usuarios o para permitir a los usuarios cambiar su contraseña.


### Listado código
 
```
- main
  - java
    - GestorCultivos
      - BacteriaPopulation
      - Experiment
        - ExperimentLoader
        - ExperimentSaver
      - FoodDose
      - PopulationManager
    - Home
      - ExperimentWindow
      - PopulationEvolution Window
      - PopulationWindow
      - SelectPopulation Window
    - SharedData
    - Window_Home
    - Inicio Sesión
      - Contraseña
      - Usuario
        - UsuarioButtonAction
    - Window_Inicio Sesión
```


### Conclusiones
El proyecto es parte de una aplicación más amplia para gestionar experimentos de crecimiento de bacterias. Incluye clases para gestionar poblaciones de bacterias, experimentos e interfaces de usuario para gestionar y visualizar estos experimentos. La aplicación permite a los usuarios crear y gestionar diferentes poblaciones de bacterias, cada una con sus propios parámetros de crecimiento. Los usuarios también pueden crear experimentos, agregarles poblaciones y ver la evolución de estas poblaciones a lo largo del tiempo. La aplicación también incluye funcionalidad de autenticación de usuario. El código está escrito en Java y utiliza Swing para la interfaz gráfica de usuario.


---------------------------------------------------------------

## CONSEJOS
> Habla con el profesor para determinar cuál es la mejor forma para representar y almacenar los datos, y de estructurar la práctica. Organiza la práctica en al menos tres paquetes. Uno se encargará de la interfaz de usuario, otro se encargará de cargar y guardar datos en el disco duro, y el tercero se encargará de la lógica de negocio: añadir ratones, eliminar ratones, etc.… Utiliza funciones y métodos aislados, atómicos y con una responsabilidad completa. Si tienes dudas sobre la utilidad de una función o método, consulta con el profesor. Visualice especialmente las clases donde se realiza el UML y la separación de paquetes.

---------------------------------------------------------------

## SOBRE LA ENTREGA Y EVALUACIÓN DE LA PRÁCTICA
La práctica debe ser entregada en formato electrónico antes del 26 de marzo (inclusive). Para considerar que la práctica está entregada, el alumno deberá haber completado la entrega en formato electrónico (a través del campus virtual). La práctica deberá contener así mismo un fichero ejecutable .jar que permita ejecutar el código fuente sin necesidad de compilar el código. Si no se encuentra el fichero .jar la práctica se calificará con un 0.

Por cada semana que se retrase la entrega de la práctica a partir de esta fecha, la nota final de la práctica se le descontará 1 punto (0.15 puntos por día aproximadamente). La práctica puede realizarse a través de una consola o a través de una aplicación gráfica de escritorio empleando swing. El alumno tendrá que realizar una defensa de la práctica; si el alumno es incapaz de defender la práctica y explicar su funcionamiento, su nota en la práctica será un 0.

### ITEMS A ENTREGAR
Implementación íntegra de los requisitos establecidos en el enunciado de la práctica junto a la memoria descriptiva del trabajo realizado. Se evaluará de forma más positiva la descripción de requisitos no implementados y conocidos descritos en la memoria que la falta de funcionalidad desconocida y no descrita.

Todas las clases y sus clases y funciones contenidas deben tener las correspondientes pruebas unitarias.

Como resultado de esta entrega final se deberá enviar un fichero zip con la carpeta

completa que contenga el proyecto software IntelliJ o NetBeans correspondiente a la práctica (asegúrese de que incluye todo el código fuente, es la carpeta anterior al src, test, etc..) y además un fichero ejecutable .jar que permita ejecutar la práctica sin tener que compilar el código fuente.

La entrega de la práctica forma parte de la evaluación de la práctica.

La memoria incluirá una portada con el nombre del alumno y se ajustará a la siguiente estructura:

• Análisis y descripción de la aplicación. Este análisis y descripción dará respuesta a las siguientes preguntas:

    o   Cómo se han organizado y estructurado las clases y cuál es la responsabilidad de cada una.

    o   Qué decisiones de diseño se han tomado.

    o   Qué comprobaciones de integridad (y excepciones) se han implementado.

    o   Qué técnicas de ordenación y búsqueda ha utilizado y por qué lo ha hecho.

    o   Diagramas de clases UML.

  • Listado de fallos conocidos y funcionalidades definidas en el enunciado que no se han implementado en el código entregado.

  • Listado de todo el código fuente de la aplicación organizado por paquetes (si aplica) y clases.

  • Listado de pruebas unitarias realizadas.

  • Conclusiones (que incluirán, obligatoriamente, una valoración del tiempo dedicado a la práctica).

 Además de la defensa, la práctica se evaluará en relación a:

  • **Organización** y estructura del código (utilización de conceptos y patrones de programación, orientada a objetos: herencia, polimorfismo, encapsulación, reutilización, utilización correcta de estructuras de control, etc.).

  • **Uso de Javadoc** para documentar las clases y métodos.

  • Funcionamiento ajustado a los requisitos establecidos (incluyendo, además de chequeos de datos, integridad de la información, gestión de excepciones...).

  • **Claridad del código** y adecuación a las normas de estilo (correcto nombrado de clases, métodos y variables, comentarios internos, indentación del código...).
