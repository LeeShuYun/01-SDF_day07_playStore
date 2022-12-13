package day07;

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

        //we can directly use the buffered reader stream and process it with stream() stuff
        //apparently this works for all stream of data
        List<App> apps = br.lines()
            //skip the header row
            .skip(1) 
            //break up the row into individual cells
            .map(l -> l.split(",")) 
            //hacky way but it chooses the lines where there's no commas in the app name
            .filter(cols -> cols.length <= 14) 
            //removes all entires with NaN in Ratings column 
            .filter(cols -> !cols[2].trim().toLowerCase().equals("nan")) 
            .map(cols -> {
                App app = new App();
                app.setName(cols[0]);
                app.setCategory(cols[1]);
                app.setRating(Float.parseFloat(cols[2]));
                return app;
            })
            .toList(); //outputs the stream to list
        
            br.close();
            fr.close();

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
        //                         // .map(Integer::parseInt) //convert the string
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
