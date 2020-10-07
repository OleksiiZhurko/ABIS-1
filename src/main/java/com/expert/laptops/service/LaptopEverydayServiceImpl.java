package com.expert.laptops.service;

import com.expert.laptops.db.Database;
import com.expert.laptops.dto.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopEverydayServiceImpl extends LaptopService {

    @Autowired
    protected LaptopEverydayServiceImpl(Database database) {
        super(database);
    }

    @Override
    public List<Laptop> makeMatching() {
        return database.getLaptops().stream()
                .filter(element ->
                        element.getCharacteristics().getSizeDisplay() > 12 &&
                                element.getCharacteristics().getSizeDisplay() < 15 &&
                                element.getCharacteristics().getProcessorSpeed() > 1.2 &&
                                element.getCharacteristics().getSizeRAM() > 6 &&
                                element.getCharacteristics().getSizeROM() > 128
                )
                .collect(Collectors.toList());
    }
}
