package es.iesjandula.launcher;

import java.util.List;

import es.iesjandula.pokemon.utils.Pokemon;
import es.iesjandula.pokemon.utils.ParserCsv;

public class PokemonLauncher
{

	public static void main(String[] args)
	{
		List<Pokemon> pokemon = ParserCsv.parsePokemon();
		List<Pokemon> pokemonList = Pokemon.randomCards(pokemon);
		System.out.println(pokemonList.toString());
	}

}
