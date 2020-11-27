package linkedList;
import java.time.Duration;
import java.time.Instant;

public class Partition {
    public static void main(String[] args) {
        Node head = new Node(3, new Node(5, new Node(8, new Node(5, new Node(10, new Node(2, new Node(1)))))));
        Instant start = Instant.now();
        Node Result=Partition(head,5);

        while(Result!=null){
            System.out.println(Result.value);
            Result=Result.next;
        }
        Instant end = Instant.now();
        Duration time=Duration.between(start,end);
        System.out.println("Time Required: "+ time.toNanosPart() +" nanoparts");

    }

    public static Node Partition(Node head,int x) {
        Node right=new Node(0);
        Node left=new Node(0);
        Node rightHead=right;
        Node leftHead=left;
        while(head!=null){
            if(head.value<x){
                left.next=new Node(head.value);
                left=left.next;
            }else{
                right.next=new Node(head.value);
                right=right.next;
            }
            head=head.next;
        }
        left.next=rightHead.next;
        return leftHead.next;
    }
}
