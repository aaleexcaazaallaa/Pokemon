package es.iesjandula.launcher;

import java.util.List;

import javax.swing.SwingUtilities;

import es.iesjandula.pokemon.utils.Pokemon;
import es.iesjandula.graphicInterface.PokemonCardGame;
import es.iesjandula.pokemon.utils.ParserPokemon;

public class PokemonLauncher {
    public static void main(String[] args) {
        List<Pokemon> pokemon = ParserPokemon.parseCsv();

        System.out.println("YOUR CARDS: ");
        List<Pokemon> pokemonListUser = Pokemon.randomCards(pokemon);
        for (Pokemon card : pokemonListUser) {
            System.out.println(card);
        }

        System.out.println("OPPONENT CARDS: ");
        List<Pokemon> pokemonListOpponent = Pokemon.randomCards(pokemon);
        for (Pokemon card : pokemonListOpponent) {
            System.out.println(card);
        }

        SwingUtilities.invokeLater(() -> {
            PokemonCardGame game = new PokemonCardGame(pokemonListUser, pokemonListOpponent);
            game.setVisible(true);
        });
    }
}

