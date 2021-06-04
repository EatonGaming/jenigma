package enigma.models.enigma1;

import enigma.components.Plugboard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static enigma.models.enigma1.EnigmaOnePlugboard.emptyEnigmaOnePlugboard;
import static enigma.models.enigma1.EnigmaOnePlugboard.enigmaOnePlugboard;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnigmaOnePlugboardTest
{
    @ParameterizedTest
    @ValueSource(chars = {'A', 'J', 'N', 'P', 'Z'})
    void givenNoPlugConfigurations_whenProcessCharacter_thenSameCharacterIsReturned(Character character)
    {
        Plugboard plugboard = emptyEnigmaOnePlugboard();

        char actual = plugboard.processCharacter(character);

        assertThat(actual).isEqualTo(character);
    }

    @Test
    void givenPlugConfiguration_thatContainsCharacter_whenProcessCharacter_thenDifferentCharacterIsReturned()
    {
        char expected = 'C';
        Plugboard plugboard = enigmaOnePlugboard()
                .withConnection('A', expected)
                .build();

        char actual = plugboard.processCharacter('A');

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenPlugConfiguration_thatDoesNotContainCharacter_whenProcessCharacter_thenSameCharacterIsReturned()
    {
        char expected = 'A';
        Plugboard plugboard = enigmaOnePlugboard()
                .withConnection('B', expected)
                .build();

        char actual = plugboard.processCharacter('A');

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenTwoPlugConfigurationsThatReferenceTheSameInputCharacter_whenBuildPlugboard_thenIllegalStateExceptionThrown()
    {
        assertThrows(IllegalArgumentException.class, () -> enigmaOnePlugboard()
                .withConnection('B', 'C')
                .withConnection('B', 'J')
                .build());
    }

    @Test
    void givenTwoPlugConfigurationsThatReferenceTheSameOutputCharacter_whenBuildPlugboard_thenIllegalArgumentExceptionThrown()
    {
        assertThrows(IllegalArgumentException.class, () -> enigmaOnePlugboard()
                .withConnection('A', 'C')
                .withConnection('B', 'C')
                .build());
    }

    @Test
    void givenPlugConfigurationContainingInvalidInputCharacter_whenBuildPlugboard_thenIllegalArgumentExceptionThrown()
    {
        assertThrows(IllegalArgumentException.class, () -> enigmaOnePlugboard()
                .withConnection('!', 'C')
                .build());
    }

    @Test
    void givenPlugConfigurationContainingInvalidOutputCharacter_whenBuildPlugboard_thenIllegalArgumentExceptionThrown()
    {
        assertThrows(IllegalArgumentException.class, () -> enigmaOnePlugboard()
                .withConnection('B', '@')
                .build());
    }
}