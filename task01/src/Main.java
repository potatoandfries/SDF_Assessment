package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static final int COL_NAME = 0;
    public static final int COL_CATEGORY = 1;
    public static final int COL_RATING = 2;

    public static void main(String[] args) throws Exception {
   
        System.out.printf("Processing file: %s\n");

            FileReader in = new FileReader("C:\\Users\\orbis\\SDF\\Test\\task01\\googleplaystore.csv");
            BufferedReader br = new BufferedReader(in);
            // This prevents you from calling the br.readline command twice. :3

            br.readLine(); 

            Map<String, List<Organiser>> classified = br.lines()
            .skip(1)
            .map(row -> row.trim().split(","))
            .map(fields -> new Organiser(fields[COL_NAME], fields[COL_CATEGORY], Double.parseDouble(fields[COL_RATING])))
            // i made it into a tree map for it to be case insensitive
            .collect(Collectors.groupingBy(Organiser::getName, TreeMap::new, Collectors.toList()));


            for (String Category : classified.keySet()) {
                List<Organiser> organisers = classified.get(Category);
                        //get lowest rating
                Double lowestRating = organisers.stream()
                        .map(Organiser::getRating)
                        .min(Double::compareTo)
                        .orElse(null);
                        //get highest rating
                Double highestRating = organisers.stream()
                        .map(Organiser::getRating)
                        .max(Double::compareTo)
                        .orElse(null);
                        //get average
                Double averageRating = organisers.stream()
                        .map(Organiser::getRating)
                        .collect(Collectors.averagingDouble(node -> node.map.getOrDefault("age", 0D))) ;
                System.out.printf("%s (%d) - Lowest Rating: %d, Highest Rating: %d\n", Category, organisers.size(), lowestRating, highestRating, averageRating);

                for (Organiser organiser : organisers) {
                    System.out.printf("\t%s\n", organiser.getCategory());
                }
            }
        }
    }

