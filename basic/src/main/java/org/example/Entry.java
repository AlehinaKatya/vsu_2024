package org.example;

import org.example.enums.Citizenship;
import org.example.enums.ShipClass;

import java.time.LocalDate;
import java.util.Objects;
import java.math.BigDecimal;

public class Entry {
    // дата;класс корабля;подданство;сколько золота было получено;
    // сколько бочек рома было получено;был ли взят корабль на абордаж
    private final LocalDate dateRobbery;
    private final ShipClass shipClass;
    private final Citizenship citizenship;
    private final BigDecimal gold;
    private final int countBarrelsRum;
    private final Boolean isBoarded;

    public Entry(LocalDate dateRobbery, ShipClass shipClass,
                 Citizenship citizenship, BigDecimal gold, int countBarrelsRum, Boolean status) {
        this.dateRobbery = dateRobbery;
        this.shipClass = shipClass;
        this.citizenship = citizenship;
        this.gold = gold;
        this.countBarrelsRum = countBarrelsRum;
        this.isBoarded = status;
    }

    public LocalDate getDateRobbery() {
        return dateRobbery;
    }
    public ShipClass getShipClass() {
        return shipClass;
    }
    public Citizenship getCitizenship() {
        return citizenship;
    }
    public BigDecimal getGold() {
        return gold;
    }
    public int getCountBarrelsRum() {
        return countBarrelsRum;
    }
    public Boolean getIsBoarded() {
        return isBoarded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return countBarrelsRum == entry.countBarrelsRum
                && Objects.equals(dateRobbery, entry.dateRobbery)
                && shipClass == entry.shipClass && citizenship == entry.citizenship
                && Objects.equals(gold, entry.gold) && isBoarded == entry.isBoarded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateRobbery, shipClass, citizenship, gold, countBarrelsRum, isBoarded);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "dateRobbery=" + dateRobbery +
                ", shipClass=" + shipClass +
                ", citizenship=" + citizenship +
                ", gold=" + gold +
                ", countBarrelsRum=" + countBarrelsRum +
                ", status=" + isBoarded +
                '}';
    }
}
