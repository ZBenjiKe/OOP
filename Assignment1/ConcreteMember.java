package Exercise1;

public class ConcreteMember implements Member {
	String memberName = "m"+(counter++);
	GroupAdmin adminSender;
	UndoableStringBuilder usb;
	
	static int counter = 1;
	
	public ConcreteMember(GroupAdmin adminSender) {
		register(adminSender);
	}
	
	public void register(GroupAdmin mySender) {
		if((this.adminSender != null) && (this.adminSender != mySender)) {
			this.unregister(this.adminSender);
		}
		mySender.register(this);
		this.adminSender = mySender;
	}
	
	public void unregister(GroupAdmin adminSender) {
		adminSender.unregister(this);
		this.adminSender = null;
		this.usb = null;
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
	
	public void printGroup(GroupAdmin myGroup) {
		
	}
	
	public static void main(String[] args) {
		GroupAdmin myGroup1 = new GroupAdmin();
		GroupAdmin myGroup2 = new GroupAdmin();
		ConcreteMember m1 = new ConcreteMember(myGroup1);
		ConcreteMember m2 = new ConcreteMember(myGroup1);

		myGroup1.append("Hello ");
		myGroup1.append("World!");
		myGroup2.append("Goodbye");
		
		m1.register(myGroup2);
		m1.unregister(myGroup2);

//		System.out.println(myGroup1.toString());
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		
	}
	
}
