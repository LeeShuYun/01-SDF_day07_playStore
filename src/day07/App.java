package day07;

public class App {
    private String name;
    private String category;
    private Integer rating;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "App [name=" + name + ", category=" + category + ", rating=" + rating + "]";
    }

    
}
