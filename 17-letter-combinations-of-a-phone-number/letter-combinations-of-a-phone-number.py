class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        phone_map= {
            "2" : "abc",
            "3" : "def",
            "4" : "ghi",
            "5" : "jkl",
            "6" : "mno",
            "7" : "pqrs",
            "8" : "tuv",
            "9" : "wxyz"
        }

        result= []

        self.backtrack(0,[],digits,phone_map,result)
        return result
    
    def backtrack(self, index, path,digits,phone_map,result):
        if index == len(digits):
            result.append("".join(path))
            return
        
        possible_letters = phone_map[digits[index]]

        for letter in possible_letters:
            path.append(letter)
            self.backtrack(index+1,path,digits,phone_map,result)

            path.pop()