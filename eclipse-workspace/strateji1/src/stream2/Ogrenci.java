package stream2;

import java.io.Serializable;

public class Ogrenci implements Serializable {
	private String adi;
	private int no;
	public Ogrenci(String adi, int no) {
		super();
		this.setAdi(adi);
		
		this.setNo(no);
	}
	
		
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}



	public String getAdi() {
		return adi;
	}



	public void setAdi(String adi) {
		this.adi = adi;
	}}
	