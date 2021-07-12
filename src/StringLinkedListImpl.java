public class StringLinkedListImpl implements StringLinkedList {
    private Node first;
    private Node last;
    private Node head;


    static int size = -1;

    @Override
    public void addFirst(String s) {
        size++;
        if (first == null) {
            first = new Node();
            first.setPrevious(null);
            last = first;
            first.setNext(head);

        } else {
            Node stock = first;
            first = new Node();
            first.setNext(stock);
            first.setPrevious(null);
            stock.setPrevious(first);
        }
        first.setValue(s);
        first.setIndex(0);

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
        node.setPrevious(last.getPrevious());
        node.setNext(last);
        node.setValue(last.getValue());
        last = new Node();
        last.setPrevious(node);
        last.setNext(null);
        last.setValue(s);
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
        if (last != null) {
            if(last != first){
                Node node = last.getPrevious();
                last = node;
                last.setNext(null);
                size--;
            }
            else{
                size = 0;
                last = null;
                removeFirst();
            }
        }
        return "removed Last";
    }

    @Override
    public int size() {
        return size;
    }
}
