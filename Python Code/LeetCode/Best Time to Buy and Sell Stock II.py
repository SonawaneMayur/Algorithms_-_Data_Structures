#   Best Time to Buy and Sell Stock II
# Say you have an array for which the ith element is the price of a given stock on day i.
#
# Design an algorithm to find the maximum profit. You may complete as many transactions as you like
#   (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
#   (ie, you must sell the stock before you buy again).

class Solution:
    def maxProfit(self, prices):
        profit = 0
        for i in range(1, len(prices)):
            diff = prices[i] - prices[i-1]
            if(diff > 0 ):
                profit += diff

        return profit


prices = [12,41,54,12,20]
s= Solution()
print("Maximun profit is {}".format(s.maxProfit(prices)))