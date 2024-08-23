public class App {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Product product1 = new Product("P001", "Laptop", 1500.0);
        Product product2 = new Product("P002", "Smartphone", 800.0);
        Product product3 = new Product("P001", "Laptop", 1500.0); // Mesmo ID que product1

        // Adiciona produtos ao carrinho
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
        cart.addProduct(product3, 1); // Deve incrementar a quantidade de "Laptop"

        // Exibe o conteúdo do carrinho
        cart.displayCart();

        // Calcula e exibe o preço total do carrinho
        System.out.println("Total Price: " + cart.calculateTotalPrice());

        // Remove um produto do carrinho
        cart.removeProduct(product2, 1); // Remove uma unidade de "Smartphone"
        cart.displayCart();
        System.out.println("Total Price after removal: " + cart.calculateTotalPrice());
    }
}
