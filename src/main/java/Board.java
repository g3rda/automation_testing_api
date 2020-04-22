public class Board {
    private String name;
    private String id;
    private String key = "your_key";
    private String token = "your_token";

    public String getKey() {
        return key;
    }

    public String getToken(){
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
