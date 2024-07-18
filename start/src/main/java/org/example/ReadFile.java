package org.example;

import org.example.enums.Citizenship;
import org.example.enums.ShipClass;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    public List<Entry> readEntriesFromFile(Path path) {
        List<Entry> entries;

        try(Stream<String> streamFromFiles = Files.lines(path)) {
            entries = streamFromFiles
                    .map(line -> line.split(";"))
                    .map(parts -> {
                        LocalDate dateRobbery = LocalDate.parse(parts[0]);
                        ShipClass shipClass = ShipClass.fromString(parts[1]);
                        Citizenship citizenship = Citizenship.fromString(parts[2]);
                        BigDecimal gold = new BigDecimal(parts[3]);
                        int countBarrelsRum = Integer.parseInt(parts[4]);
                        Boolean isBoarded = Boolean.parseBoolean(parts[5]);

                        return new Entry(dateRobbery, shipClass, citizenship, gold, countBarrelsRum, isBoarded);
                    })
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entries;
    }
}
