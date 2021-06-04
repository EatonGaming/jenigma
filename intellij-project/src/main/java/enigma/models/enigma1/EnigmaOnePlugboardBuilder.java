package enigma.models.enigma1;

import enigma.metadata.permittedcharacters.PermittedCharacters;

import java.util.*;

import static enigma.models.ModelType.ENIGMA_ONE;

class EnigmaOnePlugboardBuilder {
    private final PermittedCharacters permittedCharacters = ENIGMA_ONE.permittedCharacters;
    private final Set<EnigmaOnePlugboardConnection> connections = new HashSet<>();

    EnigmaOnePlugboardBuilder withConnection(char input, char output) {
        EnigmaOnePlugboardConnection connection = new EnigmaOnePlugboardConnection(input, output);

        connections.add(connection);

        return this;
    }

    EnigmaOnePlugboard build() {
        validateConnections();

        return new EnigmaOnePlugboard(connections);
    }

    private void validateConnections() {
        validateCharactersUsedAreValid();
        validateCharacterNotUsedMoreThenOnce();
    }

    private void validateCharactersUsedAreValid() {
        for (EnigmaOnePlugboardConnection connection : connections) {
            if (!permittedCharacters.characterIsPermitted(connection.getInput()) || !permittedCharacters.characterIsPermitted(connection.getOutput())) {
                throw new IllegalArgumentException("Character used in connection is not valid for this model of enigma.");
            }
        }
    }

    private void validateCharacterNotUsedMoreThenOnce() {
        Map<Character, Integer> pluggedCharacters = new HashMap<>();

        connections.forEach(x -> {
            countConnectionCharacters(pluggedCharacters, x.getInput());
            countConnectionCharacters(pluggedCharacters, x.getOutput());
        });

        Optional<Map.Entry<Character, Integer>> charactersUsedMultipleTimes = pluggedCharacters.entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .findAny();

        if (charactersUsedMultipleTimes.isPresent()) {
            throw new IllegalArgumentException("You can not use the same character in multiple connections.");
        }
    }

    private void countConnectionCharacters(Map<Character, Integer> pluggedCharacters, char character) {
        if (pluggedCharacters.containsKey(character)) {
            int count = pluggedCharacters.get(character);
            pluggedCharacters.put(character, ++count);
        } else {
            pluggedCharacters.put(character, 1);
        }
    }
}
