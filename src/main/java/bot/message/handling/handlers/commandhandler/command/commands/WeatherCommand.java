package bot.message.handling.handlers.commandhandler.command.commands;

import bot.message.handling.handlers.commandhandler.command.BotCommand;
import bot.message.sending.Sender;
import bot.message.sending.senders.PhotoSender;
import bot.message.sending.senders.TextSender;
import service.weather.Weather;
import service.weather.WeatherController;
import extentions.telegrambotapi.inputfile.InputFilePhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeatherCommand extends BotCommand {

    private WeatherController weatherController;
    Map<Integer, String> phrases;

    {
        phrases = new HashMap<>();
        fillInPhrases();
    }

    public WeatherCommand(AbsSender absSender) {
        super(absSender);
        weatherController = new WeatherController();
    }

    @Override
    public void execute(Message msg) {
        if (params == null) {
            new TextSender(absSender, msg, "Ты забыл ввести город").sendAnswer();
            return;
        }

        Weather weather;
        try {
            weather = weatherController.getWeather(params);
        }
        catch (IOException e) {
            new TextSender(absSender, msg, phrases.get(0)).sendAnswer();
            return;
        }

        InputFilePhoto inputFile = new InputFilePhoto(weather.getIcon());
        Sender sender = new PhotoSender(absSender, msg, inputFile);
        sender.setText("*Город:* " + weather.getCity() + "\n" +
                       "*Температура:* " + weather.getTemp() + " °C");
        sender.sendAnswer();
    }

    private void fillInPhrases() {
        int phraseNum = 0;
        phrases.put(phraseNum++, "Давай попробуем с другим городом");
        phrases.put(phraseNum, "А это точно город?");
    }
}
