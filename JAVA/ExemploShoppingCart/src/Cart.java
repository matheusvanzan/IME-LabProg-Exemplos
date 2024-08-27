import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products; // Mapa de produtos e suas quantidades

    public Cart() {
        this.products = new HashMap<>();
    }

    // Método para adicionar um produto ao carrinho
    public void addProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            // Se o produto já está no carrinho, aumenta a quantidade
            products.put(product, products.get(product) + quantity);
        } else {
            // Se o produto não está no carrinho, adiciona-o
            products.put(product, quantity);
        }
    }

    // Método para remover um produto do carrinho
    public void removeProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            int currentQuantity = products.get(product);
            if (currentQuantity > quantity) {
                products.put(product, currentQuantity - quantity);
            } else {
                products.remove(product); // Remove o produto se a quantidade é menor ou igual
            }
        }
    }

    // Método para exibir todos os produtos no carrinho
    public void displayCart() {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + ", quantity=" + quantity);
        }
    }

    // Método para calcular o preço total dos produtos no carrinho
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
