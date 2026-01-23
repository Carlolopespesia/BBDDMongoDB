package org.example;

import JASONES.scripts.LeerJS;

public class Main {
    // Agregamos String[] args para que sea un método main ejecutable estándar
    public static void main(String[] args) {
        try {
            // 1. Validar conexión
            org.example.ConnectionBBDD.getConnectionMongo();
            System.out.println("Conexión correcta a MongoDB.");

            // 2. Instanciar el lector de JSON
            LeerJS lector = new LeerJS();

            // 3. Ejecutar la lectura e inserción
            System.out.println("Iniciando carga de datos desde JSON...");
            lector.procesarEInsertarAlumnos();

            // 4. Listar resultados finales
            System.out.println("\nEstado final de la base de datos:");
            Alumno alumno = new Alumno();
            alumno.listarAlumnos();

        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
        }
    }
}