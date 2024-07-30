import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}


class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    
    public void addProduct(Product product) {
        products.put(product.productId, product);
        System.out.println("Product added successfully!");
    }

  
    public void updateProduct(int productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

   
    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}

public class inventorymanagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = sc.nextInt();
                    System.out.print("Enter product name: ");
                    String productName = sc.next();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Product product = new Product(productId, productName, quantity, price);
                    inventory.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int updateProductId = sc.nextInt();
                    System.out.print("Enter new product name: ");
                    String updateProductName = sc.next();
                    System.out.print("Enter new quantity: ");
                    int updateQuantity = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double updatePrice = sc.nextDouble();

                    Product updatedProduct = new Product(updateProductId, updateProductName, updateQuantity, updatePrice);
                    inventory.updateProduct(updateProductId, updatedProduct);
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    int deleteProductId = sc.nextInt();
                    inventory.deleteProduct(deleteProductId);
                    break;
                case 4:
                    inventory.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

