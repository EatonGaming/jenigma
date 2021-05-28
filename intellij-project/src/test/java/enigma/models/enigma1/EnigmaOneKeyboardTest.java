package enigma.models.enigma1;

import enigma.components.Keyboard;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static enigma.models.enigma1.EnigmaOneKeyboard.modelOneKeyboard;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnigmaOneKeyboardTest
{
    @SuppressWarnings("unused")
    private static Stream<Character> validEnigmaOneCharactersMethodSource()
    {
        return Stream.of(
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        );
    }

    @ParameterizedTest
    @MethodSource(value = "validEnigmaOneCharactersMethodSource")
    void givenAValidCharacter_whenPressKey_thenCharacterIsReturned(char character)
    {
        Keyboard keyboard = modelOneKeyboard();

        char actual = keyboard.pressKey(character);

        assertThat(actual).isEqualTo(character);
    }

    @ParameterizedTest
    @ValueSource(chars = {'1', '!', '*', ' ', 'n', 'u', '9', '_'})
    void givenAnInvalidCharacter_whenPressKey_thenIllegalArgumentExceptionThrown(char invalidCharacter)
    {
        Keyboard keyboard = modelOneKeyboard();

        assertThrows(IllegalArgumentException.class, () -> keyboard.pressKey(invalidCharacter));
    }
}