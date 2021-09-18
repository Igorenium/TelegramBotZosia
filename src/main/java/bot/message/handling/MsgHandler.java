package bot.message.handling;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface MsgHandler {
    void handle(Message msg);
}
