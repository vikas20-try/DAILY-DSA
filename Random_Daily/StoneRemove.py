class Solution:
    def canAliceWin(self, n: int) -> bool:
        stones_needed = 10
        is_alice_turn = True
        
        while n >= stones_needed:
            n -= stones_needed
            stones_needed -= 1
            is_alice_turn = not is_alice_turn
            
        return not is_alice_turn