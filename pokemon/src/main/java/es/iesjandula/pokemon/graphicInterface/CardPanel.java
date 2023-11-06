package es.iesjandula.pokemon.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.pokemon.exceptions.PokemonException;
import es.iesjandula.pokemon.utils.Pokemon;

public class CardPanel extends JPanel
{
	final Logger logger = LogManager.getLogger();
	private Pokemon card;
	private int vidaMaxima;
	private int vidaActual;

	public CardPanel(Pokemon card)
	{
		this.card = card;
		this.vidaMaxima = card.getInitialHealth();
		this.vidaActual = card.getHp();
		setPreferredSize(new Dimension(200, 300));
	}

	public void updateCard(Pokemon card)
	{
		this.card = card;
		this.vidaMaxima = card.getInitialHealth();
		this.vidaActual = card.getHp();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g.drawString("Type 1: " + card.getType1(), 10, 65);
		g.drawString("Type 2: " + card.getType2(), 10, 85);
		g.drawString("Total Points: " + String.valueOf(card.getTotal()), 10, 105);
		g.drawString("HP: " + String.valueOf(card.getHp()), 10, 125);
		g.drawString("Attack: " + String.valueOf(card.getAttack()), 10, 145);
		g.drawString("Defense: " + String.valueOf(card.getDefense()), 10, 165);
		g.drawString("Sp.Atack: " + String.valueOf(card.getSpAttack()), 10, 185);
		g.drawString("Sp.Defense: " + String.valueOf(card.getSpDefense()), 10, 205);
		g.drawString("Generation: " + String.valueOf(card.getGeneration()), 10, 225);
		g.drawString("Legendary: " + String.valueOf(card.isLegendary()), 10, 245);
		try
		{
			// Dentro del bloque try-catch donde cargas la imagen
			BufferedImage imagen = ImageIO.read(new File(card.getUrl()));

			// Especifica el nuevo ancho y alto deseado para la imagen reescalada
			int nuevoAncho = 100; // Ajusta el valor a tu preferencia
			int nuevoAlto = 100; // Ajusta el valor a tu preferencia

			// Reescala la imagen
			Image imagenReescalada = imagen.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

			// Configura el JLabel para mostrar la imagen reescalada
			g.drawImage(imagenReescalada, 10, 250, this);

		} catch (IOException e)
		{
			String error = "Error al cargar la imagen";
			logger.error(error, e);
		}

		g.setColor(Color.RED);
		g.fillRect(10, 30, 180, 20); // Barra de vida completa en rojo

		int anchoVida = (int) (180.0 * vidaActual / vidaMaxima);
		g.setColor(Color.GREEN);
		g.fillRect(10, 30, anchoVida, 20); // Barra de vida actual en verde

		// Mostrar el valor de la vida actual en la barra
		g.setColor(Color.BLACK);
		String vidaString = "Vida: " + vidaActual + " / " + vidaMaxima;
		FontMetrics fm = g.getFontMetrics();
		int textWidth = fm.stringWidth(vidaString);
		int x = 10 + (180 - textWidth) / 2; // Centrar el texto en la barra
		g.drawString(vidaString, x, 45);

		// Mostrar el nombre del Pokémon encima de la barra de vida
		g.setColor(Color.BLACK);

		// Establecer la fuente en negrita y más grande
		Font font = g.getFont().deriveFont(Font.BOLD, 14f);
		g.setFont(font);

		g.drawString(card.getName(), 10, 20);

		updateCard(card);
	}

	public void updateHealthBar(int newHealth)
	{
		this.vidaActual = newHealth;
		repaint();
	}
}
