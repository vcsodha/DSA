class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # Use a dictionary to store the anagram groups.
        # Key: A tuple of 26 integers (character counts).
        # Value: A list of strings that match that count.
        anagram_map = defaultdict(list)
        
        for s in strs:
            # Initialize a list of 26 zeros for each letter 'a'-'z'
            count = [0] * 26
            
            # Count the frequency of each character in the string
            for char in s:
                count[ord(char) - ord('a')] += 1
            
            # Use tuple(count) as the key because lists are mutable
            # and cannot be used as dictionary keys in Python.
            anagram_map[tuple(count)].append(s)
            
        # Return all the grouped anagrams
        return list(anagram_map.values())