import java.util.*;
class Node{
	int data;
	Node prev;
	Node next;
	public Node(int data){
		this.data=data;
	}
}
public class CircularDoublyLinked{
	public static void main(String[] args){
		LinkedList list=new LinkedList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Size of Linked List");
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			list.create(sc.nextInt());
		}
		//list.display();
		System.out.println("Enter the position and data where u want to insert");
		list.insert(sc.nextInt(),sc.nextInt(),list.len ());
		System.out.println("Length:- "+list.len());
		list.delete(sc.nextInt(),list.len());
		list.display();
	}
}
class LinkedList{
	Node head;
	Node temp;
	public void create(int data){
		Node node =new Node(data);
		Node n=head;
		if(head == null){
			head=node;
			temp=head;
			head.next=head;
			head.prev=head;
		}
		else{
			temp.next=node;
			node.prev=temp;
			node.next=head;
			head.prev=node;
			temp=node;
		}
	}
	public void display(){
		Node n=head;
		do{
			System.out.println(n.data);
			n=n.next;
		}while(n!=head);
	}
	public int len(){
		int l=0;
		Node n=head;
		do{
			l++;
			n=n.next;
		}while(n!=head);
		return l;
	}
	public void insert(int pos,int data,int len){
		Node node=new Node(data);
		Node n=head;
		if (pos==0||pos==len){
			node.prev=head.prev;
			head.prev.next=node;
			head.prev=node;
			node.next=head;
		}else{
			for(int i=0;i<pos-1;i++){
				node.next=n.next;
				n.next.prev=node;
				n.next=node;
				node.prev=n;
			}
		}
	}
	public void delete(int pos,int len){
		Node n=head;
		if (pos==1||pos==len){
			head.next.prev=head.prev;
			head.prev.next=head.next;
			head=head.next;
		}else{
			for(int i=0;i<pos-1;i++){
				n=n.next;
			}
			n.prev.next=n.next;
			n.next.prev=n.prev;
			n=null;
		}
	}
}