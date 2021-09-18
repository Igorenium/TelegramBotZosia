package service.media.storage.photo;

import service.media.medias.Photo;
import service.media.Media;
import service.media.storage.Storage;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class PhotoStorage implements Storage {
    private static PhotoStorage photoStorage= new PhotoStorage();
    private static Map<Integer, Photo> photos = new HashMap<>();

    static {
        File photoDir = new File("src/main/resources/Photos");
        File[] files = photoDir.listFiles();
        Integer serialNum = 0;
        if (files != null) {
            for (File file : files) {
                if (file.getName().toUpperCase().endsWith(".JPG")) {
                    photos.put(serialNum++, new Photo(Paths.get(file.getPath())));
                }
            }
        }
    }

    private PhotoStorage() {}

    public static PhotoStorage getInstance() {
        return photoStorage;
    }

    @Override
    public Media getRandMedia() {
        return photos.get(new Random().nextInt(photos.size()));
    }

    @Override
    public List<? extends Media> getRandMediaList(int num) {
        List<Photo> photoList = new ArrayList<>();
        num = Math.min(photos.size(), num);
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Photo photo;
            boolean isPhotoUniq = false;
            do {
                photo = photos.get(random.nextInt(photos.size()));
                if (!photoList.contains(photo)) isPhotoUniq = true;
            } while (!isPhotoUniq);
            photoList.add(photo);
        }
        return photoList;
    }
}
