package partesPersonaje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public abstract class MoverPersonaje extends JPanel implements Runnable{

	//Atributos 
	//Almacenara los valores numericos de las imagenes
	protected int numImgMover = 1;
	protected int numImgFinal;
	protected Image imagenGolpe;
	protected boolean estado;
	protected Thread hilo;
		
	//Constructor
	public MoverPersonaje() {			
	}
		
	//Dibuja la imagen del golpe
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Ruta de la imagen
		File ruta = new File("src/ImagenesJuego/magoMover"+numImgMover+".png");
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
			try {
				while(estado) {	
					numImgMover++;
					System.out.println("Entrada-Movimiento");
					if(numImgMover == numImgFinal) {
						numImgMover = numImgMover - 2;
					}
					Thread.sleep(500);
					repaint();
					}
				} catch (Exception e) {
					System.out.println("=(");
			}
		}

		//Metodo para inicializar hilo
		public void inicializarHilo(MoverPersonaje g) {
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
		
	//Metodos abstractos posición del personaje
	public abstract void moverDerecha();
	public abstract void moverIzquierda();
	public abstract void moverArriba();
	public abstract void moverAbajo();
}
