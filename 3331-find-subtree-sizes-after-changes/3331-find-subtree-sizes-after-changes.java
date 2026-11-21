class Solution {
    private List<Integer>[] adjacencyList;  // Tree structure as adjacency list
    private List<Integer>[] charToNodeStack;  // Stack of nodes for each character (a-z)
    private char[] characters;  // Character array from input string
    private int[] subtreeSizes;  // Result array storing subtree sizes
  
    public int[] findSubtreeSizes(int[] parent, String s) {
        int nodeCount = s.length();
      
        // Initialize data structures
        adjacencyList = new List[nodeCount];
        charToNodeStack = new List[26];  // 26 letters in alphabet
        this.characters = s.toCharArray();
      
        // Create empty lists for each node and character
        Arrays.setAll(adjacencyList, index -> new ArrayList<>());
        Arrays.setAll(charToNodeStack, index -> new ArrayList<>());
      
        // Build adjacency list from parent array (skip root at index 0)
        for (int childNode = 1; childNode < nodeCount; ++childNode) {
            adjacencyList[parent[childNode]].add(childNode);
        }
      
        // Initialize result array and perform DFS
        subtreeSizes = new int[nodeCount];
        dfs(0, -1);  // Start DFS from root (node 0) with no parent (-1)
      
        return subtreeSizes;
    }
  
    private void dfs(int currentNode, int parentNode) {
        // Initialize current node's subtree size to 1 (itself)
        subtreeSizes[currentNode] = 1;
      
        // Get character index (0-25 for a-z)
        int charIndex = characters[currentNode] - 'a';
      
        // Push current node onto the stack for its character
        charToNodeStack[charIndex].add(currentNode);
      
        // Recursively process all children
        for (int childNode : adjacencyList[currentNode]) {
            dfs(childNode, currentNode);
        }
      
        // Find the closest ancestor with the same character
        // If stack has more than 1 element, the second-to-last is the closest ancestor
        // Otherwise, use the parent node
        int closestAncestorWithSameChar = charToNodeStack[charIndex].size() > 1 ? 
            charToNodeStack[charIndex].get(charToNodeStack[charIndex].size() - 2) : 
            parentNode;
      
        // Add current node's subtree size to its closest ancestor with same character
        if (closestAncestorWithSameChar >= 0) {
            subtreeSizes[closestAncestorWithSameChar] += subtreeSizes[currentNode];
        }
      
        // Pop current node from the character stack (backtrack)
        charToNodeStack[charIndex].remove(charToNodeStack[charIndex].size() - 1);
    }
}
