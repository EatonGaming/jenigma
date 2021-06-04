package enigma.metadata.rotorconfigurations;

import enigma.models.enigma1.EnigmaOneRotorCharacterConversionConfigurations;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings("SpellCheckingInspection")
class EnigmaOneRotorCharacterConversionConfigurationsTest {

    @Test
    void givenRotorPositionOne_EnigmaModelOne_whenGetConfigurationForRotor_thenCorrectConfigurationReturned()
    {
        char[] expected = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
        EnigmaOneRotorCharacterConversionConfigurations enigmaOneRotorConfigurations = new EnigmaOneRotorCharacterConversionConfigurations();
        int rotorNumber = 1;

        char[] actual = enigmaOneRotorConfigurations.forRotor(rotorNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenRotorPositionTwo_EnigmaModelOne_whenGetConfigurationForRotor_thenCorrectConfigurationReturned()
    {
        char[] expected = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
        EnigmaOneRotorCharacterConversionConfigurations enigmaOneRotorConfigurations = new EnigmaOneRotorCharacterConversionConfigurations();
        int rotorNumber = 2;

        char[] actual = enigmaOneRotorConfigurations.forRotor(rotorNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenRotorPositionThree_EnigmaModelOne_whenGetConfigurationForRotor_thenCorrectConfigurationReturned()
    {
        char[] expected = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
        EnigmaOneRotorCharacterConversionConfigurations enigmaOneRotorConfigurations = new EnigmaOneRotorCharacterConversionConfigurations();
        int rotorNumber = 3;

        char[] actual = enigmaOneRotorConfigurations.forRotor(rotorNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenRotorNumberLessThanOne_EnigmaModelOne_whenGetConfigurationForRotor_thenIllegalArgumentExceptionThrown()
    {
        EnigmaOneRotorCharacterConversionConfigurations enigmaOneRotorConfigurations = new EnigmaOneRotorCharacterConversionConfigurations();
        int rotorNumber = 0;

        assertThrows(IllegalArgumentException.class, () -> enigmaOneRotorConfigurations.forRotor(rotorNumber));
    }

    @Test
    void givenRotorNumberMoreThanThree_EnigmaModelOne_whenGetConfigurationForRotor_thenIllegalArgumentExceptionThrown()
    {
        EnigmaOneRotorCharacterConversionConfigurations enigmaOneRotorConfigurations = new EnigmaOneRotorCharacterConversionConfigurations();
        int rotorNumber = 4;

        assertThrows(IllegalArgumentException.class, () -> enigmaOneRotorConfigurations.forRotor(rotorNumber));
    }
}