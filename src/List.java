
public class List {
	//public Elem latestElem;
	public Elem head;
	
	//Constructor creates a head element with the value of the head element
	public List(int valOfHead) {
		this.head = new Elem(valOfHead);
		//latestElem = head;
	}
	public void addElem(int val) {
		Elem nextElem = new Elem(val);
		Elem latestElem = latestElem();
		latestElem.address = nextElem;
	}
	public void deleteElem(int index) {
		if (index < 0) {
			System.out.println("Positive index (0 included) expected!");
			return;
		}
		if (index >= length()) {
			System.out.println("Index out of Bounds!");
			return;
		}
		//if the head is to be deleted, the next element simply becomes the new head
		if (index == 0) { 
			head = head.address;
			return;
		}
		//else the address of the element before has to be changed
		Elem deleteElem = head;
		Elem lastElem = null; //placeholder because lastElem has to be initialized
		while (index > 0) {
			lastElem = deleteElem;
			deleteElem = deleteElem.address;
			index--;
		}
		lastElem.address = deleteElem.address; //pointer of lastElem no longer shows to deleteElem => Garbage-Collector
	}
	public int length() {
		int length = 1;
		Elem nextElem = head.address;
		while (nextElem != null) {
			length++;
			nextElem = nextElem.address;
		}
		return length;
	}
	//returns the last Element of the list
	private Elem latestElem() {
		int numElem = length() - 1;
		Elem latestElem = head;
		while (numElem > 0) {
			latestElem = latestElem.address;
			numElem--;
		}
		return latestElem;
	}
	public void printList() {
		Elem currentElem = head;
		System.out.println("  Element   |     Address     | Value | Next Address");
		System.out.println("------------+-----------------+-------+---------------");
		for (int i = 1; i <= length(); i++) {
			System.out.print(i + ". Element  |  ");
			System.out.print(currentElem);
			System.out.print("  |   ");
			System.out.print(currentElem.val);
			System.out.print("  |  ");
			System.out.println(currentElem.address);
			currentElem = currentElem.address;
		}
		System.out.println();
	}
}
