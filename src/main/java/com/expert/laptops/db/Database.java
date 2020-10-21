package com.expert.laptops.db;

import com.expert.laptops.dto.Laptop;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Database {

    private List<Laptop> laptops = new ArrayList<>();

    public List<Laptop> getLaptops() {
        return laptops;
    }

    private void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @PostConstruct
    protected void produceDatabase() {
        laptops.addAll(List.of(
                Laptop.builder()
                        .name("Acer Chromebook 311 - CB311-9H-C12A")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-311-cb311-9h-9ht-main.png")
                        .urlTo("https://store.acer.com/en-us/laptops/acer-chromebook-311-cb311-9h-c12a")
                        .price(219.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(11.6)
                                        .displayInfo("11.6\" HD (1366 x 768) 16:9 IPS")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(32)
                                        .ROM("32 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Chromebook 314 - CB314-1H-C66Z")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-314-cb314-1h-1ht-main_2.png")
                        .urlTo("https://store.acer.com/en-us/laptops/chromebook-314-cb314-1h-c66z")
                        .price(229.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(14.0)
                                        .displayInfo("14\" HD (1366 x 786) 16:9 display")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 with shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(32)
                                        .ROM("32 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Chromebook 314 - CB314-1H-C34N")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-314-cb314-1h-1ht-main.png")
                        .urlTo("https://store.acer.com/en-us/laptops/chromebook-314-cb314-1h-c34n")
                        .price(249.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(14.0)
                                        .displayInfo("14\" HD (1366 x 786) 16:9")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(64)
                                        .ROM("64 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Acer Chromebook 311 Touch - CB311-9HT-C4UM")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-311-cb311-9h-9ht-main_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/acer-chromebook-311-cb311-9ht-c4um")
                        .price(259.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(11.6)
                                        .displayInfo("11.6\" HD (1366 x 768) 16:9 IPS Touchscreen")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(32)
                                        .ROM("32 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Chromebook 315 - CB315-3H-C4QE")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-315-cb315-3h-3ht-main.png")
                        .urlTo("https://store.acer.com/en-us/laptops/chromebook-315-cb315-3h-c4qe")
                        .price(259.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" HD (1366 x 768) 16:9")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(64)
                                        .ROM("64 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Acer Chromebook 314 - CB314-1HT-C7C0")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-314-cb314-1h-1ht-main_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/acer-chromebook-314-cb314-1ht-c7c0")
                        .price(279.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(14.0)
                                        .displayInfo("14\" HD (1366 x 786) 16:9")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4")
                                        .sizeROM(64)
                                        .ROM("64 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Acer Chromebook 315 - CB315-3HT-C296")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-315-cb315-3h-3ht-main_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/acer-chromebook-315-cb315-3ht-c296")
                        .price(299.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9, IPS display")
                                        .processorSpeed(1.10)
                                        .processorCore(2)
                                        .processorInfo("Intel® Celeron® N4000 processor Dual-core 1.10 GHz")
                                        .videoMemory("Intel® UHD Graphics 600 shared memory")
                                        .sizeRAM(4)
                                        .RAM("4 GB, LPDDR4 standard memory")
                                        .sizeROM(32)
                                        .ROM("32 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Aspire 3 Laptop - A315-55G-59LS")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-aspire-3-a315-55-55k-blue-main_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/aspire-3-laptop-a315-55g-59ls")
                        .price(619.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(1.60)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-10210U processor Quad-core 1.60 GHz")
                                        .videoMemory("NVIDIA® GeForce® MX230 with 2 GB dedicated memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, DDR4 SDRAM")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Swift 3 Laptop - SF314-42-R7LH")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-swift-3-sf314-55-sf314-55g-main_1_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/swift-3-laptop-sf314-42-r7lh")
                        .price(629.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(14.0)
                                        .displayInfo("14\" Full HD (1920 x 1080) 16:9 IPS")
                                        .processorSpeed(2.30)
                                        .processorCore(6)
                                        .processorInfo("AMD Ryzen 5 4500U processor Hexa-core 2.30 GHz")
                                        .videoMemory("AMD Radeon™ shared memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, LPDDR4")
                                        .sizeROM(256)
                                        .ROM("256 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Swift 3 Laptop - SF314-57-59EY")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-swift-3-sf314-57-gray-main.png")
                        .urlTo("https://store.acer.com/en-us/laptops/swift-3-laptop-sf314-57-59ey")
                        .price(679.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(14.0)
                                        .displayInfo("14\" Full HD (1920 x 1080) 16:9 IPS")
                                        .processorSpeed(1.0)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-1035G1 processor Quad-core 1 GHz")
                                        .videoMemory("Intel® UHD Graphics shared memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, LPDDR4")
                                        .sizeROM(256)
                                        .ROM("256 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Aspire 7 Notebook - A715-41G-R7X4")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/s/aspire-7-a715-75g-41g-black-modelmain.png")
                        .urlTo("https://store.acer.com/en-us/laptops/aspire-7-notebook-a715-41g-r7x4")
                        .price(749.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(2.10)
                                        .processorCore(4)
                                        .processorInfo("AMD Ryzen 5 3550H processor Quad-core 2.10 GHz")
                                        .videoMemory("NVIDIA® GeForce® GTX 1650 with 4 GB dedicated memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, DDR4 SDRAM")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Aspire 7 Laptop - A715-75G-544V")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/s/aspire-7-a715-75g-41g-black-modelmain_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/aspire-7-laptop-a715-75g-544v")
                        .price(799.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(2.40)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-9300H processor Quad-core 2.40 GHz")
                                        .videoMemory("NVIDIA® GeForce® GTX 1650 with 4 GB dedicated memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, DDR4 SDRAM")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Swift 3 Laptop - SF313-52-52VA")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/s/w/swift3-sf313-52-52g-silver-modelmain-athena.png")
                        .urlTo("https://store.acer.com/en-us/laptops/swift-3-laptop-sf313-52-52va")
                        .price(799.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(13.5)
                                        .displayInfo("13.5\" 2K (2256 x 1504) 3:2, IPS CineCrystal")
                                        .processorSpeed(1.10)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-1035G4 processor Quad-core 1.10 GHz")
                                        .videoMemory("Intel® Iris Plus Graphics shared memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, LPDDR4")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Spin 5 Laptop - SP513-52N-52PL")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/s/p/spin-5-sp513_alexa_main.png")
                        .urlTo("https://store.acer.com/en-us/laptops/spin-5-laptop-sp513-52n-52pl")
                        .price(799.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(13.3)
                                        .displayInfo("13.3\" Full HD (1920 x 1080) 16:9 IPS")
                                        .processorSpeed(1.60)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-8250U processor Quad-core 1.60 GHz")
                                        .videoMemory("Intel® UHD Graphics 620 with Shared Memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, DDR4 SDRAM")
                                        .sizeROM(256)
                                        .ROM("256 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Nitro 5 Gaming Laptop - AN515-55-54Q0")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-nitro-5_an515-55_modelmain_1.png")
                        .urlTo("https://store.acer.com/en-us/nitro-5-gaming-laptop-an515-55-54q0")
                        .price(899.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(2.50)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-10300H processor Quad-core 2.50 GHz")
                                        .videoMemory("NVIDIA® GeForce® GTX 1650Ti with 4 GB")
                                        .sizeRAM(16)
                                        .RAM("16 GB, DDR4 SDRAM")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Acer Chromebook Spin 13 - CP713-1WN-51EA")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-chromebook-spin-13-cp713-1wn-main_3.png")
                        .urlTo("https://store.acer.com/en-us/laptops/acer-chromebook-spin-13-cp713-1wn-51ea")
                        .price(929.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Chrome OS")
                                        .sizeDisplay(13.5)
                                        .displayInfo("13.5\" (2256 x 1504) 3:2 IPS Touchscreen")
                                        .processorSpeed(1.70)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-8350U processor Quad-core 1.70 GHz")
                                        .videoMemory("Intel® UHD Graphics 620 shared memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, LPDDR3")
                                        .sizeROM(64)
                                        .ROM("64 GB Flash Memory")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Nitro 7 Gaming Laptop - AN715-52-715S")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-nitro-7_an715-52_rgb-kb_modelmain.png")
                        .urlTo("https://store.acer.com/en-us/laptops/nitro-7-gaming-laptop-an715-52-715s")
                        .price(999.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(2.60)
                                        .processorCore(6)
                                        .processorInfo("Intel® Core™ i7-10750H processor Hexa-core 2.60 GHz")
                                        .videoMemory("NVIDIA® GeForce® GTX 1660Ti with 6 GB dedicated memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, DDR4 SDRAM")
                                        .sizeROM(256)
                                        .ROM("256 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Nitro 5 Gaming Laptop - AN515-54-547D")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-nitro-5-an515-54-main_7.png")
                        .urlTo("https://store.acer.com/en-us/laptops/nitro-5-gaming-laptop-an515-54-547d")
                        .price(999.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(2.40)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i5-9300H processor Quad-core 2.40 GHz")
                                        .videoMemory("NVIDIA® GeForce® GTX 1660Ti with 6 GB dedicated memory")
                                        .sizeRAM(16)
                                        .RAM("16 GB, DDR4 SDRAM")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build(),
                Laptop.builder()
                        .name("Swift 5 Laptop - SF514-54T-76PY")
                        .imgUrl("https://static-ecpa.acer.com/media/catalog/product/cache/7645a9d936c7fcb584614a3e98291904/a/c/acer-swift-5-sf514-54-blue-main_1.png")
                        .urlTo("https://store.acer.com/en-us/laptops/swift-5-laptop-sf514-54t-76py")
                        .price(999.99)
                        .characteristics(
                                Laptop.Characteristics.builder()
                                        .os("Windows 10 Home")
                                        .sizeDisplay(15.6)
                                        .displayInfo("15.6\" Full HD (1920 x 1080) 16:9")
                                        .processorSpeed(1.30)
                                        .processorCore(4)
                                        .processorInfo("Intel® Core™ i7-1065G7 Quad-core 1.30 GHz")
                                        .videoMemory("Intel® Iris Plus Graphics G7 shared memory")
                                        .sizeRAM(8)
                                        .RAM("8 GB, LPDDR4")
                                        .sizeROM(512)
                                        .ROM("512 GB SSD")
                                        .build()
                        )
                        .build()
                )
        );
    }

//    @PostConstruct
//    protected void produceDatabase() throws IOException {
//        Elements els = Jsoup.connect("https://store.acer.com/en-us/laptops?p=1&product_list_limit=20").get()
//                .getElementById("paging-label").parent().child(1).children();
//
//        int num = Integer.parseInt(els.get(els.size() - 2).child(0).child(1).text());
//
//        Elements elements = new Elements();
//
//        for (int i = 1; i <= num; i++) {
//            elements.addAll(
//                    Jsoup.connect(
//                            String.format("https://store.acer.com/en-us/laptops?p=%s&product_list_limit=20", i)
//                    ).get().getElementsByClass("item product product-item"));
//        }
//
//        List<Laptop> laptopList = new ArrayList<>();
//
//        elements.forEach(element -> {
//            Elements el = element.getElementsByClass("product_specifications_list").get(0).child(0).children();
//
//            if (el.size() == 6) {
//                String processor = el.get(1).text();
//                String display = el.get(3).text();
//                String rom = el.get(4).text();
//                String ram = el.get(5).text();
//                String price = element.getElementsByClass("price").text();
//
//                Integer itn = ram.contains("TB") ?
//                        Integer.parseInt(ram.substring(0, ram.indexOf(' ')) + "000") :
//                        Integer.parseInt(ram.substring(0, ram.indexOf(' ')));
//
//                Integer n = processor.contains("Deca") ? 10 :
//                        processor.contains("Octa") ? 8 :
//                                processor.contains("Hexa") ? 6 :
//                                        processor.contains("Quad") ? 4 : 2;
//
//                if (display.indexOf('"') != -1) { // crutch 'cause mistake on the website
//                    laptopList.add(
//                            Laptop.builder()
//                                    .name(element.getElementsByClass("product-item-link").text())
//                                    .imgUrl(element.getElementsByClass("product-image-photo").attr("src"))
//                                    .urlTo(element.getElementsByClass("action primary button goto-product").attr("href"))
//                                    .price(Double.parseDouble(price.substring(1, price.indexOf(' ')).replaceAll(",", "")))
//                                    .characteristics(
//                                            Laptop.Characteristics.builder()
//                                                    .os(el.get(0).text())
//                                                    .sizeDisplay(Double.parseDouble(display.substring(0, display.indexOf('"'))))
//                                                    .displayInfo(display.substring(display.indexOf('"')))
//                                                    .processorSpeed(Double.parseDouble(processor.substring(processor.indexOf("core") + 5, processor.lastIndexOf(' '))))
//                                                    .processorCore(n)
//                                                    .processorInfo(processor.substring(0, processor.indexOf("core") + 5))
//                                                    .videoMemory(el.get(2).text())
//                                                    .sizeRAM(Integer.parseInt(rom.substring(0, rom.indexOf(' '))))
//                                                    .RAM(rom.substring(rom.indexOf(',')))
//                                                    .sizeROM(itn)
//                                                    .ROM(ram.substring(ram.indexOf('B') + 1))
//                                                    .build()
//                                    )
//                                    .build()
//                    );
//                }
//            }
//        });
//
//        setLaptops(laptopList);
//    }

}
