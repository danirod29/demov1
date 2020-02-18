package partesPersonaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class MuertePersonaje extends JPanel implements Runnable{
	//Atributos 
	//Almacenara los valores numericos de las imagenes
	protected int numImgMuerte = 17;
	protected int numImgFinal;
	protected Image imagenGolpe;
	protected boolean estado;
	protected Thread hilo;
		
	//Constructor
	public MuertePersonaje() {	
	}
		
	//Dibuja la imagen del golpe
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Ruta de la imagen
		File ruta = new File("src/ImagenesJuego/magoMuerte"+numImgMuerte+".png");
			
		//Se Inicializa la imagen
		try {
			imagenGolpe = ImageIO.read(ruta);
		} catch (IOException e) {
			System.out.println("Ruta no encontrada");
		}
		setBackground(Color.white);
		//Se dibuja la imagen
		g.drawImage(imagenGolpe, 5, 5, 50, 50, null);
	}
		
	//Animacion de la imagen
	public void run() {
		estado = true;
		while(estado) {
			System.out.println("Entrada-Muerte");
			if(numImgMuerte == numImgFinal) {
				numImgMuerte = numImgMuerte - 2;
			}
			numImgMuerte++;
			repaint();	
			//Para que se vea la animacion
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("=(");
			}
		}
	}
	//Metodo para inicializar hilo
	public void inicializarHilo(MuertePersonaje g) {
		Runnable r = g;
		hilo = new Thread(r);
	}
			
	//Metodo para iniciar hilo
	public void iniciarHilo() {
		if(!hilo.isAlive()) {
				hilo.start();
		}
	}
			
	//Cambia el estado del hilo
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
				
	//Metodo abstracto posición-muerte del personaje
	public abstract void aniMuertePer();
}
