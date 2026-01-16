package JASONES.scripts;

import com.google.gson.*;
import java.io.FileReader;

public class LeerJS {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();
            // Aquí ocurre la deserialización: el archivo JSON se transforma en un objeto manejable desde Java.
            JsonObject cliente = gson.fromJson(
                    new FileReader("cliente.json"), JsonObject.class
            );
            // valores tipo enteros
            int id = cliente.get("id").getAsInt();
            int edad = cliente.get("edad").getAsInt();

// valores tipo string
            String nombre = cliente.get("nombre").getAsString();
            String email = cliente.get("email").getAsString();

// valores tipo boolean
            boolean activo = cliente.get("activo").getAsBoolean();
            double saldo = cliente.get("saldo").getAsDouble();

// valores tipo Array
            JsonArray telefonos = cliente.getAsJsonArray("telefonos");

// Se recorre para ver sus valores simples
            for (JsonElement t : telefonos) {
                System.out.println("- " + t.getAsString());
            }

// Cuando un campo contiene otro objeto, se accede con getAsJsonObject y luego se leen sus valores internos
            JsonObject direccion = cliente.getAsJsonObject("direccion");
            String ciudad = direccion.get("ciudad").getAsString();
            String cp = direccion.get("cp").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}