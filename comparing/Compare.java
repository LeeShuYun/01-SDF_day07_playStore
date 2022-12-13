package comparing;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Compare
 */
public class Compare {

    //find the average rating for each genre
    public static void main (String[] args) throws Exception{
        //read file 
        File file = Paths.get("comparing/googleplaystore.csv").toFile(); 
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        
        //string genre: Int [ rating1, rating 2, ...]
        Map <String, List<Integer>> genreMap = new HashMap<>();
        List<String> ratingList = new LinkedList<>(); //template holds all the ratings for one genre inside

        while((line = br.readLine()) != null){
            String[] entryLine = line.trim().split(",");
            String genre = entryLine[10];
            Float rating = Float.valueOf(entryLine[2]);
            System.out.println(genre); //this should be the genre
            System.out.println(rating);  //this should be the rating

            if (genre.equalsIgnoreCase()){

            }
            //we filter out the ones 
            // while counting how many there are inside each genre.
            
            //grabbing values to add to the list
            // Integer genreRating = genreMap.getOrDefault(genre, ratingList);
        //organise the items
        //write file, passing in the hashmap of genre : average rating
    }
    // Integer averageRating = averaging(ratingList);
    }

    public static void averaging(List<Integer> numList){
        System.out.println("===================== averaging ==================== \n");

        //https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/stream/Collectors.html
        // Optional<Integer> total = numList.stream()
        //                         .map(n -> "%d%d".formatted(n, n))
        //                         // .map(Integer::parseInt)
        //                         .collect(
        //                             Collectors.reducing((0, accumulator, i) -> {
        //                                 System.out.printf("total:%d, i:%d", accumulator, i);
        //                                 return accumulator + i; //acc is the acucmulator
        //                             }));
        //to prevent exception from being thrown, check if we have a valid answer
        // if (opt.isPresent())
        // //if there is an answer we get it
        //     System.out.println(">>> total: "+ accumulator);
        // else 
        //     System.out.println("Reducing produces no answers");
        
        // return total;
    }
}
