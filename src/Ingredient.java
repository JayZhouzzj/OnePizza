import java.util.Objects;

public class Ingredient {
    String name;
    int likes;
    int dislikes;

    public Ingredient(String name) {
        this.name = name;
        likes = 0;
        dislikes = 0;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
