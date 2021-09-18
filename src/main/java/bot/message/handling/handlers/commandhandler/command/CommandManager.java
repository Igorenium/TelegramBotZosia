package bot.message.handling.handlers.commandhandler.command;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    Map<String, BotCommand> commands;


    public CommandManager() {
        commands = new HashMap<>();
    }

    public void register(String cmdName, BotCommand cmd) {
        commands.put(cmdName, cmd);
    }

    public void execute(Message msg) {
        String[] fullCmd = msg.getText().substring(1).split(" ", 2);
        BotCommand cmd = commands.get(fullCmd[0]);
        if (cmd == null)
            commands.get(CommandLoader.DEFAULT_CMD).execute(msg);
        else {
            cmd.setCmdParams((fullCmd.length > 1) ? fullCmd[1] : null);
            cmd.execute(msg);
        }
    }
}
