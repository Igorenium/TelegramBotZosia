package service.media;

import service.media.medias.Photo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaListAttendant {
    private List<Photo> photoList;
    private String text;

    public MediaListAttendant(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<InputMedia> getInputMediaList() {
        List<InputMedia> inputMediaList = new ArrayList<>();
        for (Photo photo : photoList) {
            InputMedia inputMedia;
            if (photo.hasFileId())
                inputMedia = new InputMediaPhoto(photo.getFileId());
            else {
                inputMedia = new InputMediaPhoto();
                inputMedia.setMedia(new File(photo.getFilePath().toString()), photo.getFilePath().getFileName().toString());
            }
            inputMediaList.add(inputMedia);
        }
        return inputMediaList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void updateFileIds(List<Message> msgList) {
        for (int i = 0; i < photoList.size(); i++) {
            Message msg = msgList.get(i);
            photoList.get(i).setFileId(msg.getPhoto().get(0).getFileId());
        }
    }
}

