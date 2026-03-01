class Node {
    char ch;
    Node prev;
    Node next;

    Node(char ch, Node prev, Node next) {
        this.ch = ch;
        this.prev = prev;
        this.next = next;
    }
}

class TextEditor {
    private Node head;
    private Node tail;
    private Node cursor;

    public TextEditor() {
        head = new Node('\0', null, null);
        tail = new Node('\0', null, null);
        head.next = tail;
        tail.prev = head;
        cursor = head;
    }

    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            Node newNode = new Node(ch, cursor, cursor.next);
            cursor.next.prev = newNode;
            cursor.next = newNode;
            cursor = newNode;
        }
    }

    public int deleteText(int k) {
        int count = 0;
        while (k > 0 && cursor != head) {
            Node prevNode = cursor.prev;
            prevNode.next = cursor.next;
            cursor.next.prev = prevNode;
            cursor = prevNode;
            k--;
            count++;
        }
        return count;
    }

    public String cursorLeft(int k) {
        while (k > 0 && cursor != head) {
            cursor = cursor.prev;
            k--;
        }
        return getLeftText();
    }

    public String cursorRight(int k) {
        while (k > 0 && cursor.next != tail) {
            cursor = cursor.next;
            k--;
        }
        return getLeftText();
    }

    private String getLeftText() {
        ArrayList<Character> text = new ArrayList<>();
        Node curr = cursor;
        int count = 0;
        while (curr != head && count < 10) {
            text.add(curr.ch);
            curr = curr.prev;
            count++;
        }
        Collections.reverse(text);
        StringBuilder sb = new StringBuilder();
        for (char ch : text) {
            sb.append(ch);
        }
        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */