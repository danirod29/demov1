package partesPersonaje;

public class GolpeMago extends GolpePersonaje{
	
	//Constructor
	public GolpeMago() {
	}

	@Override
	public void golpeConArmaIz() {
		numImgGolpe = 1;
		numImgFinal = 3;
		
	}

	@Override
	public void golpeConArmaDe() {
		numImgGolpe = 3;
		numImgFinal = 5;
		
	}

	@Override
	public void golpeConArmaEspalda() {
		numImgGolpe = 5;
		numImgFinal = 7;
		
	}

	@Override
	public void golpeConArmaFrontal() {
		numImgGolpe = 7;
		numImgFinal = 9;	
	}

	

}
