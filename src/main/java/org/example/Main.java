package org.example;

public class Main {
    static void main() {
        try {
            org.example.ConnectionBBDD.getConnectionMongo();
            System.out.println("Conexión correcta a PostgreSQL.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Alumno alumno = new Alumno();

        // Llama al metodo para ver los alumnos
        alumno.listarAlumnos();
        // Insertar org.example.Alumno
        //alumno.insertAlumno("ana", "Vázquez", "Guerrero", 25);
        // Actualizar org.example.Alumno
        //alumno.actualizarAlumno("Mónica", "Mónica", "Blásquez", "Güera", 20);
        // Borrar org.example.Alumno
        //alumno.deleteByName("ana");
    }
}