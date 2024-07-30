/*
Linked Lists: 
1. Singly Linked List: Each node only contains a reference to the next node in the list.
2. Doubly Linked List: Each node contains references to both the previous and next nodes in the list. 

*/



public class TaskManagementSystem {
    private TaskNode head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }

    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.getTask().getTaskId() + ", Task Name: " + current.getTask().getTaskName() + ", Status: " + current.getTask().getStatus());
            current = current.getNext();
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return;
        }
        TaskNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTask().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(new Task(1, "Task 1", "In Progress"));
        tms.addTask(new Task(2, "Task 2", "Completed"));
        tms.addTask(new Task(3, "Task 3", "Pending"));

        System.out.println("Tasks:");
        tms.traverseTasks();

        Task task = tms.searchTask(2);
        if (task != null) {
            System.out.println("Task found: " + task.getTaskName());
        } else {
            System.out.println("Task not found");
        }

        tms.deleteTask(2);

        System.out.println("Tasks after deletion:");
        tms.traverseTasks();
    }
}

/*

Time Complexity:
1. Add Task: O(n), where n is the number of tasks in the list.
2. Search Task: O(n), where n is the number of tasks in the list.
3. Traverse Tasks: O(n), where n is the number of tasks in the list.
4. Delete Task: O(n), where n is the number of tasks in the list.

Advantages of Linked Lists over Arrays:
1. Dynamic data: Linked lists can efficiently handle dynamic data, where elements are frequently added or deleted.
2. Efficient insertion and deletion



 */