public class TwoDirectionalList implements DirectionalList{
    private Node first;
    private Node previous;
    private String[] arr;

    public TwoDirectionalList(String[] arr) {
        for (int i=0;i<arr.length;i++)
            add(arr[i]);
    }
    public TwoDirectionalList() {
    }

    @Override
    public void print() {
        if (first == null) {
            System.out.println("В нашем списке пусто!");
            return;
        }
        Node current = first;
        while (current.getNext() != null) {
            if (current.getPrevious()==null)
                System.out.println(current.getPrevious()+"|"+current.getVal()+"|"+current.getNext().getVal());
            else
                System.out.println(current.getPrevious().getVal()+"|"+current.getVal()+"|"+current.getNext().getVal());
            current = current.getNext();
        }
        System.out.println(current.getPrevious().getVal()+"|"+current.getVal()+"|"+current.getNext());

    }

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(null,val, null);
            previous=first;
            return;
        }add(val, previous);
    }

    private void add(String val, Node current) {
        if (current.getNext() == null) {
            current.setNext(new Node(previous, val,null));
            previous=current.getNext();
        } else {
            current.setPrevious(previous);
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
                if (current.getNext()!=null)
                    current.getNext().setPrevious(current.getPrevious());
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
    //возвращает объект
    public Node getFirst() {
        return first;
    }

//    @Override
//    //возвращает объект
//    public Node getPrevious() {
//        return first;
//    }

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
        //ссылка на предыдущий элемент
        private Node previous;
        //значение элемента
        private String val;
        //ссылка на следующий элемент
        private Node next;


        public Node(Node previous,String val, Node next) {
            this.previous=previous;
            this.val = val;
            this.next = next;
        }
        public Node getPrevious() {
            return previous;
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

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

    }
}
