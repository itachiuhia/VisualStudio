import sys

def solution(coins, amount:int) ->int:

    inf = sys.maxsize
    if amount == 0:
        return 0

    mem = {}

    for coin in coins:
        mem[coin] = 1

    for i in range(amount+1):
        if i not in coins :
            mem[i] = min([mem.get(i-coin, inf) for coin in coins]) +1

    return mem[amount] if mem[amount] != float('inf') else -1                






coins = [1,2, 5]
amount = 11

print(solution(coins, amount))