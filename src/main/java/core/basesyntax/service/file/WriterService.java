package core.basesyntax.service.file;

public interface WriterService {
    void writeResultInFile(String filePath, ReportCreator reportCreator);
}