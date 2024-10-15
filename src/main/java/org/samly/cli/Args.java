package org.samly.cli;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;

import java.io.File;


public class Args {
    @Parameter(description = "Input File", converter = FileConverter.class)
    private File file;

    public File getFile() {
        return file;
    }

    private static class FileConverter implements IStringConverter<File> {
        @Override
        public File convert(String value) { return new File(value); }
    }
}
