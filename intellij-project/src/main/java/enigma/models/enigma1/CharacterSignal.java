package enigma.models.enigma1;

import java.util.concurrent.atomic.AtomicReference;

public class CharacterSignal
{
    private final AtomicReference<Character> character;

    public CharacterSignal(char character) {
        this.character = new AtomicReference<>(character);
    }

    char getCharacter()
    {
        return character.get();
    }

    void setCharacter(char newCharacter)
    {
        character.set(newCharacter);
    }
}
