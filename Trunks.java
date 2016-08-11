package epam;

public class Trunks extends Underwear {
	
	private String model;
	private String colorStr;

	public Trunks() {
		super();
	}
	
	public Trunks(int id, int price, String size, char color, String brend, String model) {
		super(id, price, size, color, brend);
		this.model = model;
		setColorStr();
	}

	private void setColorStr() {
		switch (getColor()) {
			case 'r' : colorStr = "Red"; break;
			case 'b' : colorStr = "Black"; break;
			case 'g' : colorStr = "Gray"; break;
			case 'y' : colorStr = "Yellow"; break;
			case 'w' : colorStr = "White"; break;
			default : colorStr = "Transparent"; break;
		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	
	@Override
	public String toString() {
		return "Бренд: " + getBrend() + ", модель: " + getModel() + ", цвет: " + colorStr + ", размер: " + getSize();
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
