package edu.ilstu;

public class Line {
	private String cui1;
	private String relationship;
	private String cui2;
	private String name2;
	private String name1;
	
	
	@Override
	public String toString() {
		return cui1; //+ "     " + relationship + "     " + cui2 + "     " + name2 + "\n\n";
	}
	
	
	public String getCui1() {
		return cui1;
	}
	public void setCui1(String cui1) {
		this.cui1 = cui1;
	}
	public String getCui2() {
		return cui2;
	}
	public void setCui2(String cui2) {
		this.cui2 = cui2;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	

}
