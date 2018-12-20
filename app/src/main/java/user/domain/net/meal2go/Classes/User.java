package user.domain.net.meal2go.Classes;

public class User {
    private String user_id;
    private String address;
    private String first_name;
    private String last_name;
    private String password;
    private String phone_number;
    private String favorite[];

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    private String order_id;

    public User(String user_id, String address, String first_name, String last_name, String password, String phone_number, String photo, String user_name, String user_type) {
        this.user_id = user_id;
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.phone_number = phone_number;
        this.photo = photo;
        this.user_name = user_name;
        this.user_type = user_type;
    }

    private String photo;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    private String user_name;

    public String getUser_id() {
        return user_id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPhoto() {
        return photo;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_type() {
        return user_type;
    }

    private String user_type;
}
