package bot;

import bot.message.handling.MsgHandler;
import bot.message.handling.MsgHandlerManager;
import bot.message.handling.factory.impl.MsgHandlerManagerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ZosiaLongPollingBot extends TelegramLongPollingBot {
    private String name;
    private String token;

    private MsgHandlerManager msgHandlerManager;

    public ZosiaLongPollingBot(String name, String token) {
        this.name = name;
        this.token = token;
        msgHandlerManager = new MsgHandlerManager(this, new MsgHandlerManagerFactory());
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg;
        if (update.hasMessage() && (msg = update.getMessage()) != null) {
            MsgHandler messageHandler = msgHandlerManager.parse(msg);
            messageHandler.handle(msg);
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
