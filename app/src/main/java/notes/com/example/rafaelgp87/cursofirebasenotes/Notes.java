package notes.com.example.rafaelgp87.cursofirebasenotes;

/**
 * Created by rgutierrez on 08/02/2018.
 */

public class Notes {
    public String id;
    public String name;
    public int count;

    public Notes () {
        super();
    }

    public Notes (String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
