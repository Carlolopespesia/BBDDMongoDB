package org.example;

import JASONES.scripts.LeerJS;

public class Main {
    public static void main(String[] args) {
        LeerJS procesador = new LeerJS();
        Alumno alumnoRepo = new Alumno();

        System.out.println("--- INICIANDO CRUD COMPLETO ---");

        // 1. CREATE: Insertar datos desde el JSON
        System.out.println("\n[1] Operación CREATE:");
        procesador.cargarTodoElJson();

        // 2. READ: Listar los alumnos actuales
        System.out.println("\n[2] Operación READ:");
        alumnoRepo.listarAlumnos();

        // 3. UPDATE: Actualizar un registro específico
        // Supongamos que queremos cambiar el nombre de un empleado que leímos
        System.out.println("\n[3] Operación UPDATE:");
        procesador.actualizarDesdeJson(1000, "Geneva Modificada");

        // 4. DELETE: Borrar un registro
        System.out.println("\n[4] Operación DELETE:");
        procesador.borrarSegunJson("Geneva Modificada");

        System.out.println("\n--- CRUD FINALIZADO ---");
    }
}