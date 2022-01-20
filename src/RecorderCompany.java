import java.util.ArrayList;

public class RecorderCompany {
    int id;
    private String name;

    public RecorderCompany(int id,String name){
        this.name=name;
        this.id=id;
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

    public String toString(){
        return "name: "+name+" id:"+id;
    }
}
