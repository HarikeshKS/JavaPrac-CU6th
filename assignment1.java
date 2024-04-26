public class assignment1 {
    public static void main(String[] args) {
        // Given inputs
        String word = "Wipro";
        String separator = "X";
        int count = 3;

        // Calling the method to generate the big string
        String result = generateString(word, separator, count);

        // Displaying the result
        System.out.println(result);
    }

    // Method to generate a big string with count occurrences of word separated by the separator
    static String generateString(String word, String separator, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(word);

            // Add separator if not the last occurrence
            if (i < count - 1) {
                result.append(separator);
            }
        }

        return result.toString();
    }
}
