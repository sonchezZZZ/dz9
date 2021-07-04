public class StringLinkedListImpl implements StringLinkedList {
    private Node first;
    private Node last;
    private Node head;


    static int size = -1;

    @Override
    public void addFirst(String s) {
        size++;
        if (first == null) {
            first.setPrevious(null);
            first.setNext(head);
            head = first;
        } else {
            Node stock = first;
            first = new Node();
            first.setNext(stock);
            stock.setPrevious(first);
        }
        first.setValue(s);

    }

    @Override
    public void add(String s, int index) {
        if (index > size) {
            return;
        }
        size++;
        Node oldNode = first;
        Node prevNode;
        for (int i = 0; i <= index; i++) {
            oldNode = oldNode.getNext();
        }
        prevNode = oldNode.getPrevious();
        Node node = new Node();
        node.setNext(oldNode);
        node.setPrevious(oldNode.getPrevious());
        oldNode.setPrevious(node);
        prevNode.setNext(node);
        node.setValue(s);
    }

    @Override
    public void addLast(String s) {
        size++;
        Node node = last;
        last = new Node();
        node.setPrevious(last.getPrevious());
        last.setPrevious(node);
        node.setNext(last);
        node.setValue(s);
        last.setNext(null);
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String get(int i) {
        String result = " ";
        if (i == 0) {
            result = getFirst();
        }
        if (i == size) {
            result = getLast();
        }
        if (i <= size) {
            Node node = first;
            for (int j = 0; j <= i; j++) {
                node = node.getNext();
            }
            result = node.getValue();
        }
        return result;
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public String removeFirst() {
        Node node = first.getNext();
        if (size != 0) {
            first = node;
            first.setPrevious(null);
            size--;
        }
        return first.getValue();
    }

    @Override
    public void remove(int i) {
        if (i <= size) {
            Node node = first;
            for (int j = 0; j <= i; j++) {
                node = node.getNext();
            }
            Node prevNode = node.getPrevious();
            Node nextNode = node.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrevious(prevNode);
            size--;
        }

    }

    @Override
    public String removeLast() {
        if (last.getValue() != null) {
            Node node = last.getPrevious();
            last = node;
            last.setNext(null);
            size--;
        }
        return last.getValue();
    }

    @Override
    public int size() {
        return size;
    }
}
