package personajeCompleto;

import ordenarConstruccionPersonaje.*;

public class PersonajeMago extends PersonajeAnimado{

	//Constructor
	public PersonajeMago() {
	}
	
	//Permite crear copias del personaje a Profundida
	@Override
	public PersonajeAnimado clonarPer() {
		PersonajeAnimado miClonMago;
        
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderMago miBuMago = new BuilderMago();
        
        miDirector.construir(miBuMago);
        
        //Se instancia el objeto para que sea Mago
        miClonMago = miBuMago.obtenerPerAnimado();
        
        //Metodos que reciben parametros
        miClonMago.asigNumImgAnimacion(this.tecla);
        
        return  miClonMago;
	}

}
