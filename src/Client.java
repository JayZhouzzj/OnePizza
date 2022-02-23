import java.util.ArrayList;
import java.util.List;

public class Client {
    List<Ingredient> likes;
    List<Ingredient> dislikes;
    int index;

    public Client(int index) {
        this.likes = new ArrayList<>();
        this.dislikes = new ArrayList<>();
        this.index = index;
    }
}
