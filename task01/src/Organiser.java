package src;

public class Organiser {
    private String Name;
    private String Category;
    private Double Rating;

    public Organiser(String Name, String Category, Double Rating) {
        this.Name = Name;
        this.Category = Category;
        this.Rating = Rating;}

    public String getName() {return Name;}
    public void setName(String Name) {this.Name = Name;}

    public String getCategory() {return Category;}
    public void setCategory(String Category) {this.Category = Category;}

    public Double getRating() {return Rating;}
    public void setRating(Double Rating) {this.Rating = Rating;}
}
