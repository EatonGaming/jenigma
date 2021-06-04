package enigma.models.enigma1;

import enigma.metadata.rotorconfigurations.RotorCharacterConversionConfigurations;
import enigma.models.ModelType;

import static java.util.Arrays.stream;

public class EnigmaOneRotorCharacterConversionConfigurations implements RotorCharacterConversionConfigurations {
    @Override
    public char[] forRotor(int rotorNumber) {
        if (rotorNumber < 1 || rotorNumber > ModelType.ENIGMA_ONE.numberOfRotors)
        {
            throw new IllegalArgumentException("Enigma model one only supports rotors 1 -> 3.");
        }

        return stream(ConfigurationsForRotorPositions.values())
                .filter(x -> x.rotorNumber == rotorNumber)
                .findFirst()
                .orElse(ConfigurationsForRotorPositions.INVALID)
                .characterConfiguration;
    }

    @SuppressWarnings("SpellCheckingInspection")
    private enum ConfigurationsForRotorPositions {
        ONE(1, "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray(), 'Q'),
        TWO(2, "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray(), 'E'),
        THREE(3, "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray(), 'V'),
        INVALID(0, null, '#');

        public final int rotorNumber;
        public final char[] characterConfiguration;
        public final char stepNextRotorCharacterIndicator;

        ConfigurationsForRotorPositions(int rotorNumber, char[] characterConfiguration, char stepNextRotorCharacterIndicator) {
            this.rotorNumber = rotorNumber;
            this.characterConfiguration = characterConfiguration;
            this.stepNextRotorCharacterIndicator = stepNextRotorCharacterIndicator;
        }
    }
}
