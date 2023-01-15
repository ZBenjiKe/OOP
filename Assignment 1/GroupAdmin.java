package Exercise1;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
	List<Member> members = new ArrayList<>();
	UndoableStringBuilder usb = new UndoableStringBuilder();
	
	public void updateMembers() {
		for(Member member : this.members) {
			member.update(this.usb);
		}
	}
	
	@Override
	public void register(Member obj) {
	    // If the member is already in the group, do nothing.
        if (this.members.contains(obj)) {
            return;
        }
        // If the member is in a different group, unregister from there first.
      //  GroupAdmin objAdmin = ((ConcreteMember)obj).adminSender;
        System.out.println(((ConcreteMember)obj).adminSender.usb);
        if(((ConcreteMember)obj).adminSender != null && ((ConcreteMember)obj).adminSender != this) {
        	((ConcreteMember)obj).adminSender.unregister(obj);
        }
        // Add member to this group, and update its usb.
        this.members.add(obj);
        obj.update(this.usb);
        System.out.println("New member added to group");
	}

	@Override
	public void unregister(Member obj) {
		this.members.remove(obj);
		System.out.println("Member removed from group");
	}

	@Override
	public void insert(int offset, String obj) {
		this.usb.insert(offset, obj);
		updateMembers();
	}

	@Override
	public void append(String obj) {
		this.usb.append(obj);
		updateMembers();
	}

	@Override
	public void delete(int start, int end) {
		this.usb.delete(start, end);
		updateMembers();
	}

	@Override
	public void undo() {
		this.usb.undo();
		updateMembers();
	}
	
	public String toString() {
		return this.usb.toString();
	}
	
//	public void printMembers() {
//		for(ConcreteMember member : this.members) {
//			System.out.println(member.toString());;
//		}
//	}
	
}
