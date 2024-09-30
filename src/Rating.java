public class Rating {
    private int rating;
    
    /**
     * @pre 1 <= initRating <= 5
     */
    public Rating(int initRating) {
        this.rating = initRating;
    }

    public int getRating(){
        return rating;
    }
}
