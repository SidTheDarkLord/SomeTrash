package epam;

public class Trunks extends Underwear {
	
	private String model;

	public Trunks() {
		super();
	}
	
	public Trunks(String size, char color, String brend, String model) {
		super(size, color, brend);
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	
	@Override
	public String toString() {
		return "Trunks. Brend: " + getBrend() + ", model: " + model + ", color: " + getColor() + ", size: " + getSize();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Trunks other = (Trunks) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
}
