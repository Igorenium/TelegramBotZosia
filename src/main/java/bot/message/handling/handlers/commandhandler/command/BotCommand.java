package bot.message.handling.handlers.commandhandler.command;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public abstract class BotCommand {
    protected AbsSender absSender;
    protected String params;

    public BotCommand(AbsSender absSender) {
        this.absSender = absSender;
    }

    public void setCmdParams(String params) {
        this.params = params;
    }

    public abstract void execute(Message msg);
}
