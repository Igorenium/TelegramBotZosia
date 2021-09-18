package bot.message.handling.handlers.commandhandler.command.commands;

import bot.message.handling.handlers.commandhandler.command.BotCommand;
import bot.message.sending.senders.MediaGroupSender;
import bot.message.sending.senders.PhotoSender;
import bot.message.sending.senders.TextSender;
import service.media.medias.Photo;
import service.media.MediaListAttendant;
import service.media.storage.photo.PhotoStorage;
import extentions.telegrambotapi.inputfile.InputFilePhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

public class PhotoCommand extends BotCommand {
    private final int MAX_PHOTO_IN_SCOPE = 9;

    public PhotoCommand(AbsSender absSender) {
        super(absSender);
    }

    @Override
    public void execute(Message msg) {
        int photoCount;
        try {
            photoCount =  (params != null) ? Integer.parseInt(params) : MAX_PHOTO_IN_SCOPE;
        }
        catch(NumberFormatException e) {
            new TextSender(absSender, msg, "После команды /photo введи количество фотографий, которое хочешь получить. Максимум - " + MAX_PHOTO_IN_SCOPE).sendAnswer();
            return;
        }

        if (photoCount == 0)
            return;

        if (photoCount == 1) {
            Photo photo = (Photo)PhotoStorage.getInstance().getRandMedia();
            InputFilePhoto inputFilePhoto = new InputFilePhoto(photo);
            new PhotoSender(absSender, msg, inputFilePhoto).sendAnswer();
        }
        else {
            photoCount = Math.min(photoCount, MAX_PHOTO_IN_SCOPE);
            List<Photo> photoList = (List<Photo>)PhotoStorage.getInstance().getRandMediaList(photoCount);
            new MediaGroupSender(absSender, msg, new MediaListAttendant(photoList)).sendAnswer();
        }
    }
}
