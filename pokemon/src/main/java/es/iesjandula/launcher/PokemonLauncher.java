package es.iesjandula.launcher;

import java.util.List;

import es.iesjandula.pokemon.utils.Pokemon;
import es.iesjandula.pokemon.utils.ParserPokemon;

public class PokemonLauncher
{

	public static void main(String[] args)
	{
		List<Pokemon> pokemon = ParserPokemon.parseCsv();
		
		System.out.println("YOUR CARDS: ");
		List<Pokemon> pokemonListUser = Pokemon.randomCards(pokemon);
		System.out.println(pokemonListUser.toString());
		
		System.out.println("OPPONENT CARDS: ");
		List<Pokemon> pokemonListOpponent = Pokemon.randomCards(pokemon);
		System.out.println(pokemonListOpponent.toString());
		
		ParserPokemon.savePokemon(pokemonListOpponent);
		System.out.println("Pokemon Guardados");
		List<Pokemon> pokemonGuardados=ParserPokemon.readSelectedPokemonFromFile("datos.txt");
		System.out.println(pokemonGuardados.toString());
		
	}	

}
