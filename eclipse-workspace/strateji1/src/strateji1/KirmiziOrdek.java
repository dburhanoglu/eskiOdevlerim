package strateji1;

public class KirmiziOrdek extends Ordek {
	public KirmiziOrdek() {
		super(new VakVak(),new KanatlaUc());
		
	}

	@Override
	public void ciz() {
		// TODO Auto-generated method stub
		System.out.println("kirmizi ordek");
	}

}
