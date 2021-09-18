package service.media;

import java.nio.file.Path;

public interface Media {
    void setFileId(String fileId);
    String getFileId();
    void setFilePath(Path filePath);
    Path getFilePath();
    boolean hasFileId();
}
