import java.util.*;
public class BrowserHistoryTest{
    public static void main(String[] args){	
	String command = "";
	DoublyLinkedList<String> ll = new DoublyLinkedList();
	Scanner kb = new Scanner(System.in);
	ArrayList<String> url = new ArrayList<>();
	System.out.println("Please enter a URL, type done when you're finished.");
	while(!command.contains("done")){
	    command = kb.nextLine();
	    if(!command.equals("done")){
		url.add(command);
	    }
	}
	for(int i = 0; i < url.size(); i++){		   
	    if(!url.get(i).equals("done")) ll.append(url.get(i));
	}
	
	System.out.println(ll.toString());
	
	
	
	while(!command.equals("quit")){
	System.out.println("Please enter next, previous, or quit");
	command = kb.nextLine();
	LLIterator<String> itr = ll.iterator();
	if(command.equals("next")){
	    if(ll.iterator().hasNext() == true){
		System.out.println("Now visiting: " + itr.next());
	    }
	    else System.out.println("No next item");
	}
	else if(command.equals("previous")){
	    if(ll.iterator().hasPrevious() == true){
		System.out.println("Now visiting:" +  itr.previous());
	    }	else System.out.println("No previous item");
	}else if(command.equals("quit")){
	    System.exit(0);
	}else{
	    System.out.println("Not a valid command");
	    System.out.println("Please enter next or previous to switch nodes");
	    command = kb.nextLine();   
	
    
	}
	}
    }
}
