package es.iesjandula.graphicInterface;

import javax.swing.*;
import es.iesjandula.pokemon.utils.Pokemon;
import java.awt.*;
import java.util.List;

public class PokemonCardGame extends JFrame
{
	private List<Pokemon> player1Deck;
	private List<Pokemon> player2Deck;
	private int player1CardIndex = 0;
	private int player2CardIndex = 0;

	private JPanel player1Panel;
	private JPanel player2Panel;
	private CardLayout cardLayout;
	private CardLayout cardLayout2;

	public PokemonCardGame(List<Pokemon> player1Deck, List<Pokemon> player2Deck)
	{
		this.player1Deck = player1Deck;
		this.player2Deck = player2Deck;

		setTitle("Pokemon Card Game");
		setSize(1000, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		player1Panel = new JPanel();
		player2Panel = new JPanel();
		cardLayout = new CardLayout();
		cardLayout2 = new CardLayout();
		player1Panel.setLayout(cardLayout);
		player2Panel.setLayout(cardLayout2);

		add(player1Panel, BorderLayout.WEST);
		add(player2Panel, BorderLayout.EAST);

		JButton player1NextButton = new JButton("Siguiente Jugador 1");
		JButton player1PrevButton = new JButton("Anterior Jugador 1");
		JButton player2NextButton = new JButton("Siguiente Jugador 2");
		JButton player2PrevButton = new JButton("Anterior Jugador 2");

		player1NextButton.addActionListener(e ->
		{
			player1CardIndex = (player1CardIndex + 1) % player1Deck.size();
			cardLayout.show(player1Panel, Integer.toString(player1CardIndex));
		});

		player1PrevButton.addActionListener(e ->
		{
			player1CardIndex = (player1CardIndex - 1 + player1Deck.size()) % player1Deck.size();
			cardLayout.show(player1Panel, Integer.toString(player1CardIndex));
		});

		player2NextButton.addActionListener(e ->
		{
			player2CardIndex = (player2CardIndex + 1) % player2Deck.size();
			cardLayout2.show(player2Panel, Integer.toString(player2CardIndex));
		});

		player2PrevButton.addActionListener(e ->
		{
			player2CardIndex = (player2CardIndex - 1 + player2Deck.size()) % player2Deck.size();
			cardLayout2.show(player2Panel, Integer.toString(player2CardIndex));
		});

		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		buttonPanel1.add(player1PrevButton);
		buttonPanel1.add(player1NextButton);

		buttonPanel2.add(player2PrevButton);
		buttonPanel2.add(player2NextButton);

		add(buttonPanel1, BorderLayout.NORTH);

		add(buttonPanel2, BorderLayout.SOUTH);

		displayInitialCards(player1Panel, player2Panel);

	}

	private void displayInitialCards(JPanel player1Panel, JPanel player2Panel)
	{
		for (int i = 0; i < player1Deck.size(); i++)
		{
			player1Panel.add(new CardPanel(player1Deck.get(i)), Integer.toString(i));
		}
		for (int i = 0; i < player2Deck.size(); i++)
		{
			player2Panel.add(new CardPanel(player2Deck.get(i)), Integer.toString(i));
		}
		cardLayout.show(player1Panel, Integer.toString(player1CardIndex));
		cardLayout2.show(player2Panel, Integer.toString(player2CardIndex));
	}
}
