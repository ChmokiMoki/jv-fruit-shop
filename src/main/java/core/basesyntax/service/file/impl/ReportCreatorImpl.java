package core.basesyntax.service.file.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.file.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private final FruitDao fruitDao;

    public ReportCreatorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createResultForWriting() {
        String dataFromDb = fruitDao.getAllDataFromDB();
        String dataForWriting = "fruit,quantity" + System.lineSeparator();
        dataForWriting += dataFromDb.lines()
                .map(s -> s.replaceAll(",", System.lineSeparator()))
                .map(s -> s.replaceAll("-", ","))
                .map(s -> s.replaceAll("[\\[\\] ]", ""))
                .collect(Collectors.joining());
        return dataForWriting;
    }
}
