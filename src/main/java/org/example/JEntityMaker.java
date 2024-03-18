package org.example;
import com.beust.jcommander.JCommander;
import org.example.cli.CLIArguments;
import org.example.cli.CommandJMaker;
import org.example.cli.MakeEntityCommand;

public class JEntityMaker {
    public static void main(String[] args) {

        CommandJMaker jMakerCommand = new CommandJMaker();
        CLIArguments arguments = new CLIArguments();

        JCommander jc = JCommander.newBuilder()
                                  .addCommand("jmaker", jMakerCommand)//  comando principal
                                  .addCommand("make:entity", arguments) // subcomando
                                  .build();
        /*
        JCommander jc = JCommander.newBuilder()
                                  .addObject(jMakerCommand)//  comando principal
                                  .addCommand("make:entity", arguments) // subcomando
                                  .build(); */

        jc.parse(args);

        if (arguments.isHelp()) {
            jc.usage();
            return;
        }

        String parsedCommand = jc.getParsedCommand();
        if (parsedCommand == null || parsedCommand.isEmpty()) {
            System.out.println("No command provided or unknown command.");
            jc.usage(); // Muestra la ayuda
            return;
        }

        switch (parsedCommand) {
            case "make:entity":
                MakeEntityCommand command = arguments.getMakeEntityCommand();
                command.execute();
                break;
            default:
                System.out.println("Unknown command: " + parsedCommand);
                jc.usage(); // Muestra la ayuda
        }
    }
}

//  ./JEntityMakerV2 make:entity --name MyClass