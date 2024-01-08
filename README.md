# Entrada / Salida en Java (I-O)

1. **Conceptos basicos:**
    - ***Entrada(input):*** Se refiere a la información que un programa recibe del exterior. En java comúnmente proviene del teclado, archivos, redes, etc.
    - ***Salida(output):*** Es la información que un programa produce y envía al exterior. Puede ser mostrada en consola, escrita en archivos, enviada a través de la red, etc.

2.  **Flujos de Entrada y Salida:**
    - ***Flujo de Entrada(InputStream):*** Es una secuencia de bytes desde la cual un programa puede leer datos. Ejemplos incluyen la lectura de datos desde el teclado o desde un archivo.
    - ***Flujo de Salida(OutputStream):*** Es una secuencia de bytes a la cual un programa puede escribir datos. Ejemplos incluyen escribir datos en un archivo o enviar datos a traves de una red.

3. **Clases Básicas de Java para E/S:**
    - ***System.in y Scanner:*** System.in Es el flujo de entrada estándar que representa el teclado. La clase Scanner se utiliza para leer datos de este flujo. 
    ```java
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine();
    ```
    - ***System.out y PrintStream:*** System.out es el flujo de salida estándar que representa la consola. La clase PrintStream se utiliza para escribir datos en este flujo.
    ```java
    System.out.println("Hoa, mundo!");
    ```
    - ***FileInputStream y FileOutputStream:*** Permiten la lectura y escritura de archivos respectivamente.
    ```java
    FileInputStream fileInputStream = new FileInputStream("archivo.txt").
    FileOutputStream fileOutputStream = new FileOutputStream("nuevoArchivo.txt").
    ```
4. **Lectura y Escritura de Texto:** 
    - ***BufferedReader y BufferedWriter:*** Estas clases permiten la lectura y escritura eficiente de texto mediante la gestion de búferes.
    ```java
    BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("nuevoArchivo.txt"));

    String line = reader.readLine();
    writer.write("Hola, mundo!");
    ```
5. **Lectura y Escritura de Objetos:**
    - ***ObjectInputStream y ObjectOurtputStream:*** Permiten la lectura y escritura de objetos Java facilitando la serialización y deserialización.
    ```java
    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objeto.data"));
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("nuevoObjeto.dat"));

    Object obj = objectInputStream.readObject();
    objectOutputStream.writeObject(obj);
    ```

## Operaciones avanzadas de Entrada/Salida(E/S) en Java

1. **Manipulación de Bytes:**
    - ***ByteArrayInputStream y ByteArrayOutputStream:*** Estas permiten la lectura y escritura de datos en forma de bytes desde y hacia arreglos de bytes en la memoria.
    ```java
    byte[] data = {65, 66, 67, 68, 69};
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
    int byteRead = byteArrayInputStream.read(); /* Lee el primer byte (65) */
    ```

2. **Lectura y Escritura de Datos Primitivos:**
    - ***DataInputStream y DataOutputStream:*** Estas clases facilitan la lectura y escritura de datos primitivos (como enteros, flotantes, booleanos) en forma binaria.
    ```java
    DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("datos.bin"));
    dataOutputStream.writeInt(42); /* Lee el entero previamente escrito */
    ```

3. **Operaciones de E/S Asíncronas(Java NIO):**
    - ***java.nio (New I/O):*** Proporciona una forma mas eficiente y escalable de realizar operaciones de E/S en java, especialmente útil para operaciones asíncronas y no bloqueantes.
        - ***ByteBuffer:*** Una clase que facilita la manipulación de datos en forma de bloques de bytes.
        ```java
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ```
        - ***Canales(Channels):*** Proporciona una interfaz para operaciones de E/S en buffers y son fundamentales en la programacion de E/S no bloqueante.
        ```java
        FileChannel channel = FileChannel.open(Paths.get("archivo.txt"), StandardOpenOption.READ);
        int bytesRead = channel.read(buffer);
        ```
        - ***Operaciones Asíncronas(AsynchronousFileChannel):*** Permite realizar operaciones de E/S de forma asíncronas, lo que puede mejorar la eficiencia en ciertos escenarios.
        ```java
        AsynchronousFileChannel  asyncChannel = AsynchronousFileChannel.open(Paths.get("archivo.txt"), StandardOpenOption.READ);

        Future<Integer> result = asyncChannel.read(buffer, 0)
        ```
