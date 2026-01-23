package JASONES.scripts;

import com.google.gson.*;
import org.example.Alumno; // Importamos la clase Alumno
import java.io.FileReader;

public class LeerJS {

    public void procesarEInsertarAlumnos() {
        Alumno alumnoCRUD = new Alumno(); // Instancia para usar los métodos de MongoDB

        try {
            Gson gson = new Gson();
            JsonArray listaEmpleados = gson.fromJson(
                    new FileReader("data/Empleados.json"), JsonArray.class
            );

            for (JsonElement elemento : listaEmpleados) {
                JsonObject emp = elemento.getAsJsonObject();

                // Extraemos los datos del JSON
                String nombre = emp.get("nombre").getAsString();
                int edad = emp.get("edad").getAsInt();

                // Como el JSON no tiene dos apellidos, usaremos valores por defecto
                // o dividiremos el nombre si fuera necesario.
                String apellido1 = "Desconocido";
                String apellido2 = "-";

                // Llamamos al método que ya tienes en Alumno.java
                alumnoCRUD.insertAlumno(nombre, apellido1, apellido2, edad);

                System.out.println("Insertado desde JSON: " + nombre);
            }

        } catch (Exception e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}