package bot.message.sending.senders;

import bot.message.sending.Sender;
import service.media.MediaListAttendant;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MediaGroupSender extends Sender {
    private MediaListAttendant mediaContainer;

    public MediaGroupSender(AbsSender absSender, Message msg, MediaListAttendant mediaContainer) {
        super(absSender, msg);
        this.mediaContainer =mediaContainer;
    }

    @Override
    public void sendAnswer() {
        SendMediaGroup sendMediaGroup = new SendMediaGroup();
        sendMediaGroup.setMedias(mediaContainer.getInputMediaList());
        sendMediaGroup.setChatId(msg.getChatId().toString());

        try {
            List<Message> replyMsgList = absSender.execute(sendMediaGroup);
            mediaContainer.updateFileIds(replyMsgList);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
