package epam;

public class Underwear extends Clothing {

	private String brend;

	public Underwear() {
		super();
	}

	public Underwear(int id, int price,  String size, char color, String brend) {
		super(id, price, size, color);
		this.brend = brend;
	}

	
	public String getBrend() {
		return brend;
	}

	public void setBrend(String brend) {
		this.brend = brend;
	}

	
	@Override
	public String toString() {
		return "Underwear [brend=" + brend + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brend == null) ? 0 : brend.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Underwear other = (Underwear) obj;
		if (brend == null) {
			if (other.brend != null)
				return false;
		} else if (!brend.equals(other.brend))
			return false;
		return true;
	}
	
}
