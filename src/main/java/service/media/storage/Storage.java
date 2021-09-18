package service.media.storage;

import service.media.Media;

import java.util.List;

public interface Storage {
    Media getRandMedia();
    List<? extends Media> getRandMediaList(int num);
}
