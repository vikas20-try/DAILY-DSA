class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while(len(s)>k):
            #chucking the string 
            temp = ""
            for i in range(0,len(s),k):
                chunk = s[i:i+k]
                total = sum(int(ch) for ch in chunk)
                temp += str(total)
            s = temp
        return s