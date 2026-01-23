package JASONES.scripts;

import com.google.gson.*;
import org.example.Alumno;
import java.io.FileReader;

public class LeerJS {
    private Alumno alumnoRepo = new Alumno();

    // Método para cargar e insertar todo el JSON (CREATE)
    public void cargarTodoElJson() {
        try (FileReader reader = new FileReader("data/Empleados.json")) {
            JsonArray lista = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement elemento : lista) {
                JsonObject obj = elemento.getAsJsonObject();
                // Adaptamos los campos del JSON a los de Alumno.java
                alumnoRepo.insertAlumno(
                        obj.get("nombre").getAsString(),
                        "Apellido1", // Valor genérico si no existe en JSON
                        "Apellido2",
                        obj.get("edad").getAsInt()
                );
            }
        } catch (Exception e) {
            System.out.println("Error al cargar JSON: " + e.getMessage());
        }
    }

    // Método para actualizar un alumno usando datos de un ID específico del JSON (UPDATE)
    public void actualizarDesdeJson(int idBusqueda, String nuevoNombre) {
        try (FileReader reader = new FileReader("data/Empleados.json")) {
            JsonArray lista = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement el : lista) {
                JsonObject obj = el.getAsJsonObject();
                if (obj.get("id").getAsInt() == idBusqueda) {
                    // Usamos el método actualizarAlumno de Alumno.java
                    alumnoRepo.actualizarAlumno(
                            obj.get("nombre").getAsString(), // Nombre actual en DB
                            nuevoNombre,                     // Nuevo nombre
                            "Actualizado",
                            "Desde JSON",
                            obj.get("edad").getAsInt()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para borrar un alumno que coincida con un nombre del JSON (DELETE)
    public void borrarSegunJson(String nombreAEliminar) {
        // Llama directamente al método deleteByName de Alumno.java
        alumnoRepo.deleteByName(nombreAEliminar);
    }
}