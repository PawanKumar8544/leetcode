class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
   StringBuilder result = new StringBuilder();
      
        // Calculate number of columns in the matrix
        int columns = encodedText.length() / rows;
      
        // Iterate through each diagonal starting from the first row
        // Each diagonal starts at position (0, j) where j is the column index
        for (int startColumn = 0; startColumn < columns; ++startColumn) {
            // Traverse the diagonal from (0, startColumn) going down-right
            // row increments by 1, column increments by 1
            for (int row = 0, column = startColumn; 
                 row < rows && column < columns; 
                 ++row, ++column) {
                // Calculate the position in the original string
                // Position = row * columns + column (row-major order)
                int charPosition = row * columns + column;
                result.append(encodedText.charAt(charPosition));
            }
        }
      
        // Remove trailing spaces from the decoded text
        while (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
      
        // Return the final decoded string
        return result.toString();
    }
}