package enigma.models.enigma1;

import java.util.Objects;

class EnigmaOnePlugboardConnection
{
    private final char input;
    private final char output;

    EnigmaOnePlugboardConnection(char input, char output) {
        this.input = input;
        this.output = output;
    }

    public char getInput() {
        return input;
    }

    public char getOutput() {
        return output;
    }

    boolean isPluggedInto(char character)
    {
        return input == character;
    }

    void modifyCharacterSignal(CharacterSignal characterSignal)
    {
        characterSignal.setCharacter(output);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnigmaOnePlugboardConnection that = (EnigmaOnePlugboardConnection) o;
        return input == that.input && output == that.output;
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, output);
    }
}
