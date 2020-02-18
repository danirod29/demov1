package partesPersonaje;

public class MoverMago extends MoverPersonaje {

	//Constructo 
	public MoverMago() {
	}
	@Override
	public void moverDerecha() {
		numImgMover = 1;
		numImgFinal = 3;
	}

	@Override
	public void moverIzquierda() {
		numImgMover = 3;
		numImgFinal = 5;
	}

	@Override
	public void moverArriba() {
		numImgMover = 5;
		numImgFinal = 7;
	}

	@Override
	public void moverAbajo() {
		numImgMover = 7;
		numImgFinal = 9;
	}
	
	

}
