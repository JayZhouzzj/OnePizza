import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] inputFiles = {"a_an_example.in.txt", "b_basic.in.txt", "c_coarse.in.txt",
                "d_difficult.in.txt", "e_elaborate.in.txt"};
        Scanner kb = new Scanner(System.in);
        int fileIndex = kb.nextInt();

        String file = "input_data/" + inputFiles[fileIndex];

        Map<String, Ingredient> ingredients = new HashMap<>();
        List<Client> clients = readFile(file, ingredients);

        System.out.println(ingredients.size());

        //algo
        Set<Ingredient> result = new HashSet<>();
        for (Ingredient ingredient : ingredients.values()) {
            if(ingredient.dislikes < ingredient.likes) {
                result.add(ingredient);
            }
        }


        String outputName = "out" + fileIndex;
        File outputFile = new File("output/" + outputName);
        PrintWriter output = new PrintWriter(outputFile);

        StringBuilder toPrint = new StringBuilder(result.size() + "");
        for (Ingredient ingredient : result) {
            toPrint.append(" ").append(ingredient.name);
        }
        output.println(toPrint);
        output.close();
    }

    public static List<Client> readFile(String fileName, Map<String, Ingredient> ingredients) throws FileNotFoundException {
        Scanner fileInput = new Scanner(new File(fileName));

        int clientCount = fileInput.nextInt();
        List<Client> result = new ArrayList<Client>(clientCount);
        for (int i = 0; i < clientCount; i++) {
            Client newClient = new Client(i);

            int likes = fileInput.nextInt();
            for (int j = 0; j < likes; j++) {
                String ingredientName = fileInput.next();
                if (!ingredients.containsKey(ingredientName)) {
                    ingredients.put(ingredientName, new Ingredient(ingredientName));
                }
                Ingredient currIngredient = ingredients.get(ingredientName);
                currIngredient.likes ++;
                newClient.likes.add(ingredients.get(ingredientName));
            }

            int dislikes = fileInput.nextInt();
            for (int j = 0; j < dislikes; j++) {
                String ingredientName = fileInput.next();
                if (!ingredients.containsKey(ingredientName)) {
                    ingredients.put(ingredientName, new Ingredient(ingredientName));
                }
                Ingredient currIngredient = ingredients.get(ingredientName);
                currIngredient.dislikes ++;
                newClient.dislikes.add(ingredients.get(ingredientName));
            }

            result.add(newClient);
        }
        fileInput.close();

        return result;
    }
}
