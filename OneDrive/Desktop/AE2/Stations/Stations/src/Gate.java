
public class Gate {
	private int id;
	private String stationName;
	
	public Gate() {}
	
	public Gate(int id, String stationName) {
		super();
		this.id = id;
		this.stationName = stationName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	@Override
	public String toString() {
		return "Gate [id=" + id + ", stationName=" + stationName + "]";
	}
	
}
