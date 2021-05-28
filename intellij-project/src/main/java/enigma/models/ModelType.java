package enigma.models;

import java.util.Set;

public enum ModelType {
    ENIGMA_ONE(Set.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public final Set<Character> permittedCharacters;

    ModelType(Set<Character> permittedCharacters) {
        this.permittedCharacters = permittedCharacters;
    }
}
