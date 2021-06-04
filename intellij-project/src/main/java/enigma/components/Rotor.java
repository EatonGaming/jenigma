package enigma.components;

public interface Rotor
{
    void step();

    char getCharacterAtCurrentPosition();

    char sendCharacterThrough(char character);
}
