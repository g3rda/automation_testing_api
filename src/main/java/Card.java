import java.util.Date;
import java.util.Scanner;

public class Card {
    private String name;
    private String id;
    private String desc;
    private String idList;
    private Date due;
    private String idBoard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {this.desc = desc;}

    public void setIdList(String listId) { idList = listId; }

    public void setDue(Date due) { this.due = due; }

    public String getId() { return id; }

    Card(String name, String desc, String idList){
        this.name = name;
        this.idList = idList;
        this.desc = desc;
    }
    Card(String name, String desc, String idCard, String idList){
        this.name = name;
        this.desc = desc;
        this.idList = idList;
        this.id = idCard;
    }

    Card(String idCard){
        this.id = idCard;
    }

    public void getInfo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Here is some info about the card: \nname: "+name+"\ndescription: "
                +desc+"\ndate: "+due+"\ncard id: "+id+"\nlist id: "+idList+"\nboard id: "+idBoard);
    }
}
