package es.iesjandula.graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import es.iesjandula.pokemon.utils.Pokemon;

public class CardPanel extends JPanel {
    private Pokemon card;

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
        String pokemonInfo = card.toString();
        g.drawString(pokemonInfo, 10, 30);
    }
}
