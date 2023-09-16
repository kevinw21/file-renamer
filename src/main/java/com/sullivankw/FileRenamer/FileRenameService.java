package com.sullivankw.FileRenamer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FileRenameService {
    private static final String DESTINATION_DIR = "reverse";
    public FileResponseDto reverse(String targetDir, String fileType) throws IOException {
        List<File> originalFiles = (List<File>) FileUtils
                .listFiles(new File(String.format("//%s", targetDir)), new SuffixFileFilter(fileType), TrueFileFilter.INSTANCE);
        if (CollectionUtils.isEmpty(originalFiles)) {
            throw new IllegalArgumentException(String.format("%s was not found", targetDir));
        }
        Collections.sort(originalFiles);
        Collections.reverse(originalFiles);
        List<String> reverseFileNames = write(targetDir, fileType, originalFiles);
        return new FileResponseDto(String.format("%s_%s", DESTINATION_DIR, targetDir),
                reverseFileNames.size(),reverseFileNames);
    }

    private static List<String> write(String targetDir, String fileType, List<File> originalFiles) throws IOException {
        List<String> reverseFileNames = new ArrayList<>();
        for (int i = 1; i < originalFiles.size() -1; i++) {
            File destination = new File(String.format("%s/%s/%s.%s", targetDir, DESTINATION_DIR, i, fileType));
            FileUtils.copyFile(originalFiles.get(i), destination);
            reverseFileNames.add(destination.getName());
        }
        return reverseFileNames;
    }
}
