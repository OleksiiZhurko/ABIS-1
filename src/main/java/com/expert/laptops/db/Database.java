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
    protected void produceDatabase() throws IOException {

        Elements els = Jsoup.connect("https://store.acer.com/en-us/laptops?p=1&product_list_limit=20").get()
                .getElementById("paging-label").parent().child(1).children();

        int num = Integer.parseInt(els.get(els.size() - 2).child(0).child(1).text());

        Elements elements = new Elements();

        for (int i = 1; i <= num; i++) {
            elements.addAll(
                    Jsoup.connect(
                            String.format("https://store.acer.com/en-us/laptops?p=%s&product_list_limit=20", i)
                    ).get().getElementsByClass("item product product-item"));
        }

        List<Laptop> laptopList = new ArrayList<>();

        elements.forEach(element -> {
            Elements el = element.getElementsByClass("product_specifications_list").get(0).child(0).children();

            if (el.size() == 6) {
                String processor = el.get(1).text();
                String display = el.get(3).text();
                String rom = el.get(4).text();
                String ram = el.get(5).text();
                String price = element.getElementsByClass("price").text();

                Integer itn = ram.contains("TB") ?
                        Integer.parseInt(ram.substring(0, ram.indexOf(' ')) + "000") :
                        Integer.parseInt(ram.substring(0, ram.indexOf(' ')));

                Integer n = processor.contains("Deca") ? 10 :
                        processor.contains("Octa") ? 8 :
                                processor.contains("Hexa") ? 6 :
                                        processor.contains("Quad") ? 4 : 2;

                if (display.indexOf('"') != -1) { // crutch 'cause mistake on the website
                    laptopList.add(
                            Laptop.builder()
                                    .name(element.getElementsByClass("product-item-link").text())
                                    .imgUrl(element.getElementsByClass("product-image-photo").attr("src"))
                                    .urlTo(element.getElementsByClass("action primary button goto-product").attr("href"))
                                    .price(Double.parseDouble(price.substring(1, price.indexOf(' ')).replaceAll(",", "")))
                                    .characteristics(
                                            Laptop.Characteristics.builder()
                                                    .os(el.get(0).text())
                                                    .sizeDisplay(Double.parseDouble(display.substring(0, display.indexOf('"'))))
                                                    .displayInfo(display.substring(display.indexOf('"')))
                                                    .processorSpeed(Double.parseDouble(processor.substring(processor.indexOf("core") + 5, processor.lastIndexOf(' '))))
                                                    .processorCore(n)
                                                    .processorInfo(processor.substring(0, processor.indexOf("core") + 5))
                                                    .videoMemory(el.get(2).text())
                                                    .sizeRAM(Integer.parseInt(rom.substring(0, rom.indexOf(' '))))
                                                    .RAM(rom.substring(rom.indexOf(',')))
                                                    .sizeROM(itn)
                                                    .ROM(ram.substring(ram.indexOf('B') + 1))
                                                    .build()
                                    )
                                    .build()
                    );
                }
            }
        });

        setLaptops(laptopList);

    }

}
