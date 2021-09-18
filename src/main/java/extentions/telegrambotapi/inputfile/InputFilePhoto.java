package extentions.telegrambotapi.inputfile;

import service.media.medias.Photo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.io.InputStream;

public class InputFilePhoto extends InputFile {
    private Photo photo;

    public InputFilePhoto() {super();}

    public InputFilePhoto(String attachName) {
        super(attachName);
    }

    public InputFilePhoto(File mediaFile) {
        super(mediaFile);
    }

    public InputFilePhoto(File mediaFile, String fileName) {
        super(mediaFile, fileName);
    }

    public InputFilePhoto(InputStream mediaStream, String fileName) {
        super(mediaStream, fileName);
    }

    public InputFilePhoto(Photo photo) {
        this.photo = photo;
        if (photo.hasFileId())
            setMedia(photo.getFileId());
        else
            setMedia(new File(photo.getFilePath().toString()));
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public void updateFileId(Message msg) {
        if (photo == null)
            return;

        photo.setFileId(msg.getPhoto().get(0).getFileId());
    }
}
