package ArrowStreet.P1;

public class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {

        // SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(3, new SinglyLinkedListNode(4 , new SinglyLinkedListNode(5)))));


       // 5 → 2 → 1 → 6 → 7

        SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(5, new SinglyLinkedListNode(2, new SinglyLinkedListNode(1, new SinglyLinkedListNode(6 , new SinglyLinkedListNode(7)))));

        // 5 1 2 3 4
        // 5

        //SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(5, new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(3 , new SinglyLinkedListNode(4, new SinglyLinkedListNode(5))))));

        //SinglyLinkedListNode singlyLinkedListNode = new SinglyLinkedListNode(1, new SinglyLinkedListNode(2, new SinglyLinkedListNode(3, new SinglyLinkedListNode(4 , new SinglyLinkedListNode(5)))));



        singlyLinkedListNode = removeNodes(singlyLinkedListNode, 5);

        while(singlyLinkedListNode.next != null){
            System.out.print(singlyLinkedListNode.data + " ");
            singlyLinkedListNode = singlyLinkedListNode.next;
        }

    }

    public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {

            SinglyLinkedListNode current = listHead;

            while(current.next != null){
                if((current.data > x)){
                    SinglyLinkedListNode runner = current.next;
                    current.data = runner.data;
                    current.next = runner.next;
                    continue;
                }
                else {
                    current = current.next;
                }
            }
        return listHead;
    }

}
