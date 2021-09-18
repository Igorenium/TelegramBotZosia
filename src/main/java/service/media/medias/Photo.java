package service.media.medias;

import service.media.Media;

import java.nio.file.Path;

public class Photo implements Media {
    private Path filePath;
    private String fileId;

    public Photo(Path filePath) {
        this.filePath = filePath;
    }

    public Photo(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String getFileId() {
        return fileId;
    }

    @Override
    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getFilePath() {
        return filePath;
    }

    @Override
    public boolean hasFileId() {
        return fileId != null;
    }
}
