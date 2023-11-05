package es.iesjandula.pokemon.launcher;

import java.io.File;
import java.util.List;

import javax.swing.SwingUtilities;

import es.iesjandula.pokemon.utils.Pokemon;
import es.iesjandula.pokemon.exceptions.PokemonException;
import es.iesjandula.pokemon.graphicInterface.PokemonCardGame;
import es.iesjandula.pokemon.utils.ParserPokemon;

public class PokemonLauncher
{
	public static void main(String[] args) throws PokemonException
	{
		List<Pokemon> pokemon = ParserPokemon.parseCsv();

		System.out.println("YOUR CARDS: ");
		List<Pokemon> pokemonListUser = Pokemon.randomCards(pokemon);
		for (Pokemon card : pokemonListUser)
		{
			System.out.println(card);
		}

		System.out.println("OPPONENT CARDS: ");
		List<Pokemon> pokemonListOpponent = Pokemon.randomCards(pokemon);
		for (Pokemon card : pokemonListOpponent)
		{
			System.out.println(card);
		}
		
		File savedGame1 = new File("jugador1.txt");
		File savedGame2 = new File("jugador2.txt");
		
		if(savedGame1.exists() && savedGame2.exists()) 
		{
			List<Pokemon> player1List = ParserPokemon.readSelectedPokemonFromFile("jugador1.txt");
			List<Pokemon> player2List = ParserPokemon.readSelectedPokemonFromFile("jugador2.txt");
			SwingUtilities.invokeLater(() ->
			{
				PokemonCardGame game = new PokemonCardGame(player1List, player2List);
				game.setVisible(true);
			});
		}
		else 
		{
			SwingUtilities.invokeLater(() ->
			{
				PokemonCardGame game = new PokemonCardGame(pokemonListUser, pokemonListOpponent);
				game.setVisible(true);
			});
		}
	}
}
