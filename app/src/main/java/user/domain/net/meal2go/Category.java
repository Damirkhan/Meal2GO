package user.domain.net.meal2go;

public class Category {
    public Category(int count, String category_name, String category_photo) {
        this.count = count;
        this.category_name = category_name;
        this.category_photo = category_photo;
    }

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_photo(String category_photo) {
        this.category_photo = category_photo;
    }

    private String category_name;

    public int getCount() {
        return count;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_photo() {
        return category_photo;
    }

    private String category_photo;
}
