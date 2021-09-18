package bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BotManager {

    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        property.load(new FileInputStream("src/main/resources/properties/telegrambot.properties"));
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new ZosiaLongPollingBot(property.getProperty("telegrambot.name"), property.getProperty("telegrambot.token")));
        } catch (TelegramApiException e) {
            System.out.println(System.getenv());
            e.printStackTrace();
        }
    }
}