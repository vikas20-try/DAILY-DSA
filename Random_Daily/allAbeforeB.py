class Solution:
    def checkString(self, s: str) -> bool:
        count = [0 for _ in range(2)]
        #0 is for A and #1 is for B
        for check in s:
            if check == 'a':
                count[0]+=1
            else :
                count[1] += 1
        #now traversing through the string again while counting the 'A' count
        for check in s:
            if check == 'a':
                count[0]-=1
                if count[0] == 0:
                    return True

            elif check !=0 and count[0]!=0:
                return False
        return True
        