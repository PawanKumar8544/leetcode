class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // If the total number of cards is not a multiple of groupSize, return false.
        }
        
        // Use a TreeMap to count the frequency of each card
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        
        // Try to form groups
        while (!cardCount.isEmpty()) {
            int firstCard = cardCount.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!cardCount.containsKey(currentCard)) {
                    return false; // If the currentCard is not available, return false.
                }
                // Decrement the frequency of the current card
                int count = cardCount.get(currentCard);
                if (count == 1) {
                    cardCount.remove(currentCard);
                } else {
                    cardCount.put(currentCard, count - 1);
                }
            }
        }
        
        return true;  
    }
}