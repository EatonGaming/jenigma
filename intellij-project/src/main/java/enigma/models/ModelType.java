package enigma.models;

import enigma.metadata.permittedcharacters.PermittedCharacterSet;
import enigma.metadata.permittedcharacters.PermittedCharacters;

import java.util.Set;

public enum ModelType {
    ENIGMA_ONE(new PermittedCharacterSet(Set.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')));

    public final PermittedCharacters permittedCharacters;

    ModelType(PermittedCharacters permittedCharacters) {
        this.permittedCharacters = permittedCharacters;
    }
}
