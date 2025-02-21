import java.util.Objects;

public class Product {
    private String productId;    // ID do produto
    private String name;         // Nome do produto
    private double price;        // Preço do produto

    // Construtor
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Método toString para retornar uma representação em string do objeto
    @Override
    public String toString() {
        return "Product{id='" + productId + "', name='" + name + "', price=" + price + '}';
    }

    // Método hashCode para gerar um código hash para o objeto
    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    // Método equals para verificar a igualdade entre dois objetos com base no productId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(productId, product.productId);
    }
}
