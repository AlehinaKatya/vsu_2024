package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.example.enums.Citizenship;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ShipAccountingLog {
    private static final Logger logger = LogManager.getLogger(ShipAccountingLog.class);

    // для каждой страны найти статистику по кораблям, взятым на абордаж
    public Map<Citizenship, Long> statisticsOnShipsBoarded(List<Entry> entryList) {
        logger.info("Вызвана функция statisticsOnShipsBoarded.");
        return entryList.stream()
                .filter(Entry::getIsBoarded)
                .collect(Collectors.groupingBy(Entry::getCitizenship, Collectors.counting()));
    }

    // найти наименьший доходный месяц по золоту
    public YearMonth theLowestProfitableMonthInGold(List<Entry> entryList) {
        logger.info("Вызвана функция theLowestProfitableMonthInGold.");
        // Создаем Map, в котором ключами будут YearMonth,
        // а значениями - суммарное кол-во золота за каждый месяц
        Map<YearMonth, BigDecimal> profitForMonth = entryList.stream()
                .collect(Collectors.groupingBy( // группируем по дате начала месяца
                        entry -> YearMonth.of(entry.getDateRobbery().getYear(),
                                entry.getDateRobbery().getMonth()),
                        Collectors.mapping( // вычисляем суммарное кол-во золота за каждый месяц
                                Entry::getGold,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        // Находим наименьший доходный месяц по золоту
        return profitForMonth.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Нет данных о доходах по золоту за месяц"))
                .getKey();
    }

    // найти корабли, на которых возят самые большие запасы рома (за последние 3 года)
    public List<Entry> theLargestStocksOfRum(List<Entry> entryList) {
        logger.info("Вызвана функция theLargestStocksOfRum");
        Optional<Integer> largestStocks = entryList.stream()
                .map(Entry::getCountBarrelsRum)
                .max(Integer::compare);

        return entryList.stream()
                .filter(entry -> entry.getDateRobbery().isAfter(LocalDate.now().minusYears(3))
                        && entry.getCountBarrelsRum() == largestStocks.get())
                .toList();
    }
}
