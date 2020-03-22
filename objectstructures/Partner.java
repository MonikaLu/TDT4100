package objectstructures;

public class Partner {
	private String name;
	private Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	//hvis partner ikke er null, så skal den settes om til null. og dens assosiasjon til null.
	public void setPartner(Partner partner) {
		if(this.partner != null) {
			this.partner.partner = null;
			this.partner = null;
		}
			
		if(partner != null) {
			if(partner.partner != null) {
				partner.partner.setPartner(null);
			}
			partner.partner = this;
			this.partner = partner;
		}		
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public static void main(String args[]) {
		Partner p1 = new Partner("jon");
		Partner p2 = new Partner("monika");
		Partner p3 = new Partner("annika");
		Partner p4 = new Partner("håvard");
		p1.setPartner(p2); //koble sammen p1 og p2
		p1.setPartner(null); //løse opp Partnerskapet
		p1.setPartner(p3); //løse opp p1 og p2, og p3 og p4. p1 og p2 inngår Partnerskap
		
		try {
			System.out.println(p1.getPartner());
			System.out.println(p2.getPartner());
			System.out.println(p3.getPartner());
		} catch(Error e) {
			System.out.print(e);
		}
	}
	
}
