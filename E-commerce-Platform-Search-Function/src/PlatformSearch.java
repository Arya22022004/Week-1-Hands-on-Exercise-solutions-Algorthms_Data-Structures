/*Big O notation is a way to measure the time and space complexity of an algorithm. It describes the upper bound of the complexity in the 
worst-case scenario. Big O notation helps us analyze algorithms by giving us an idea of how the running time or space requirements grow as the 
input size increases.

In the context of search operations, we have three scenarios:

Best-case scenario: The search operation finds the target element at the first position it checks.
Average-case scenario: The search operation finds the target element after checking a certain number of positions on average. 
Worst-case scenario: The search operation checks all possible positions before finding the target element or determining that it's not present. 
*/
import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class PlatformSearch{

    public static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String target) {
        Arrays.sort(products, (p1, p2) -> p1.productName.compareTo(p2.productName));
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productName.equals(target)) {
                return mid;
            } else if (products[mid].productName.compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[] {
                new Product(1, "Product A", "Category 1"),
                new Product(2, "Product B", "Category 2"),
                new Product(3, "Product C", "Category 3"),
                
        };

        String target = "Product B";

        int linearSearchResult = linearSearch(products, target);
        if (linearSearchResult!= -1) {
            System.out.println("Linear search found product at index " + linearSearchResult);
        } else {
            System.out.println("Linear search did not find product");
        }

        int binarySearchResult = binarySearch(products, target);
        if (binarySearchResult!= -1) {
            System.out.println("Binary search found product at index " + binarySearchResult);
        } else {
            System.out.println("Binary search did not find product");
        }
    }
}

/*

Linear Search: The time complexity is O(n), where n is the length of the input array. This is because we check each element in the array once.

Binary Search: The time complexity is O(log n), where n is the length of the input array. This is because we divide the search space in half at 
each step. 


*/
