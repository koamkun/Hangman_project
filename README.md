**Hangman Game Project Report**

**Project Overview:**
The project is a simple Hangman game implemented in Java. The game selects a random word from a predefined list stored in a file and challenges the player to guess the word one letter at a time. The player has a limited number of incorrect guesses before losing the game. The program provides visual feedback on the Hangman state and allows the player to guess the entire word.

**Design Choices:**
1. **File Input:**
   - The game reads words from an external file (`words_alpha.txt`) to provide a larger and more randomized selection of words, making the game more dynamic.
2. **Data Structures:**
   - `ArrayList<String>`: Stores the list of words read from the file.
   - `ArrayList<Character>`: Keeps track of the player's guessed letters.
3. **Game Logic:**
   - The game continues running until the player either correctly guesses the word or reaches the maximum number of incorrect guesses.
   - The game checks for both single-letter and full-word guesses.

**Algorithms and Data Structures Used:**
1. **Random Word Selection:**
   - A `Random` object is used to select a word randomly from the list, ensuring different words in each playthrough.
2. **Tracking Player Guesses:**
   - A `List<Character>` is used to store the guessed letters and determine which letters should be displayed.
3. **Word Display and Checking:**
   - The program iterates over the target word, displaying correctly guessed letters while keeping the remaining letters hidden.
4. **Hangman Drawing Logic:**
   - A sequence of conditional statements controls the ASCII art representation of the Hangman figure based on the number of incorrect guesses.

**Challenges Encountered:**
1. **Handling Incorrect Guesses:**
   - Initially, the program did not properly differentiate between correct and incorrect guesses, leading to logic errors in the word display.
2. **Guessing Full Words:**
   - A check was added to allow the player to guess the full word at any time, providing an alternative winning condition.
3. **Handling Case Sensitivity:**
   - The program does not currently handle case sensitivity, meaning a guessed letter must match the case in the word. This could be improved.

**Improvements Made:**
1. **Bug Fixes:**
   - The `PrintWord` function was modified to return a boolean indicating whether the player has successfully guessed all letters.
   - The `getPlayerGuess` method was improved to avoid adding duplicate guesses.
2. **Game Flow Enhancements:**
   - Added the ability to guess the entire word for an instant win.
   - Improved the ASCII representation of the Hangman figure for better readability.

**File Usage:**
- The game reads from `words_alpha.txt`, which contains a list of words.
- No file output is used in this implementation, as the game runs interactively through the console.

**Potential Future Enhancements:**
- Implement case-insensitive comparisons.
- Store high scores and past attempts in an output file.
- Add a graphical user interface (GUI) for a more engaging experience.
- Include difficulty levels with variable word lengths.

This project demonstrates fundamental Java programming concepts such as file handling, lists, loops, conditionals, and user input processing while creating an engaging word-guessing game.


**Game screenshots**
![Снимок экрана 2025-02-19 215153](https://github.com/user-attachments/assets/f3b3ee28-a75a-4161-be63-64eb9d0db921)
![Снимок экрана 2025-02-19 220003](https://github.com/user-attachments/assets/fc0eb2a3-7367-4ae6-9b48-60ff9ad8d360)
![Снимок экрана 2025-02-19 220652](https://github.com/user-attachments/assets/52b623b9-55f8-4d86-9311-7f708f5de4ab)
