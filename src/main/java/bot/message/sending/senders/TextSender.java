package bot.message.sending.senders;

import bot.message.sending.Sender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TextSender extends Sender {
    public TextSender(AbsSender absSender, Message msg, String text) {
        super(absSender, msg);
        this.text = text;
    }

    @Override
    public void sendAnswer() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(msg.getChatId().toString());
        sendMessage.setParseMode("markdown");
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
