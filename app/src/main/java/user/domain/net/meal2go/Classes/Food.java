package user.domain.net.meal2go.Classes;

public class Food {
    public Food(int food_id, int category_id, String food_caption, double food_cost, String food_name, String food_photo) {
        this.food_id = food_id;
        this.category_id = category_id;
        this.food_caption = food_caption;
        this.food_cost = food_cost;
        this.food_name = food_name;
        this.food_photo = food_photo;
    }



    public int getFood_id() {
        return food_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getFood_caption() {
        return food_caption;
    }

    public double getFood_cost() {
        return food_cost;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getFood_photo() {
        return food_photo;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setFood_caption(String food_caption) {
        this.food_caption = food_caption;
    }

    public void setFood_cost(double food_cost) {
        this.food_cost = food_cost;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public void setFood_photo(String food_photo) {
        this.food_photo = food_photo;
    }

    private int food_id;
    private int category_id;
    private String food_caption;
    private double food_cost;
    private String food_name;
    private String food_photo;
}
