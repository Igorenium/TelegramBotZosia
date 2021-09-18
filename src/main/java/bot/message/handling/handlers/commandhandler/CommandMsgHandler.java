package bot.message.handling.handlers.commandhandler;

import bot.message.handling.handlers.commandhandler.command.CommandManager;
import bot.message.handling.MsgHandler;
import org.telegram.telegrambots.meta.api.objects.Message;

public class CommandMsgHandler implements MsgHandler {

    private CommandManager cmdMan;

    public CommandMsgHandler(CommandManager cmdMan) {
        this.cmdMan = cmdMan;
    }

    @Override
    public void handle(Message msg) {
        cmdMan.execute(msg);
    }
}
