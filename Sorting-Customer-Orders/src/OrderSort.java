/*

There are several sorting algorithms, each with its own strengths and weaknesses. Here's a brief overview of the four algorithms mentioned:

1.Bubble Sort: Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

2.Insertion Sort: Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms like quicksort, heapsort, or merge sort.

3.Quick Sort: Quick sort is a divide-and-conquer algorithm that picks an element as a pivot and partitions the given array around the picked pivot. It is one of the most efficient sorting algorithms with an average time complexity of O(n log n).

4.Merge Sort: Merge sort is a divide-and-conquer algorithm that divides the input array into two halves, recursively calls itself for the two halves, and then merges the two sorted halves.


*/



public class OrderSort {

    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

  
    static class BubbleSort {
        public static void sort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    static class QuickSort {
        public static void sort(Order[] orders) {
            quickSort(orders, 0, orders.length - 1);
        }

        private static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);
                quickSort(orders, low, pi - 1);
                quickSort(orders, pi + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() < pivot) {
                    i++;
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }

            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;
            return i + 1;
        }
    }

    public static void main(String[] args) {

        Order[] orders = new Order[] {
            new Order(1, "Customer 1", 100.0),
            new Order(2, "Customer 2", 50.0),
            new Order(3, "Customer 3", 200.0),
            new Order(4, "Customer 4", 150.0),
            new Order(5, "Customer 5", 80.0)
        };

        System.out.println("Original orders:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }

        BubbleSort.sort(orders);
        System.out.println("\nOrders sorted using Bubble Sort:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }

        QuickSort.sort(orders);
        System.out.println("\nOrders sorted using Quick Sort:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
    }
}


/*
Performance (time complexity) of Bubble Sort and Quick Sort:

Bubble Sort: The time complexity is O(n^2), where n is the length of the input array. This is because we have two nested loops that iterate over the array.

Quick Sort: The average time complexity is O(n log n), where n is the length of the input array. This is because we divide the array into two halves at each step and recursively sort them

*/