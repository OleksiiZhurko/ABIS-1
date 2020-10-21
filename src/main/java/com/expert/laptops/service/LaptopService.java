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

    public List<Laptop> sortBetter(List<Laptop> laptops, final Integer[] keys) {

        if (laptops.isEmpty()) {
            return laptops;
        }

        return getSortedLaptops(laptops, weights[keys[0]], weights[keys[1]], weights[keys[2]], weights[keys[3]]);
    }

    public List<Laptop> sortBetter(List<Laptop> laptops) {

        if (laptops.isEmpty()) {
            return laptops;
        }

        return getSortedLaptops(laptops, weights[0], weights[1], weights[2], weights[3]);
    }

    private List<Laptop> getSortedLaptops(List<Laptop> laptops, int kRam, int kProc, int kRom, int kPrice) {
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
                            (laptop1.getCharacteristics().getSizeRAM() * kRam / maxRam +
                                    laptop1.getCharacteristics().getProcessorSpeed() *
                                            laptop1.getCharacteristics().getProcessorCore() * kProc / maxProcessor +
                                    laptop1.getCharacteristics().getSizeROM() * kRom / maxRom -
                                    laptop1.getPrice() * kPrice / maxPrice),
                            (laptop2.getCharacteristics().getSizeRAM() * kRam / maxRam +
                                    laptop2.getCharacteristics().getProcessorSpeed() *
                                            laptop2.getCharacteristics().getProcessorCore() * kProc / maxProcessor +
                                    laptop2.getCharacteristics().getSizeROM() * kRom / maxRom -
                                    laptop2.getPrice() * kPrice / maxPrice)
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
