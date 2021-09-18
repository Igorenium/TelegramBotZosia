package bot.message.sending;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public abstract class Sender {
    protected AbsSender absSender;
    protected Message msg;
    protected String text;

    public Sender(AbsSender absSender, Message msg) {
        this.absSender = absSender;
        this.msg = msg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void sendAnswer();
}
