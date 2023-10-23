package es.iesjandula.launcher;

import java.util.List;

import es.iesjandula.pokemon.utils.Pokemon;
import es.iesjandula.pokemon.utils.ParserCsv;

public class PokemonLauncher
{

	public static void main(String[] args)
	{
		List<Pokemon> pokemon = ParserCsv.parsePokemon();
		
		System.out.println("YOUR CARDS: ");
		List<Pokemon> pokemonListUser = Pokemon.randomCards(pokemon);
		System.out.println(pokemonListUser.toString());
		
		System.out.println("OPPONENT CARDS: ");
		List<Pokemon> pokemonListOpponent = Pokemon.randomCards(pokemon);
		System.out.println(pokemonListOpponent.toString());
	}

}
