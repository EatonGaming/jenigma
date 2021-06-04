package enigma.models.enigma1;

import enigma.components.Rotor;

import static enigma.models.ModelType.ENIGMA_ONE;

public class EnigmaOneRotor implements Rotor {
    private final char[] characterSet = ENIGMA_ONE.permittedCharacters.getRawPermittedCharacters();
    private final char[] characterConversionConfiguration;

    private int currentRotorPosition;

    EnigmaOneRotor(char[] characterConversionConfiguration, int ringSettingPosition) {
        this.characterConversionConfiguration = characterConversionConfiguration;

        this.currentRotorPosition = ringSettingPosition - 1;
    }

    @Override
    public void step() {
        int nextPosition = currentRotorPosition + 1;

        if (nextPosition == characterConversionConfiguration.length)
        {
            currentRotorPosition = 0;
        }
        else
        {
            currentRotorPosition = nextPosition;
        }
    }

    @Override
    public char getCharacterAtCurrentPosition() {
        return characterSet[currentRotorPosition];
    }

    @Override
    public char sendCharacterThrough(char character) {
        return characterConversionConfiguration[currentRotorPosition];
    }
}
