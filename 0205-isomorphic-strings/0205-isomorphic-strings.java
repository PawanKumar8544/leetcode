class Solution {
    public boolean isIsomorphic(String s, String t) {
         Map<Character, Integer> mp1 = new HashMap<>();
    Map<Character, Integer>mp2 = new HashMap<>();

    for (Integer i = 0; i < s.length(); ++i)
      if (mp1.put(s.charAt(i), i) != mp2.put(t.charAt(i), i))
        return false;

    return true;
    }
}