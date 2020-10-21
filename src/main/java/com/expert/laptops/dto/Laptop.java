package com.expert.laptops.dto;

import lombok.*;

import java.util.Collection;
import java.util.stream.DoubleStream;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    private String name;
    private String imgUrl;
    private String urlTo;
    private Double price;
    private Characteristics characteristics;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Characteristics {

        private String os;
        private Double processorSpeed;
        private Integer processorCore;
        private String processorInfo;
        private Double sizeDisplay;
        private String displayInfo;
        private Integer sizeRAM;
        private String RAM;
        private Integer sizeROM;
        private String ROM;
        private String videoMemory;

    }

    @Override
    public String toString() {
        return name + "\n" +
                characteristics.os + "\n" +
                characteristics.processorInfo + characteristics.processorSpeed + "\n" +
                characteristics.videoMemory + "\n" +
                characteristics.sizeDisplay + characteristics.displayInfo + "\n" +
                characteristics.sizeRAM + characteristics.RAM + "\n" +
                characteristics.sizeROM + characteristics.ROM + "\n" +
                price + "\n" +
                imgUrl + "\n" +
                urlTo + "\n";
    }
}
