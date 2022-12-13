package day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadWrite {
    /*
     * reads the file and returns the two categories - 
     * category1 to be sorted by 
     * category2 to be averaged  
     */
    public static List<String> read(String filePath) throws Exception{
        // File file = Paths.get(filePath).toFile(); 
        FileReader fr = new FileReader("googleplaystore.csv");
        BufferedReader br = new BufferedReader(fr);

        List<App> apps = br.lines()
        .skip(1) //skip the header
        .map(l -> l.split(",")) 
        .map(cols -> {
            if (cols.length <= 14)
            return cols;
            cols[1] -> "%s %s".formatted(cols[0], cols[1]);
        })
        .filter(cols -> cols.length <= 14) //filter out the lists with less equal than 14 columns because there's commas in the app name
        .filter(cols -> !cols[2].trim().toLowercase().equals("nan")) //ratings trimmed, lower case, and then compared to nan. removes the NaN entries
        .map(cols -> {
            App app = new App();
            app.setName(cols[0]);
            app.setCategory(cols[1]);
            app.setRating(Float.parseFloat(cols[2]));
            return app;
        })
        .toList();

        br.close();
        fr.close();

        System.out.println(apps);


        //groupingBy are terminal operations   
        Map<String, List<App>> groupByCategory = apps.stream();
        apps.stream()
            .collect(
                Collectors.groupingBy(app -> app.getCategory())
                );

        for (String c: groupByCategory.keySet()){
            //bringoint out only the categories
            // System.out.printf("Categories: %s\n", c);
            //getting the number of entires in each category
            System.out.printf("Categories: %s - %d\n", c, groupByCategory.get(c).size());
        }

        for (App a: groupByCategory.get("EVENTS")){
            System.out.println(a);
        }

        String line;
        
        //string genre: Int total rating
        Map <String, List<String>> genreMap = new HashMap<>();

        while((line = br.readLine()) != null){
            String[] entryLine = line.trim().split(",");
            String genre = entryLine[10];
            Integer rating = Integer.parseInt(entryLine[2]);
            System.out.println(entryLine[10]); //this should be the genre
            System.out.println(entryLine[2]);  //this should be the rating

            //we pick out all of the same genre and then add this to a total 
            // while counting how many there are inside each genre.

            List<String> genresList = new LinkedList<>();
        }

        return finalList;
    }

    public static void write(List<String> genres){
        //outputs genre : avg rating
        System.out.printf("genre: %s Average rating: %d", genre, averageRating);
    }
}
