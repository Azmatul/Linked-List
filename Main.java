import java.util.Scanner;

public class Main{
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
       Linked_List List = new Linked_List();
       List.add_first();
       List.print_list();
       List.add_last();
       List.print_list();

       System.out.println("************************Available Operation************************\n");

    }
}

class Linked_List{
    Scanner scanner = new Scanner(System.in);
    node Head = null;
    node Current = null;
    class node{
        Scanner scanner = new Scanner(System.in);
        String name;
        node next = null;
        node(){
            this.name = scanner.nextLine();
        }
    }

    node Create_list(){
        System.out.print("Enter the node number: ");
        int n = scanner.nextInt();
        node Temp_Head = new node();
        Current = Temp_Head;
        n--;
        while(n>0){
            node temp = new node();
            Current.next = temp;
            Current = temp;
            n--;
        }
        return Temp_Head;
    }

    void new_list(){
        Head = Create_list();
    }

    void add_first(){
        node Temp_Head = Create_list();
        if(Head != null)
            Current.next = Head;
        Head = Temp_Head;
    }

    void add_middle(int position){
        node temp_current = Find_Position(position);
        node temp_head = Create_list();
        Current.next = temp_current.next;
        temp_current.next = temp_head;
    }

    void add_last(){
        Current = Head;
        while(Current.next != null)
            Current = Current.next;
        Current.next= Create_list();
    }

    void print_list(){
        node Current = Head;
        if(Head == null)
            System.out.println("List is Empty!");
        else{
            while(Current != null){
                if(Current.next != null)
                    System.out.print(Current.name + " -> " );
                else
                    System.out.println(Current.name);
                Current = Current.next;
            }
        }
    }

    int Traverse(){
        int n = 0;
        Current = Head;
        while(Current != null){
            n++;
            Current = Current.next;
        }
        return n;
    }

    node Find_Position(int position){
        int n = 0;
        position-=2;
        Current = Head;
        while(n != position){
            n++;
            Current = Current.next;
        }
        return Current;
    }
}