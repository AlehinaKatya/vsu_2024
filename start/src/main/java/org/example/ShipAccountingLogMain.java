package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Капитан Френсис Дрейк ведет учет ограбленных кораблей, записывая в файл информацию в следующем формате:
// дата;класс корабля;подданство;сколько золота было получено;сколько бочек рома было получено;был ли взят корабль на абордаж
// Необходимо вывести следующую информацию
// - для каждой страны найти статистику по кораблям, взятым на абордаж
// - найти наименее доходный месяц по золоту
// - корабли, на которых возят самые большие запасы рома (за последние 3 года)

public class ShipAccountingLogMain {

    private static final Logger logger = LogManager.getLogger(ShipAccountingLogMain.class);

    public static void main(String[] args) {
        logger.info("Начало работы программы.");
        PrintShipLog printShipLog = new PrintShipLog();
        printShipLog.printStatisticsOnShipsBoarded();
        printShipLog.printTheLowestProfitableMonthInGold();
        printShipLog.printTheLargestStocksOfRum();
        logger.info("Конец работы программы.");
    }
}