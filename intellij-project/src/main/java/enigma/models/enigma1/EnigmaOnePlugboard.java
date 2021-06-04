package enigma.models.enigma1;

import enigma.components.Plugboard;

import java.util.*;

import static java.util.Collections.emptySet;

public class EnigmaOnePlugboard implements Plugboard
{
    private final Set<EnigmaOnePlugboardConnection> connections;

    public EnigmaOnePlugboard(Set<EnigmaOnePlugboardConnection> connections) {
        this.connections = connections;
    }

    public static EnigmaOnePlugboard emptyEnigmaOnePlugboard()
    {
        return new EnigmaOnePlugboard(emptySet());
    }

    public static EnigmaOnePlugboardBuilder enigmaOnePlugboard()
    {
        return new EnigmaOnePlugboardBuilder();
    }

    @Override
    public char processCharacter(char character) {
        CharacterSignal characterSignal = new CharacterSignal(character);

        connections.stream()
                .filter(x -> x.isPluggedInto(character))
                .findFirst()
                .ifPresent(x -> x.modifyCharacterSignal(characterSignal));

        return characterSignal.getCharacter();
    }

}
