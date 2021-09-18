package bot.message.handling;

import bot.message.handling.handlers.AudioMsgHandler;
import bot.message.handling.handlers.commandhandler.CommandMsgHandler;
import bot.message.handling.handlers.DefaultMsgHandler;
import bot.message.handling.handlers.TextMsgHandler;
import bot.message.handling.factory.MsgHandlerFactory;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class MsgHandlerManager {
    private MsgHandlerFactory factory;

    private DefaultMsgHandler defaultMsgHandler;
    private CommandMsgHandler commandMsgHandler;
    private TextMsgHandler textMsgHandler;
    private AudioMsgHandler audioMsgHandler;

    public MsgHandlerManager(AbsSender absSender, MsgHandlerFactory factory) {
        this.factory = factory;
        defaultMsgHandler = factory.createDefaultMsgHandler();
        commandMsgHandler = factory.createCommandMsgHandler(absSender);
        textMsgHandler = factory.createTextMsgHandler(absSender);
        audioMsgHandler = factory.createAudioMsgHandler();
    }

    public MsgHandler parse(Message msg) {
        if (msg.hasText())
            if (msg.isCommand())
                return commandMsgHandler;
            else
                return textMsgHandler;

        if (msg.hasAudio())
            return audioMsgHandler;

        return defaultMsgHandler;
    }

}



