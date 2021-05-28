package enigma.metadata.permittedcharacters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PermittedCharacterSetTest
{
    @Test
    void givenCharacterThatExistsInPermittedCharacterSet_whenCharacterIsPermitted_thenReturnTrue()
    {
        PermittedCharacterSet permittedCharacterSet = new PermittedCharacterSet(Set.of('A', 'B', 'C'));

        boolean result = permittedCharacterSet.characterIsPermitted('A');

        assertThat(result).isTrue();
    }

    @Test
    void givenCharacterThatDoesNotExistInPermittedCharacterSet_whenCharacterIsPermitted_thenReturnTrue()
    {
        PermittedCharacterSet permittedCharacterSet = new PermittedCharacterSet(Set.of('A', 'B', 'C'));

        boolean result = permittedCharacterSet.characterIsPermitted('J');

        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenCharacterSetThatIsNullOrEmpty_whenCharacterIsPermitted_thenReturnFalse(Set<Character> permittedCharacters)
    {
        PermittedCharacterSet permittedCharacterSet = new PermittedCharacterSet(permittedCharacters);

        boolean result = permittedCharacterSet.characterIsPermitted('A');

        assertThat(result).isFalse();
    }
}