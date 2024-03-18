package org.example.cli;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Make entity command")
public class CLIArguments {

    @Parameter(names = "--name", description = "Entity name")
    private String name;

    @Parameter(names = {"--help", "-h"}, help = true, description = "Display help information")
    private boolean help;

    public MakeEntityCommand getMakeEntityCommand() {
        return new MakeEntityCommand(name);
    }

    public boolean isHelp() {
        return help;
    }
}