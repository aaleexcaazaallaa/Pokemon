package es.iesjandula.pokemon.graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import es.iesjandula.pokemon.utils.Pokemon;

public class CardPanel extends JPanel {
    private Pokemon card;
    private JLabel imagenLabel;
    private JProgressBar healthBar;
    
    public CardPanel(Pokemon card) {
        this.card = card;
        setPreferredSize(new Dimension(200, 300));
        
        // Crear una etiqueta para mostrar el nombre del Pokémon
        JLabel nameLabel = new JLabel(card.getName());
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        add(nameLabel, BorderLayout.NORTH);
		
		// Crear una barra de vida
        healthBar = new JProgressBar(0, 100); // El rango puede variar según tus necesidades
        healthBar.setValue(card.getHp());
        healthBar.setStringPainted(true);
        add(healthBar, BorderLayout.CENTER);
    }

    public void updateCard(Pokemon card) {
        this.card = card;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g.drawString("Type 1: " +card.getType1(), 10, 65);
        g.drawString("Type 2: " +card.getType2(), 10, 85);
        g.drawString("Total Points: " +String.valueOf(card.getTotal()), 10, 105);
        g.drawString("HP: " +String.valueOf(card.getHp()), 10, 125);
        g.drawString("Attack: " +String.valueOf(card.getAttack()), 10, 145);
        g.drawString("Defense: " +String.valueOf(card.getDefense()), 10, 165);
        g.drawString("Sp.Atack: " +String.valueOf(card.getSpAttack()), 10, 185);
        g.drawString("Sp.Defense: " +String.valueOf(card.getSpDefense()), 10, 205);
        g.drawString("Generation: " +String.valueOf(card.getGeneration()), 10, 225);
        g.drawString("Legendary: " +String.valueOf(card.isLegendary()), 10, 245);
        try {
        	// Dentro del bloque try-catch donde cargas la imagen
        	BufferedImage imagen = ImageIO.read(new File(card.getUrl()));

        	// Especifica el nuevo ancho y alto deseado para la imagen reescalada
        	int nuevoAncho = 100; // Ajusta el valor a tu preferencia
        	int nuevoAlto = 100;  // Ajusta el valor a tu preferencia

        	// Reescala la imagen
        	Image imagenReescalada = imagen.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

        	// Configura el JLabel para mostrar la imagen reescalada
        	g.drawImage(imagenReescalada, 10, 250, this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void updateHealthBar(int newHealth) {
        healthBar.setValue(newHealth);
	}
}
