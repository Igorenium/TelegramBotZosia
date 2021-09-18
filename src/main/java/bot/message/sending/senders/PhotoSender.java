package bot.message.sending.senders;

import bot.message.sending.Sender;
import extentions.telegrambotapi.inputfile.InputFilePhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class PhotoSender extends Sender {
    private InputFilePhoto inputFilePhoto;

    public PhotoSender(AbsSender absSender, Message msg, InputFilePhoto inputFilePhoto) {
        super(absSender, msg);
        this.inputFilePhoto = inputFilePhoto;
    }

    @Override
    public void sendAnswer() {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(inputFilePhoto);
        sendPhoto.setChatId(msg.getChatId().toString());
        sendPhoto.setParseMode("markdown");
        if (text != null) sendPhoto.setCaption(text);

        try {
            Message replyMsg = absSender.execute(sendPhoto);
            inputFilePhoto.updateFileId(replyMsg);
        } catch (TelegramApiException e) {
            System.out.println("Fail while PHOTO transferring");
        }
    }
}
