package es.iesjandula.graphicInterface;

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

import es.iesjandula.pokemon.utils.Pokemon;

public class CardPanel extends JPanel {
    private Pokemon card;
    private JLabel imagenLabel;
    public CardPanel(Pokemon card) {
        this.card = card;
        setPreferredSize(new Dimension(200, 300));
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
        g.drawString("Nombre: " + card.getName(), 10, 30);
        g.drawString("Type 1: " +card.getType1(), 10, 50);
        g.drawString("Type 2: " +card.getType2(), 10, 70);
        g.drawString("Total Points: " +String.valueOf(card.getTotal()), 10, 90);
        g.drawString("HP: " +String.valueOf(card.getHp()), 10, 110);
        g.drawString("Attack: " +String.valueOf(card.getAttack()), 10, 130);
        g.drawString("Defense: " +String.valueOf(card.getDefense()), 10, 150);
        g.drawString("Sp.Atack: " +String.valueOf(card.getSpAttack()), 10, 170);
        g.drawString("Sp.Defense: " +String.valueOf(card.getSpDefense()), 10, 190);
        g.drawString("Generation: " +String.valueOf(card.getGeneration()), 10, 210);
        g.drawString("Legendary: " +String.valueOf(card.isLegendary()), 10, 230);
        try {
        	// Dentro del bloque try-catch donde cargas la imagen
        	BufferedImage imagen = ImageIO.read(new File("imagen.png"));

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
}
