import java.util.*;

public class BudgetLogic {
    private List<Product> products;
    private double budget;

    public BudgetLogic(List<Product> products, double budget) {
        this.products = products;
        this.budget = budget;
    }

    public void shop() {
        Collections.sort(products, Comparator.comparingInt(Product::getRating).reversed());

        for (Product product : products) {
            System.out.println("Sorting product: " + product);

            if (product.price > budget) {
                System.out.println("Price exceeds remaining budget. Skipping to the next product.");
                continue;
            }

            System.out.println("Price within budget. Adding product to the selected list.");
            budget -= product.price;
            System.out.println("Remaining budget: " + budget);
        }
    }
    // template of logic i had from other works im just not sure how it all chains up.
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        double initialBudget = 10;

        BudgetLogic BudgetLogic = new BudgetLogic(productList, initialBudget);
        BudgetLogic.shop();
    }
}

class Product {
    String name;
    int rating;
    double price;

    Product(String name, int rating, double price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}