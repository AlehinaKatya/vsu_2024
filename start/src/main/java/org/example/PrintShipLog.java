package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintShipLog {
    private static final Path PATH =
            Paths.get("alehina.kate/lab4/src/main/resources/entries.txt");
    private final ShipAccountingLog shipAccountingLog;
    private final List<Entry> entryList;

    public PrintShipLog() {
        ReadFile fileReader = new ReadFile();
        entryList = fileReader.readEntriesFromFile(PATH);
        shipAccountingLog = new ShipAccountingLog();
    }

    public void printStatisticsOnShipsBoarded() {
        System.out.println("Статистика по короблям для каждой страны");
        shipAccountingLog.statisticsOnShipsBoarded(entryList)
                .forEach((key, value) -> {
                    System.out.println(key.getCitizenshipName() + '\t' + value.toString());
                });
    }

    public void printTheLowestProfitableMonthInGold() {
        System.out.println("Наименьший доходный месяц по золоту: " +
                shipAccountingLog.theLowestProfitableMonthInGold(entryList).toString());
    }

    public void printTheLargestStocksOfRum() {
        System.out.println("Корабли, на которых возят самые большие запасы рома (за последние 3 года)");
        shipAccountingLog.theLargestStocksOfRum(entryList)
                .forEach(entry -> {
                    System.out.println(entry.toString());
                });
    }
}
