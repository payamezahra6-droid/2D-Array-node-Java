public class TwoDArray {

    Node head;
    int rows;
    int columns;

    TwoDArray() {
        head = null;
        rows = 0;
        columns = 0;
    }

    // Add a row
    public void addRow(int a, int b, int c) {

        Node n1 = new Node(a);
        Node n2 = new Node(b);
        Node n3 = new Node(c);

        // Connect nodes of the new row
        n1.right = n2;
        n2.right = n3;

        // If 2D structure is empty
        if (head == null) {
            head = n1;
            rows = 1;
            columns = 3;
            return;
        }

        // Go to the last row
        Node currentRow = head;

        while (currentRow.down != null) {
            currentRow = currentRow.down;
        }

        // Connect new row with the previous row
        Node oldNode = currentRow;
        Node newNode = n1;

        while (oldNode != null && newNode != null) {

            oldNode.down = newNode;

            oldNode = oldNode.right;
            newNode = newNode.right;
        }

        rows++;
    }


    // Add a column
    public void addColumn(int a, int b, int c) {

        Node n1 = new Node(a);
        Node n2 = new Node(b);
        Node n3 = new Node(c);

        // Connect nodes of the new column
        n1.down = n2;
        n2.down = n3;

        // If 2D structure is empty
        if (head == null) {
            head = n1;
            rows = 3;
            columns = 1;
            return;
        }

        // Start from the first row
        Node oldRow = head;
        Node newNode = n1;

        // Go through every row
        while (oldRow != null && newNode != null) {

            Node current = oldRow;

            // Go to the last column of current row
            while (current.right != null) {
                current = current.right;
            }

            // Connect new column
            current.right = newNode;

            oldRow = oldRow.down;
            newNode = newNode.down;
        }

        columns++;
    }


    // Display 2D structure
    public void display() {

        Node row = head;

        while (row != null) {

            Node current = row;

            while (current != null) {

                System.out.print(current.data + " ");

                current = current.right;
            }

            System.out.println();

            row = row.down;
        }
    }
}