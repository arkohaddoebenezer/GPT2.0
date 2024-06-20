public class LinkedList {
    ListNode head;

    void insertAtEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void deleteAtPosition(int position) {
        try{
            if (head == null) {
                throw new Exception("Cannot delete from an empty ");
            }

            ListNode temp = head;
            if (position == 0) {
                head = temp.next;
                return;
            }
            for (int i = 0; temp != null && i < position - 1; i++) {
                temp = temp.next;
            }

            if (temp == null || temp.next == null) {
                throw new Exception("Index out of bounce");
            }
            temp.next = temp.next.next;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    

    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


}