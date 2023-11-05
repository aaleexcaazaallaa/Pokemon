package es.iesjandula.pokemon.graphicInterface;

import javax.swing.*;
import es.iesjandula.pokemon.utils.Pokemon;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import es.iesjandula.pokemon.utils.PokemonUtils;

public class PokemonCardGame extends JFrame
{
	private List<Pokemon> player1Deck;
	private List<Pokemon> player2Deck;
	private int player1CardIndex = 0;
	private int player2CardIndex = 0;
	private JLabel winnerLabel;
	private JLabel loserLabel;
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
		

		JButton startBattleButton = new JButton("Comenzar Combate");

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
		startBattleButton.addActionListener(e -> {
		    List<Pokemon> combate = displayInitialCards(player1Panel, player2Panel);
		    Pokemon attack = combate.get(0);
		    Pokemon defender = combate.get(1);
		    updateHealthBars(attack, defender);
		    Pokemon winner = PokemonUtils.determineWinner(attack, defender);
		    Pokemon loser = PokemonUtils.determineLoser(attack, defender);
		    combate.remove(loser);
		    winnerLabel.setText("                              Ganador: " + winner.getName());
		    loserLabel.setText("                              Perdedor: " + loser.getName());
		});
		winnerLabel = new JLabel("                              Ganador: ");
		winnerLabel.setFont(new Font("Arial", Font.BOLD, 16));
		loserLabel = new JLabel("                              Perdedor: ");
		loserLabel.setFont(new Font("Arial", Font.BOLD, 16));
		JPanel buttonStart = new JPanel();
		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		buttonPanel1.add(player1PrevButton);
		buttonPanel1.add(player1NextButton);
		buttonStart.add(startBattleButton);
		buttonPanel2.add(player2PrevButton);
		buttonPanel2.add(player2NextButton);

		// Crea un nuevo JPanel para contener los botones
		JPanel buttonContainer = new JPanel();
		buttonContainer.setLayout(new GridLayout(2, 1)); // GridLayout de 1 fila y 2 columnas
		
		// Crea un JPanel para contener winnerLabel y loserLabel
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));

		// Agrega winnerLabel y loserLabel al panel de etiquetas
		labelsPanel.add(winnerLabel);
		labelsPanel.add(loserLabel);

		// Agrega buttonPanel1 y buttonStart al buttonContainer
		buttonContainer.add(buttonPanel1);
		buttonContainer.add(buttonStart);

		// Agrega el buttonContainer al área BorderLayout.NORTH
		add(buttonContainer, BorderLayout.NORTH);
		add(labelsPanel, BorderLayout.CENTER);
		add(buttonPanel2, BorderLayout.SOUTH);
		
		

		displayInitialCards(player1Panel, player2Panel);
		
	}

	private List<Pokemon> displayInitialCards(JPanel player1Panel, JPanel player2Panel)
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
		List<Pokemon> rivales = new ArrayList<Pokemon>();
		Pokemon rival1 =this.player1Deck.get(player1CardIndex);
		rivales.add(rival1);
		Pokemon rival2 =this.player2Deck.get(player2CardIndex);
		rivales.add(rival2);
		return rivales;
	}
	
	private void updateHealthBars(Pokemon attacker, Pokemon defender) {
	    attacker.attack(defender); 
	    defender.attack(attacker);
	    int attackerIndex = player1Deck.indexOf(attacker);
	    int defenderIndex = player2Deck.indexOf(defender);
	    
	    // Actualiza las barras de vida de los Pokémon atacante y defensor
	    ((CardPanel) player1Panel.getComponent(attackerIndex)).updateHealthBar(attacker.getHp());
	    ((CardPanel) player2Panel.getComponent(defenderIndex)).updateHealthBar(defender.getHp());
	    
	    // Si la vida de uno de los Pokémon llega a 0, elimínalo de la lista
	    if (attacker.getHp() <= 0) {
	        player1Deck.remove(attacker);
	        player1Panel.remove(attackerIndex);
	    }
	    if (defender.getHp() <= 0) {
	        player2Deck.remove(defender);
	        player2Panel.remove(defenderIndex);
	    }
	    
	    // Repintar los paneles
	    player1Panel.revalidate();
	    player1Panel.repaint();
	    player2Panel.revalidate();
	    player2Panel.repaint();
	}

}