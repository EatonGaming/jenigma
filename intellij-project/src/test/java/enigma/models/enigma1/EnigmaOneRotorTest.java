package enigma.models.enigma1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnigmaOneRotorTest {

    @Test
    void givenEnigmaOneRotor_withRotorOneConfiguration_whenStep_thenCurrentPositionIsChangedToTheNextCharacter()
    {
        EnigmaOneRotor enigmaOneRotor = EnigmaOneRotorFactory.getRotorForPosition(1, 1);

        enigmaOneRotor.step();
        char actual = enigmaOneRotor.getCharacterAtCurrentPosition();

        assertThat(actual).isEqualTo('B');
    }

    @Test
    void givenEnigmaOneRotor_withRotorOneConfiguration_whenGetCharacterAtCurrentPosition_thenCurrentPositionIsChangedToTheNextCharacter()
    {
        EnigmaOneRotor enigmaOneRotor = EnigmaOneRotorFactory.getRotorForPosition(1, 1);

        char actual = enigmaOneRotor.getCharacterAtCurrentPosition();

        assertThat(actual).isEqualTo('A');
    }

    @Test
    void givenEnigmaOneRotor_withRotorOneConfiguration_atFirstPosition_whenSendCharacterThrough_thenCharacterIsModifiedCorrectly()
    {
        EnigmaOneRotor enigmaOneRotor = EnigmaOneRotorFactory.getRotorForPosition(1, 1);

        char actual = enigmaOneRotor.sendCharacterThrough('A');

        assertThat(actual).isEqualTo('E');
    }

    @Test
    void givenEnigmaOneRotor_withRotorOneConfiguration_atThirdPosition_whenSendCharacterThrough_thenCharacterIsModifiedCorrectly()
    {
        EnigmaOneRotor enigmaOneRotor = EnigmaOneRotorFactory.getRotorForPosition(1, 3);

        char actual = enigmaOneRotor.sendCharacterThrough('A');

        assertThat(actual).isEqualTo('M');
    }
}