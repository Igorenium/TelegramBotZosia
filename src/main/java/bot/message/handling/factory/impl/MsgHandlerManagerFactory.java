package bot.message.handling.factory.impl;

import bot.message.handling.handlers.AudioMsgHandler;
import bot.message.handling.handlers.commandhandler.command.CommandLoader;
import bot.message.handling.handlers.commandhandler.CommandMsgHandler;
import bot.message.handling.handlers.DefaultMsgHandler;
import bot.message.handling.handlers.TextMsgHandler;
import bot.message.handling.factory.MsgHandlerFactory;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class MsgHandlerManagerFactory implements MsgHandlerFactory {

    @Override
    public DefaultMsgHandler createDefaultMsgHandler() {
        return new DefaultMsgHandler();
    }

    @Override
    public TextMsgHandler createTextMsgHandler(AbsSender absSender) {
        return new TextMsgHandler(absSender);
    }

    @Override
    public CommandMsgHandler createCommandMsgHandler(AbsSender absSender) {
        return new CommandMsgHandler(new CommandLoader(absSender).getCommandManager());
    }

    @Override
    public AudioMsgHandler createAudioMsgHandler() {
        return new AudioMsgHandler();
    }
}

