package test.music.model;

public class MusicInstrument {

	private Long typeId;
	private String name;
	private Integer price;
	private String year;
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public MusicInstrument(Long typeId, String name, Integer price, String year) {
	
		this.typeId = typeId;
		this.name = name;
		this.price = price;
		this.year = year;
	}
	public MusicInstrument() {

		// TODO Auto-generated constructor stub
	}
	
}
