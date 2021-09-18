package bot.message.handling.handlers.commandhandler.command;

import bot.message.handling.handlers.commandhandler.command.commands.*;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class CommandLoader {

    public static final String DEFAULT_CMD = "default";

    private AbsSender absSender;
    private CommandManager cmdMan;

    public CommandLoader(AbsSender absSender) {
        this.absSender = absSender;
        cmdMan = new CommandManager();
        registerCommands();
    }

    private void registerCommands() {
        cmdMan.register(DEFAULT_CMD, new DefaultCommand(absSender));
        cmdMan.register("start", new StartCommand(absSender));
        cmdMan.register("help", new HelpCommand(absSender));
        cmdMan.register("weather", new WeatherCommand(absSender));
        cmdMan.register("photo", new PhotoCommand(absSender));
    }

    public CommandManager getCommandManager() {
        return cmdMan;
    }
}




