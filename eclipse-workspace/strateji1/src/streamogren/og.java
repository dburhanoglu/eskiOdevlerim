package streamogren;

import java.io.Serializable;

public class Ogrenci implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String adi;
	private int no;
	
	public Ogrenci(String adi, int no) {
		super();
		this.adi = adi;
		this.no = no;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Ogrenci [adi=" + adi + ", no=" + no + "]";
	}
	
	
}
