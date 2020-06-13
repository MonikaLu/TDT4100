package objectstructures;

public class Partner {
	private String name;
	Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[Partner %s is partner with %s]", name, (partner != null ? partner.name : null)) ;
	}
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {

//		flette forhold mellom oss
		if (partner == this.partner) {
			return;
		}
//		så lenge oldPartner sin partner er meg, skal vi løse opp forholdet vårt.
		Partner oldPartner = this.partner;
		this.partner = partner;
		if (oldPartner != null && oldPartner.getPartner() == this) {
			oldPartner.setPartner(null);
		}
//		så lenge vi ikke skal løse opp forholdet, så skal flette forholdet vårt.
		if (this.partner != null) {
			this.partner.setPartner(this);
		}
	}
	
	public static void main(String args[]) {
		Partner p1 = new Partner("Monika");
		Partner p2 = new Partner("Jon");
		p1.setPartner(p2);
		System.out.println(p1);
		p1.setPartner(p1);
		System.out.println(p1);
	}
	
}

	