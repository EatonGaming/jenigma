package enigma.models;

import enigma.metadata.permittedcharacters.PermittedCharacterSet;
import enigma.metadata.permittedcharacters.PermittedCharacters;
import enigma.models.enigma1.EnigmaOneRotorCharacterConversionConfigurations;
import enigma.metadata.rotorconfigurations.RotorCharacterConversionConfigurations;

import java.util.List;
import java.util.Set;

public enum ModelType {
    ENIGMA_ONE(
            new PermittedCharacterSet(List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')),
            3,
            new EnigmaOneRotorCharacterConversionConfigurations());

    public final PermittedCharacters permittedCharacters;
    public final int numberOfRotors;
    public final RotorCharacterConversionConfigurations rotorCharacterConversionConfigurations;

    ModelType(PermittedCharacters permittedCharacters, int numberOfRotors, RotorCharacterConversionConfigurations rotorCharacterConversionConfigurations) {
        this.permittedCharacters = permittedCharacters;
        this.numberOfRotors = numberOfRotors;
        this.rotorCharacterConversionConfigurations = rotorCharacterConversionConfigurations;
    }
}
