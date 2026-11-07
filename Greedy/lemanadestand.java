//understading the question correctly 
// a lemonade stand is there where they sell the lemonde for 5$
// all the customers will be in the queue and each will get 1 lemonde
// all of them have ethier 5,10,20$ bills with them
// so we need to give exact change for 5$ lemonade
// in first i will have an empty hand means no change
// so it is given that bills =[] where bills[i] is the change amount that the customer or the note that the customer have
// so we need to check with that change or the series of bills can we able to satify all the customer 
// if we are able to satisy all the customer then return true ,if not then false
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {
                five++;
            }

            else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }

            else {
                // bill == 20

                if (ten > 0 && five > 0) {
                    // Greedy: prefer $10 + $5
                    ten--;
                    five--;
                }

                else if (five >= 3) {
                    // Otherwise use three $5 bills
                    five -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }
}