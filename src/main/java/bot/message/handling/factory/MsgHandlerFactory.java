package bot.message.handling.factory;

import bot.message.handling.handlers.AudioMsgHandler;
import bot.message.handling.handlers.commandhandler.CommandMsgHandler;
import bot.message.handling.handlers.DefaultMsgHandler;
import bot.message.handling.handlers.TextMsgHandler;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface MsgHandlerFactory {
    DefaultMsgHandler createDefaultMsgHandler();
    TextMsgHandler createTextMsgHandler(AbsSender absSender);
    CommandMsgHandler createCommandMsgHandler(AbsSender absSender);
    AudioMsgHandler createAudioMsgHandler();
}
