class Solution:
    def maxProfit(self, inventory: List[int], orders: int) -> int:
        inventory.sort(reverse=True)
        inventory.append(0)

        MOD = 10**9 + 7
        ans = 0
        i = 0

        while orders > 0:
            if inventory[i] > inventory[i + 1]:
                count = i + 1
                diff = inventory[i] - inventory[i + 1]

                if orders >= count * diff:
                    top = inventory[i]
                    bottom = inventory[i + 1] + 1
                    ans += (top + bottom) * diff // 2 * count
                    orders -= count * diff
                else:
                    full_rows = orders // count
                    remainder = orders % count

                    top = inventory[i]
                    bottom = inventory[i] - full_rows + 1
                    ans += (top + bottom) * full_rows // 2 * count

                    ans += (inventory[i] - full_rows) * remainder
                    orders = 0

            i += 1

        return ans % MOD