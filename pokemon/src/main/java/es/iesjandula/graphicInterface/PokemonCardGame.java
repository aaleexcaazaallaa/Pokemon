package es.iesjandula.graphicInterface;

import javax.swing.*;

import es.iesjandula.pokemon.utils.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class  PokemonCardGame extends JFrame {
    private List<Pokemon> player1Deck;
    private List<Pokemon> player2Deck;
    private int player1CardIndex = 0;
    private int player2CardIndex = 0;

    public  PokemonCardGame(List<Pokemon> player1Deck, List<Pokemon> player2Deck) {
    	
        this.player1Deck = player1Deck;
        this.player2Deck = player2Deck;

        setTitle("Basic Card Game");
        setSize(1000, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel player1Panel = new JPanel();
        JPanel player2Panel = new JPanel();

        add(player1Panel, BorderLayout.WEST);
        add(player2Panel, BorderLayout.EAST);

        JButton player1NextButton = new JButton("Siguiente Jugador 1");
        JButton player2NextButton = new JButton("Siguiente Jugador 2");

        player1Panel.setLayout(new BorderLayout());
        player2Panel.setLayout(new BorderLayout());

        player1NextButton.addActionListener(e -> {
            player1CardIndex = (player1CardIndex + 1) ;
            player1Panel.removeAll();
            player1Panel.add(new CardPanel(player1Deck.get(player1CardIndex)));
            player1Panel.revalidate();
            player1Panel.repaint();
        });

        player2NextButton.addActionListener(e -> {
            player2CardIndex = (player2CardIndex + 1) % player2Deck.size();
            player2Panel.removeAll();
            player2Panel.add(new CardPanel(player2Deck.get(player2CardIndex)));
            player2Panel.revalidate();
            player2Panel.repaint();
        });

        player1Panel.add(player1NextButton, BorderLayout.SOUTH);
        player2Panel.add(player2NextButton, BorderLayout.SOUTH);
        
        displayInitialCards(player1Panel, player2Panel);
    	
    }

    private void displayInitialCards(JPanel player1Panel, JPanel player2Panel) {
        player1Panel.add(new CardPanel(player1Deck.get(player1CardIndex)));
        player2Panel.add(new CardPanel(player2Deck.get(player2CardIndex)));
    }

   
}



class CardPanel extends JPanel {
    private Pokemon card;

    public CardPanel(Pokemon card) {
        this.card = card;
        setPreferredSize(new Dimension(200, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        // Dibuja la representación de la carta en el panel, puedes usar el método toString de la clase Pokemon
        String pokemonInfo = card.toString();
        g.drawString(pokemonInfo, 10, 30);
    }
}
