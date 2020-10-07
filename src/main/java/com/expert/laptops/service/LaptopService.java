package com.expert.laptops.service;

import com.expert.laptops.db.Database;
import com.expert.laptops.dto.Laptop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LaptopService {

    private final int[] weights = {100, 70, 50, 10};

    protected final Database database;

    protected LaptopService(Database database) {
        this.database = database;
    }

    public List<Laptop> findAll() {
        return database.getLaptops();
    }

    public List<Laptop> sortBetter(List<Laptop> laptops, final Integer[] coeffs) {

        if (laptops.isEmpty()) {
            return laptops;
        }

        return getSortedLaptops(laptops, weights[coeffs[0]], weights[coeffs[1]], weights[coeffs[2]], weights[coeffs[3]]);
    }

    public List<Laptop> sortBetter(List<Laptop> laptops) {

        if (laptops.isEmpty()) {
            return laptops;
        }

        return getSortedLaptops(laptops, weights[0], weights[1], weights[2], weights[3]);
    }

    private List<Laptop> getSortedLaptops(List<Laptop> laptops, int coefRam, int coefProc, int coefRom, int coefPrice) {
        Laptop notebook = laptops.stream()
                .max(Comparator.comparing(laptop ->
                        laptop.getCharacteristics().getProcessorSpeed() * laptop.getCharacteristics().getProcessorCore()))
                .get();

        double maxProcessor = notebook.getCharacteristics().getProcessorSpeed() *
                notebook.getCharacteristics().getProcessorCore();
        double maxRam = laptops.stream()
                .max(Comparator.comparing(laptop -> laptop.getCharacteristics().getSizeRAM()))
                .get()
                .getCharacteristics()
                .getSizeRAM();
        double maxRom = laptops.stream()
                .max(Comparator.comparing(laptop -> laptop.getCharacteristics().getSizeROM()))
                .get()
                .getCharacteristics()
                .getSizeROM();
        double maxPrice = laptops.stream()
                .max(Comparator.comparing(laptop -> laptop.getPrice()))
                .get()
                .getPrice();

        return laptops.stream()
                .sorted((laptop1, laptop2) -> {
                    int compare = Double.compare(
                            (laptop1.getCharacteristics().getSizeRAM() * coefRam / maxRam +
                                    laptop1.getCharacteristics().getProcessorSpeed() *
                                            laptop1.getCharacteristics().getProcessorCore() * coefProc / maxProcessor +
                                    laptop1.getCharacteristics().getSizeROM() * coefRom / maxRom -
                                    laptop1.getPrice() * coefPrice / maxPrice),
                            (laptop2.getCharacteristics().getSizeRAM() * coefRam / maxRam +
                                    laptop2.getCharacteristics().getProcessorSpeed() *
                                            laptop2.getCharacteristics().getProcessorCore() * coefProc / maxProcessor +
                                    laptop2.getCharacteristics().getSizeROM() * coefRom / maxRom -
                                    laptop2.getPrice() * coefPrice / maxPrice)
                    );

                    if (compare == 0) {
                        return laptop1.getName().compareTo(laptop2.getName());
                    } else {
                        return compare == 1 ? -1 : 1;
                    }
                })
                .collect(Collectors.toList());
    }

    public abstract List<Laptop> makeMatching();

}
