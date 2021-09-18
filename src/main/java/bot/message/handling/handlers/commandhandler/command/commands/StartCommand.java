package bot.message.handling.handlers.commandhandler.command.commands;

import bot.message.sending.senders.TextSender;
import service.emoji.Emoji;
import bot.message.handling.handlers.commandhandler.command.BotCommand;
import bot.ZosiaLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StartCommand extends BotCommand {

    public StartCommand(AbsSender absSender) {
        super(absSender);
    }

    @Override
    public void execute(Message msg) {
        String text = Emoji.CAT_FACE+ " Мрмяу, наконец-то гости! " + Emoji.CAT_FACE +
                      "\n Все мозги затекли в ожидании общения." +
                      "\n Что будем делать?";

        new TextSender(absSender, msg, text).sendAnswer();
        ZosiaLongPollingBot bot = (ZosiaLongPollingBot) absSender;
    }
}
