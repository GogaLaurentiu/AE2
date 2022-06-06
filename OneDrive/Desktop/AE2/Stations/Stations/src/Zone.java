

public class Zone {
	
	private int id;
	private int cost;
	public Zone(int id, int cost) {
		super();
		this.id = id;
		this.cost = cost;
	}
	public Zone() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Zone [id=" + id + ", cost=" + cost + "]";
	}
	
	
}
