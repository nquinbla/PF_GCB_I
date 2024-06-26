# PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS 
Partes 1 y 2 de la "Práctica Final para la Aplicación para Gestionar Cultivos de Bacterias" de Nerea Quintanilla Blanco

LINK -> https://github.com/nquinbla/PF_GCB_I.git

**El jar que ha solicitado se encuentra de la siguiente manera**
```
out -> artifacts -> PF_GCB_I_jar -> PF_GCB_I_jar
```

- [PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS I](#práctica-final-aplicación-para-gestionar-cultivos-de-bacterias-i)
- [PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS II](#práctica-final-aplicación-para-gestionar-cultivos-de-bacterias-ii)


***
# [1] PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS I
Parte 1 de la "Práctica Final para la Aplicación para Gestionar Cultivos de Bacterias" de Nerea Quintanilla Blanco

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


---
---

# [2] PRÁCTICA FINAL: APLICACIÓN PARA GESTIONAR CULTIVOS DE BACTERIAS II

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
 
## DESCRIPCIÓN
Los biólogos para los que hemos hecho la aplicación se han dado cuenta de que no todos los experimentos que van a realizar en las poblaciones duran 30 días, sino que algunos van a durar algunos días más, y otros algunos días menos, aunque definitivamente no pueden comenzar después de la fecha de finalización, por lo que nos han pedido que la duración sea variable. Además, nos han pedido que cambiemos las unidades en las cuales medimos la comida de las bacterias de miligramos (donde el máximo eran 300) a microgramos (donde el máximo serán 300,000).

Por otro lado, también quieren trabajar con experimentos donde el patrón de suministro de comida a las bacterias es diferente. Además del patrón de incremento lineal seguido de decremento lineal que ya contemplamos en la primera versión de la aplicación, quieren que también existan otras tres opciones para indicar la comida para las bacterias: una cantidad de comida constante durante toda la duración del experimento; incrementar linealmente la cantidad de comida de cada día partiendo de un valor inicial y llegando a un valor final; y proporcionar una determinada cantidad de comida constante durante todo el experimento un día, y al siguiente no proporcionar comida, al siguiente se le proporciona, y al siguiente no se le proporciona, y así sucesivamente. (Nota: 50% de la calificación de la práctica hasta aquí).

También quieren poder ordenar el listado de todas las poblaciones de bacterias por la fecha de inicio asociada a la población de bacterias (orden cronológico de más antiguo a más reciente), por el nombre de la población de bacterias, y por el número de bacterias de la población. (Nota: 65 % de la calificación de la práctica hasta aquí)

Por otro lado, cuando han comenzado a hacer los experimentos con las bacterias se han dado cuenta de que muchos de los experimentos no terminaban como ellos esperaban. Por ello nos han pedido que la propia herramienta sea capaz de simular cómo va a ser la evolución del experimento empleando simulaciones de Montecarlo. La simulación de Montecarlo consiste en realizar simulaciones basadas en la generación de números aleatorios y en la aplicación de una serie de restricciones que tratan de reflejar lo que sucede en el mundo real, añadiendo una componente de aleatoriedad. Para hacer este tipo de simulación consideraremos que las bacterias están sobre un plato de cultivo que es un rectángulo formado por celdas todas ellas de tamaño igual y con 20 celdas de lado (por lo que el plato tendrá 20 × 20 celdas).

Los científicos el primer día colocan a todas las bacterias en el centro del plato de cultivo, ocupando un cuadrado con un lado de sólo 4 × 4 celdas. Cada una de estas celdas se repartirá inicialmente las bacterias a partes iguales. Es decir, si inicialmente tenemos una población de 1600 bacterias, cada celda del recuadro central de 4 × 4 del plato tendrá 100 bacterias.

La comida para las bacterias se suministra de tal modo que se reparte a partes iguales entre todas las celdas del plato de cultivo (no sólo donde hay bacterias). Es decir, si se han añadido 40,000 microgramos de comida, a cada celda le tocan 100 microgramos de comida. Consideraremos que la cantidad de comida en microgramos siempre se representa por números enteros.
Para realizar la simulación de Montecarlo se aplicarán las siguientes reglas. Las bacterias comienzan el primer día en el centro del plato, ocupando un subcuadrado de 4

× 4. Las bacterias se reparten a partes iguales entre todas las celdas del subcuadrado. La comida del primer día está repartida a partes iguales entre todas las celdas del plato.

A continuación, comenzaremos a simular qué pasa ese día con cada una de las bacterias. Seleccionaremos la primera bacteria. Para cada bacteria realizaremos los siguientes pasos de la simulación de Montecarlo que consisten en lo siguiente:

  1. Si la bacteria se encuentra en una celda donde hay 100 microgramos de comida o más, la bacteria come 20 microgramos de comida, que desaparecerán de la celda, y la bacteria "genera un número aleatorio" entre 0 y 100; si

    a. el número es menor que 3, la bacteria se muere.

    b. si el número es mayor o igual que 3 y menor que 60, la bacteria se queda en la celda en la que está;

    c.si el número es mayor o igual que 60 y menor que 100, la bacteria se mueve a una celda contigua a la celda en la que está según se indica en la tabla; excepto si dicha celda está fuera del plato; en ese caso se queda donde está.

| 65 <=N <70 | 65 <=N < 70 | 70 <=N < 75 |
| --------- | --------- | --------- |
| 75 <=N <80 | N < 3 se muere 3 <=N < 60 se queda en esta celda | 80 <=N < 85 |
| 85 <=N <90 | 90 <=N < 95 | 95 <= n < 100 |


  2. Si la bacteria se encuentra en una celda donde hay menos de 100 microgramos de comida y más de 9 microgramos de comida, la bacteria come 10 microgramo de comida, que desaparecerá de la celda, y la bacteria genera un número aleatorio entre 0 y 100; si

    a. el número es menor que 6, la bacteria se muere.

    b. si el número es mayor o igual que 6 y menor que 20, la bacteria se queda en la celda en la que está;

    c. si el número es mayor o igual que 20 y menor que 100, la bacteria se mueve a una celda contigua a la celda en la que está según se indica en la tabla; excepto si dicha celda está fuera del plato; en ese caso se queda donde está.

 | 20 <=N < 30 | 30 <=N <40 | 40 / <=N < 50 |
| --------- | --------- | --------- |
| 50 / <=N <60 | N < 6 se muere 6 <=N < 20 se queda en esta celda | 60 / <=N < 70 |
| 70 <=N <80 | 80 <=N < 90 | 90 <= n < 100 |


  3. Si la bacteria se encuentra en una celda donde hay 9 microgramos o menos de comida, la bacteria genera un numero aleatorio entre 0 y 100; si

    a. el número es menor que 20, la bacteria se muere.

    b. si el número es mayor o igual que 20 y menor que 60, la bacteria se queda en la celda en la que está;

    c. si el número es mayor o igual que 60 y menor que 100, la bacteria se mueve a una celda contigua a la celda en la que está según se indica en la tabla; excepto si dicha celda está fuera del plato; en ese caso se queda donde está.

 | 65 <=N <65 | 65 <=N < 70 | 70 <=N < 75 |
| --------- | --------- | --------- |
| 75 <=N <80 | N < 20 se muere 20 <=N < 60 se queda en esta celda | 80 <=N < 85 |
| 85 <=N <90 | 90 <=N < 95 | 95 <= n < 100 |


Esta simulación se realiza "10 veces por día" (es decir, para cada bacteria, para cada día hay que repetir 10 veces los pasos descritos sobre estas líneas). Tras los 10 pasos de la simulación para cada bacteria, si la bacteria no se ha muerto, calcularemos toda la cantidad de comida que la bacteria "ha comido" a lo largo de este día y:

>1. Si la bacteria ha comido 150 microgramos de comida o más, la bacteria crea tres bacterias hijas que estarán en la misma celda donde está su madre. En la simulación de este día no hay que hacer nada con ellas, pero en la simulación del siguiente día serán bacterias como otra cualquiera y habrá que simularlas.

>2. Si la bacteria ha comido de 100 a 150 microgramos de comida, la bacteria crea dos bacterias hijas que estarán en la misma celda.

>3. Si la bacteria ha comido de 50 a 100 microgramos de comida, la bacteria crea una bacteria hija que estará en la misma celda que ella.

>4. Si la bacteria ha comido menos de 50 microgramos de comida, la bacteria no tiene ningún hijo.

Esta simulación deberá realizarse para todas las bacterias, exceptuando las bacterias hijas de este día. Una vez la simulación se ha realizado para todas las bacterias, habremos terminado de simular el primer día. A continuación, se comenzará a simular el siguiente día; la simulación comenzará repartiendo a partes iguales entre todas las celdas del plato la comida del día siguiente, que se acumulará a la comida que pueda haber quedado en esa celda del día anterior. Y se volverá a comenzar a simular todas las bacterias que estén vivas, tanto las que han sobrevivido del día anterior, como las hijas que han tenido. Y así sucesivamente hasta llegar a los días que dure el experimento.

Cuando realicemos una simulación, el experimento deberá de ir calculando cuántas bacterias hay cada día. Este número de bacterias se almacenarán en una matriz tridimensional que tendrá una matriz bidimensional por día, y para cada día contendrá en la matriz bidimensional la información relativa al número de bacterias vivas que hay en ese día y en esa celda al final de la simulación, así como la comida que ha quedado sin comer en esa celda ese día.

Una vez haya terminado la simulación, deberá mostrarse los resultados al usuario. Para ello, podremos mostrar el número de bacterias de cada celda del plato en la consola, o en la pantalla de la aplicación swing. Una solución más elegante sería mostrar en pantalla una ventana con un panel con una matriz donde se pintarán todas las celdas del plato de cultivo. El color de cada una de las celdas deberá reflejar de algún modo el número de bacterias que hay dentro de ella. Por ejemplo, si hay 20 o más bacterias en una celda, se dibuja en rojo. Si hay entre 15 y 19 bacterias, se dibuja en morado. Si hay entre 10 y 14 bacterias, se dibuja en naranja. Si hay entre 5 y 9 bacterias se dibujan en amarillo. Si hay entre 1 y 4 bacterias se dibuja en verde. Si no hay ninguna bacteria, se dibuja en blanco. Podrán emplearse otros mecanismos de representación del número de bacterias (por ejemplo, un gradiente de colores reflejando el número de bacterias de cada celda).

La aplicación deberá permitir realizar las siguientes acciones:

1.     Abrir un archivo que contenga un experimento

2.     Crear un nuevo experimento

3.     Crear una población de bacterias y añadirla al experimento actual

4.     Visualizar los nombres de todas las poblaciones de bacterias del experimento actual

5.     Borrar una población de bacterias del experimento actual

6.     Ver información detallada de una población de bacterias del experimento actual

7.     Realizar y visualizar la simulación correspondiente con una de las poblaciones de bacterias del experimento.

8.     Guardar (se supone que para usar esta opción previamente hemos abierto un archivo)

9.     Guardar como

 

Necesariamente habrá que guardar en modo texto toda la información correspondiente con cada experimento. No será necesario guardar la información correspondiente con la simulación, ya que ésta podrá volver a generarse cada vez que se cargue un experimento en la aplicación.
Al seleccionar la opción 4, deberá preguntársele al usuario si desea ver las poblaciones ordenadas por nombre, por fecha o por cantidad de bacterias, y mostrarlas ordenadas por el campo adecuado.

## MÓDULOS




___
___
___
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
