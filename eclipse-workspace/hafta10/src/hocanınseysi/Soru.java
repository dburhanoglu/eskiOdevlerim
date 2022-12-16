package hocanýnseysi;


	public class Soru {
		protected int puan;
		protected int metin;
		protected int zorluk;
		public static final int KOLAY=0;
		public static final int ZOR=1;
		public int getPuan() {
		return puan;
		}
		public void setPuan(int puan) {
		this.puan = puan;
		}
		public int getMetin() {
		return metin;
		}
		public void setMetin(int metin) {
		this.metin = metin;
		}
		public int getZorluk() {
		return zorluk;
		}
		public void setZorluk(int zorluk) {
		this.zorluk = zorluk;
		}
		}
