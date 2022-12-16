package SÝNAVÝ;

public abstract class Hesap implements IGuvenlikKontrol {
	protected String acilisTarihi;
	protected boolean aktifMi;
	protected int numara;

	public Hesap(String acilisTarihi, boolean aktifMi, int numara) {
		super();
		this.acilisTarihi = acilisTarihi;
		this.aktifMi = aktifMi;
		this.numara = numara;

	}

	@Override
	public void yetkiKontrol() {
		// TODO Auto-generated method stub

	}

	protected int masrafHesapla() {
		return 0;

	}
}
