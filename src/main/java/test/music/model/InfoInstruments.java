package test.music.model;

public class InfoInstruments {
	private Long id;
	private String name;
	private String type;
	private Integer price;
	private String year;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public InfoInstruments(Long id, String name, String type, Integer price, String year) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.year = year;
	}
	public InfoInstruments() {
		// TODO Auto-generated constructor stub
	}
	
}
