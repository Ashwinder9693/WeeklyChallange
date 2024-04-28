#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX_ROWS 1000
#define MAX_COLS 1000

// Function to check if the given word can be formed from the letters in the grid
int isWordFormable(char grid[MAX_ROWS][MAX_COLS], int rows, int cols, char *word) {
    // Frequency array for each letter (assuming uppercase English letters)
    int letterFreq[26] = {0};

    // Count the frequency of each letter in the grid
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            char c = grid[i][j];
            if (isalpha(c)) {
                letterFreq[toupper(c) - 'A']++;
            }
        }
    }

    // Check if the grid contains enough letters to form the word
    for (int i = 0; word[i] != '\0'; i++) {
        char c = toupper(word[i]);
        if (letterFreq[c - 'A'] <= 0) {
            return 0; // If there are not enough occurrences of a letter, the word cannot be formed
        }
        letterFreq[c - 'A']--; // Decrement the frequency of the used letter
    }

    return 1; // Word can be formed from the letters in the grid
}

// Function to get input for the grid dimensions
void getGridDimensions(int *rows, int *cols) {
    printf("Enter the number of rows: ");
    scanf("%d", rows);

    printf("Enter the number of columns: ");
    scanf("%d", cols);

    if (*rows <= 0 || *cols <= 0 || *rows > MAX_ROWS || *cols > MAX_COLS) {
        printf("Invalid dimensions. Please enter positive values less than or equal to %d for both rows and columns.\n", MAX_ROWS);
        exit(1);
    }
}

// Function to get input for the grid elements
void getGridElements(char grid[MAX_ROWS][MAX_COLS], int rows, int cols) {
    printf("Enter the elements of the 2D grid of letters row by row:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf(" %c", &grid[i][j]);
        }
    }
}

// Function to get input for the word to be searched
void getWord(char *word) {
    printf("Enter the word to be searched for in the grid: ");
    scanf("%s", word);
}

int main() {
    int rows, cols;
    char grid[MAX_ROWS][MAX_COLS];
    char word[MAX_ROWS * MAX_COLS];

    // Get input for the grid dimensions
    getGridDimensions(&rows, &cols);

    // Get input for the grid elements
    getGridElements(grid, rows, cols);

    // Get input for the word to be searched
    getWord(word);

    // Check if the word can be formed from the letters in the grid
    int result = isWordFormable(grid, rows, cols, word);

    // Output the result
    printf("%s\n", result ? "true" : "false");

    return 0;
}
