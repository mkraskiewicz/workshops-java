package jug.lodz.workshop.javafp.fp2.answers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by pwlodarski on 2016-03-09.
 */
public class ImperativeLoop2Answer {

    static Consumer<String> logger = LoggerModuleAnswer.defaultLogger;
    //lab
    static List<String> whichProductPurchasedTheMost(){
        try{
            List<String> lines=Files.readAllLines(
                    Paths.get(
                            ClassLoader.getSystemResource("fpjava/purchases.csv").toURI()
                    )
            );

            lines.remove(0); //header

            Map<String,Integer> counts=new HashMap<>();

            for (String line : lines) {
                String[] fields = line.split(",");
                String user=fields[1];
                counts.compute(user, (k,v)-> v==null? 1 : v+1);
            }

            return counts.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }

    }

    //additional
    static List<String> dateWhenMostProductsWasPurchased(){
        try{
            List<String> lines=Files.readAllLines(
                    Paths.get(
                            ClassLoader.getSystemResource("fpjava/purchases.csv").toURI()
                    )
            );

            lines.remove(0); //header

            Map<String,Integer> counts=new HashMap<>();

            for (String line : lines) {
                String[] fields = line.split(",");
                String user=fields[3];
                counts.compute(user, (k,v)-> v==null? 1 : v+1);
            }

            return counts.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }



    static List<String> usersWhoPurchasedMostProducts(){
        try{
            List<String> lines=Files.readAllLines(
                    Paths.get(
                            ClassLoader.getSystemResource("fpjava/purchases.csv").toURI()
                    )
            );

            lines.remove(0); //header

            Map<String,Integer> counts=new HashMap<>();

            for (String line : lines) {
                String[] fields = line.split(",");
                String user=fields[0];
                counts.compute(user, (k,v)-> v==null? 1 : v+1);
            }

            return counts.entrySet().stream()
                    .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                    .map(entry -> entry.getKey() + ":" + entry.getValue())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public static void main(String[] args){
        dateWhenMostProductsWasPurchased().forEach(logger);
    }
}
