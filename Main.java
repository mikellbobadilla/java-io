import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Entra y Salida Estandar */
        // entradaSalida();

        /* Lectura de Archivos */
        // lecturaEscrituraArchivos();

        /* Lectura y Escritura de Texto */
        // lecturaEscritura();

        /* Lectura y Escritura de Ojetos */
        lecturaEscrituraObjetos();
    }

    public static void lecturaEscrituraArchivos() {
        try {
            FileInputStream fileInputStream = new FileInputStream("archivo.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("nuevoArchivo.txt");

            int n = fileInputStream.read();

            while (n != -1) {

                /* Escribe en otro archivo */
                fileOutputStream.write(n);

                n = fileInputStream.read();
            }

            fileInputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void entradaSalida() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escribe un mensaje: ");
            String mensaje = scanner.nextLine();

            System.out.println("El mensaje que se ingreso es este: " + mensaje);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void lecturaEscritura() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("nuevoArchivo.txt"));

            String line = reader.readLine();
            writer.write("Hola, mundo!.");

            System.out.println("Datos leidos del archivo: \n" + line);

            reader.close();
            writer.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void lecturaEscrituraObjetos() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("objeto.dat"));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("nuevoObjeto.dat"));

            // Person person = new Person("Sting", "Bobadilla");
            Object obj = input.readObject();
            output.writeObject(obj);
            output.flush();
            output.writeObject(obj);

            System.out.println("Este objeto es una Instancia Persona: " + (obj instanceof Person));
            System.out.println((Person) obj);

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", lastName=" + lastName + "]";
    }

}