package Exercise1;

public class ConcreteMember implements Member {
	String memberName = "m"+(counter++);
	GroupAdmin adminSender;
	UndoableStringBuilder usb;
	
	static int counter = 1;
	
	public ConcreteMember(GroupAdmin ga) {
		ga.register(this);
	}
	
	@Override
	public void update(UndoableStringBuilder usb) {
		this.usb = usb;
	}
	
	@Override
	public String toString() {
		if(this.usb == null) {
			return "Member: "+memberName+"\nUSB is empty";
		}
		return "Member: "+memberName+"\nUSB: "+this.usb.toString();
	}

	
	public static void main(String[] args) {
		GroupAdmin myGroup1 = new GroupAdmin();
		GroupAdmin myGroup2 = new GroupAdmin();
		ConcreteMember m1 = new ConcreteMember(myGroup1);
		ConcreteMember m2 = new ConcreteMember(myGroup1);
		
		
		
		myGroup1.append("Hello ");
		myGroup2.append("Goodbye");
		myGroup2.register(m2);
		myGroup1.append("World!");
		
//		System.out.println(myGroup1.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
	}
	
}
