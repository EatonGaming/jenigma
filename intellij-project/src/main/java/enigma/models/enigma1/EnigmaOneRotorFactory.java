package enigma.models.enigma1;

import enigma.metadata.rotorconfigurations.RotorCharacterConversionConfigurations;
import enigma.models.ModelType;

public class EnigmaOneRotorFactory {
    public static EnigmaOneRotor getRotorForPosition(int positionNumber, int ringSettingPosition)
    {
        RotorCharacterConversionConfigurations rotorCharacterConversionConfigurations = ModelType.ENIGMA_ONE.rotorCharacterConversionConfigurations;

        char[] characterConversionConfiguration = rotorCharacterConversionConfigurations.forRotor(positionNumber);

        return new EnigmaOneRotor(characterConversionConfiguration, ringSettingPosition);
    }
}
