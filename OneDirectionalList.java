public class OneDirectionalList implements DirectionalList{
    private Node first;
    private String[] arr;

    public OneDirectionalList(String[] arr) {
        for (int i=0;i<arr.length;i++)
            add(arr[i]);
    }
    public OneDirectionalList() {

    }

    @Override
    public void print() {
        if (first == null) {
            System.out.println("В нашем списке пусто!");
        }
        Node current = first;
        while (current.getNext() != null) {
            System.out.println(current.getVal());
            current = current.getNext();
        }
        System.out.println(current.getVal());
    }

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val, null);
            return;
        }
        add(val, first);
    }

    private void add(String val, Node current) {

        if (current.getNext() == null) {
            current.setNext(new Node(val, null));
        } else {
            add(val, current.getNext());
        }
    }

    @Override
    public boolean remove(String val) {
        if (first.getVal().equals(val)) {
            if (first.getNext() == null) {
                first = null;
            } else {
                /**
                 * Будьте внимательные происходит замена ссылки
                 * first уже не будет прежним
                 */
                first = first.getNext();
            }
            return true;
        }

        Node current = first.getNext();
        Node prev = first;

        while (current != null) {
            if (current.getVal().equals(val)) {
                prev.setNext(current.getNext());
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }

        return false;
    }


    /**
     * Вариант с рекурсией
     */
//    @Override
//    public boolean remove(String val) {
//        if (first.getVal().equals(val)) {
//            if (first.getNext() == null) {
//                first = null;
//            } else {
//                first = first.getNext();
//            }
//            return true;
//        }
//        return remove(val, first, first.getNext());
//    }
//
//    private boolean remove(String val, Node prev, Node current) {
//        if (current == null) {
//            return false;
//        }
//
//        if (current.getVal().equals(val)) {
//            prev.setNext(current.getNext());
//            return true;
//        }
//
//        return remove(val, current, current.getNext());
//    }



    @Override
    public Node getFirst() {
        return first;
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }

        int size = 1;

        Node current = first;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public class Node {
        private String val;
        private Node next;


        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
