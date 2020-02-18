package Vistas;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ordenarConstruccionPersonaje.BuilderMago;
import ordenarConstruccionPersonaje.Director;
import personajeCompleto.PersonajeAnimado;

public class VentanaPrincipal extends JFrame implements KeyListener{
	//Objetos para crear al mago
    private Director miDirector = new Director();
    private BuilderMago miBuilderMago = new BuilderMago();
    private PersonajeAnimado miPerAnimado = null;
    private PersonajeAnimado miPerAni_CLON = null;
	
	public VentanaPrincipal() {
		//Diseño de la ventana
		this.setSize(360, 240);
		this.setLocation(200, 250);
		this.setTitle("Ventana Inicial =)");
		this.setLayout(new GridLayout(2,3));
		
		//...........................................
		
		//Orden de como se construiran las partes del personaje-animado 
	    miDirector.construir(miBuilderMago);
		
	    //Retorna el personaje-animado con sus respectivas partes
	    miPerAnimado = miBuilderMago.obtenerPerAnimado();  
	       
		//...........................................
	    
		agregarPersonaje();
		agregarPersonajeCopia();
		
		//ventana a la escucha
		this.addKeyListener(this);
	}
	
	
	public void agregarPersonaje() {
		//Se asignan las diferentes animaciones para el personaje-Animado
		
		//Para el movimiento-personaje
		this.add(miPerAnimado.asigMovimientoPanel());
		//Para el golpe-personaje
		this.add(miPerAnimado.asigGolpePanel());
		//Para la muerte del personaje
		this.add(miPerAnimado.asigMuertePanel());
	
	}
	public void agregarPersonajeCopia() {
		//Se clona al personaje-animado
	    miPerAni_CLON = miPerAnimado.clonarPer();
	    
	    //Para el movimiento-personaje(CLON)
	  	this.add(miPerAni_CLON.asigMovimientoPanel());
	  	//Para el golpe-personaje(CLON)
	  	this.add(miPerAni_CLON.asigGolpePanel());
	  	//Para la muerte del personaje(CLON)
	  	this.add(miPerAni_CLON.asigMuertePanel());
		
	}
	//Eventos de teclado
	@Override
	public void keyTyped(KeyEvent e) {
		
		
		if(e.getKeyChar() == '4' || e.getKeyChar() == '6'|| 
				e.getKeyChar() == '8'|| e.getKeyChar() == '2') {
			//Asigna el caracter para la animación
			miPerAnimado.asigNumImgAnimacion(""+e.getKeyChar());
			//Asigna el caracter para la animación-COPIA
			miPerAni_CLON.asigNumImgAnimacion(""+e.getKeyChar());
			
			
			//Inicia la animación-Movimiento 
			miPerAnimado.iniAnimacionMovimiento();
			
			//Inicia la animación-Movimiento CLON 
			miPerAni_CLON.iniAnimacionMovimiento();
			
		}else if(e.getKeyChar() == 'a'|| e.getKeyChar() == 's'||
					e.getKeyChar() == 'z'|| e.getKeyChar() == 'w'){
		
			//Asigna el caracter para la animación
			miPerAnimado.asigNumImgAnimacion(""+e.getKeyChar());
			//Asigna el caracter para la animación-COPIA
			miPerAni_CLON.asigNumImgAnimacion(""+e.getKeyChar());
			
			//Inicia la animación-Golpe 
			miPerAnimado.iniAnimacionGolpes();
			
			//Inicia la animación-Golpe CLON
			miPerAni_CLON.iniAnimacionGolpes();
			
		}else if(e.getKeyChar() == 'm') {	
			//Asigna el caracter para la animación
			miPerAnimado.asigNumImgAnimacion(""+e.getKeyChar());
			//Asigna el caracter para la animación-COPIA
			miPerAni_CLON.asigNumImgAnimacion(""+e.getKeyChar());
			
			//Inicia la animación-Muerte
			miPerAnimado.iniAnimacionMuerte();	
			
			//Inicia la animación-Muerte CLON
			miPerAni_CLON.iniAnimacionMuerte();
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
}

