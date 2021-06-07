package stepDefs.ApiTests.pojos;

public class VideoGame {

    // POJO - regular encapsulated java class with private variables and public getters and setters and constructor

    private int id;
    private String name;
    private String releaseDate;
    private int reviewScore;
    private String category;
    private String rating;

    public VideoGame(int id, String name, String releaseDate, int reviewScore, String category, String rating) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.reviewScore = reviewScore;
        this.category = category;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", reviewScore=" + reviewScore +
                ", category='" + category + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
