package com.sullivankw.FileRenamer;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value="/reverse")
public class FileRenamerController {

    @Autowired
    private FileRenameService fileRenameService;

    @ApiOperation(value = "provide directory name that contains image files to reverse order of")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ContentWrapper<FileResponseDto> reverse(@RequestParam String dir, @RequestParam String fileType) throws IOException {
        return ContentWrapper.wrap(fileRenameService.reverse(dir, fileType));
    }
}
