package personajeCompleto;

import partesPersonaje.*;

public abstract class PersonajeAnimado {
	//Atributos
	//Partes del personajeAnimado
    protected MoverPersonaje miMovPersonaje;
    protected GolpePersonaje miGolPersonaje;
    protected MuertePersonaje miMuertePersonaje;
    protected String tecla = "";
    
    //Constructor
    public PersonajeAnimado() {
        
    }
      
    //Se instancian las partes del personaje
    public void asigMovPer(MoverPersonaje miMovPersonaje){
        this.miMovPersonaje = miMovPersonaje;  
        miMovPersonaje.inicializarHilo(miMovPersonaje);
    }
    
    public void asigGolPer(GolpePersonaje miGolPersonaje){
        this.miGolPersonaje = miGolPersonaje;
    	miGolPersonaje.inicializarHilo(miGolPersonaje);

    }
    
    public void mosMuertePer(MuertePersonaje miMuertePersonaje){
        this.miMuertePersonaje = miMuertePersonaje;
        miMuertePersonaje.inicializarHilo(miMuertePersonaje);
    }
    
    //Se asigna una acción dependiendo pa tecla pulsada
    
    public void asigNumImgAnimacion(String tecla){
    	this.tecla = tecla;
        switch(tecla){
                //Asignacion de golpe
            case "w":
            	miGolPersonaje.golpeConArmaEspalda();
                break;
            case "z":
            	miGolPersonaje.golpeConArmaFrontal();
                break;
            case "a":
            	miGolPersonaje.golpeConArmaIz();
                break;
            case "s":
                miGolPersonaje.golpeConArmaDe();
                break;
                //Asignacion de desplazamiento
            case "8":
            	miMovPersonaje.moverArriba();
                break;
            case "2":
            	miMovPersonaje.moverAbajo();
                break;
            case "4":
            	miMovPersonaje.moverIzquierda();
                break;
            case "6":
                miMovPersonaje.moverDerecha();
                break;
                //Asignacion de muerte
            case "m" :
            	miMuertePersonaje.aniMuertePer();
                break;
            default:
                System.out.println("No puedo entrar ;(");
                break; 
        }  
    }
    
    //Retorna la animacion de la muerte del personaje
    public MuertePersonaje asigMuertePanel(){
        return miMuertePersonaje;
    }
    
    
    //Inicia el ciclo de la muerte del personaje
    public void iniAnimacionMuerte(){
    	//Detiene el resto de los hilos
    	miGolPersonaje.setEstado(false);
    	miMovPersonaje.setEstado(false);
    	
    	miMuertePersonaje.iniciarHilo();
    	
    	//Renueva el estado del resto de los hilos
    	miGolPersonaje.inicializarHilo(miGolPersonaje);
    	miMovPersonaje.inicializarHilo(miMovPersonaje);
    }
   
    //Retorna la animacion del movimiento del personaje
    public MoverPersonaje asigMovimientoPanel(){
        return miMovPersonaje;
    }
    
    //Inicia el ciclo del movimiento-personaje
    public void iniAnimacionMovimiento(){
    	//Cambia el estado del resto de los hilos
    	miGolPersonaje.setEstado(false);
    	miMuertePersonaje.setEstado(false);
    	
    	//Inicia hilo para Animación-Movimiento
    	miMovPersonaje.iniciarHilo();
    	
    	//Renueva el estado para el resto de los hilos
    	miGolPersonaje.inicializarHilo(miGolPersonaje);
    	miMuertePersonaje.inicializarHilo(miMuertePersonaje);
    }
    
    //Retorna la animacion golpe del personaje
    public GolpePersonaje asigGolpePanel(){
        return  miGolPersonaje;
    }
    
    //Inicia el ciclo para mostrar los golpes personaje
    
    public void iniAnimacionGolpes(){
    	//Detiene el resto de los hilos
    	miMovPersonaje.setEstado(false);
    	miMuertePersonaje.setEstado(false);
    	
    	//Inicia hilo para Animación-Golpe
    	miGolPersonaje.iniciarHilo();
    	
    	//Renueva el estado del resto de los hilos
    	miMovPersonaje.inicializarHilo(miMovPersonaje);
    	miMuertePersonaje.inicializarHilo(miMuertePersonaje);
    }
    
    //Metodo para clonar personaje   
    public abstract PersonajeAnimado clonarPer();

}
