package bot.message.handling.handlers.commandhandler.command.commands;

import bot.message.sending.senders.TextSender;
import service.emoji.Emoji;
import bot.message.handling.handlers.commandhandler.command.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DefaultCommand extends BotCommand {
    Map<Integer, String> phrases;

    {
        phrases = new HashMap<>();
        fillInPhrases();
    }

    public DefaultCommand(AbsSender absSender) {
        super(absSender);
    }

    @Override
    public void execute(Message msg) {
        String text = phrases.get(new Random().nextInt(phrases.size()));
        new TextSender(absSender, msg, text).sendAnswer();
    }

    private void fillInPhrases() {
        int phraseNum = 0;
        phrases.put(phraseNum++, "Такого я не знаю " + Emoji.EYES);
        phrases.put(phraseNum++, "Нет, этому меня не учили " + Emoji.WOMAN_SHRUGGING);
        phrases.put(phraseNum++, "Тут написано что-то обидное, да? " + Emoji.CRYING_CAT);
        phrases.put(phraseNum++, "Ну это совмем глупость " + Emoji.SEE_NO_EVIL_MONKEY);
        phrases.put(phraseNum, "Не буду этого делать " + Emoji.WOMAN_GESTURING_NO);
    }
}
