from bisect import bisect_right
from typing import List

class Solution:

  def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
    def helper_function(mid: int) -> int:
      cnt = 0
      for row in matrix:
        cnt += bisect_right(row, mid)
      return cnt

    low = matrix[0][0]
    high = matrix[-1][-1]

    while low <= high:
      mid = low + (high - low) // 2
      cnt = helper_function(mid)

      if cnt >= k:
        high = mid - 1
      else:
        low = mid + 1

    return low