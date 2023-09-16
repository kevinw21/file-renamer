package com.sullivankw.FileRenamer;

import java.util.List;

public record FileResponseDto(String dir, int items, List<String> files) {
}
