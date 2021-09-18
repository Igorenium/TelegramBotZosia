package bot.message.handling.handlers;

import bot.message.handling.MsgHandler;
import bot.message.sending.senders.TextSender;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class TextMsgHandler implements MsgHandler {
    private AbsSender absSender;

    public TextMsgHandler(AbsSender absSender) {
        this.absSender = absSender;
    }

    @Override
    public void handle(Message msg) {
        String text = "На это мне нечего сказать";
        new TextSender(absSender, msg, text).sendAnswer();
    }
}
