package bot.message.handling.handlers.commandhandler.command.commands;

import bot.message.sending.senders.TextSender;
import service.emoji.Emoji;
import bot.message.handling.handlers.commandhandler.command.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand extends BotCommand {

    public HelpCommand(AbsSender absSender) {
        super(absSender);
    }

    @Override
    public void execute(Message msg) {
        String text = "Можешь выбрать что-нибудь" + "\n" +
                        "из списка моих любимых активностей:" + "\n" +

                        Emoji.SMALL_ORANGE_DIAMOND + " Обожаю пересматривать свои фотографии. " +
                        "Жми /photo и я покажу тебе что-нибудь из личных архивов." + "\n" +

//                        Emoji.SMALL_ORANGE_DIAMOND + " Вокал " + "\n" +

                        Emoji.SMALL_ORANGE_DIAMOND + " В силу возраста очень точно предсказываю погоду. " +
                        "Вводи /weather + название города через пробел для получения актуального прогноза погоды." + "\n\n" +

                        "Если запустался, жми /help";

        new TextSender(absSender, msg, text).sendAnswer();
    }
}
