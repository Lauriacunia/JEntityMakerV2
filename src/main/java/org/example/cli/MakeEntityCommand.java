package org.example.cli;

public class MakeEntityCommand {

    private final String name;

    public MakeEntityCommand(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println("¡Creating entity with name!!: " + name);
        // Aquí puedes agregar la lógica para crear la entidad
    }
}
