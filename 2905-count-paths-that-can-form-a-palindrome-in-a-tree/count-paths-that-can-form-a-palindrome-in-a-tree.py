class Solution:

  def countPalindromePaths(self, parent: list[int], s: str) -> int:
    n = len(parent)

    # 1. Build Adjacency List
    adj = defaultdict(list)
    for i in range(1, n):
      adj[parent[i]].append((i, s[i]))

    mask_counts = defaultdict(int)

    # 2. DFS to compute root-to-node path bitmasks
    def dfs(curr: int, current_mask: int):
      mask_counts[current_mask] += 1
      for child, char in adj[curr]:
        bit = ord(char) - ord("a")
        dfs(child, current_mask ^ (1 << bit))

    dfs(0, 0)

    # 3. Count valid pairs using frequency map
    ans = 0
    for mask, count in mask_counts.items():
      # Case 1: Identical masks (0 odd characters between u and v)
      ans += count * (count - 1) // 2

      # Case 2: Differ by exactly 1 bit (1 odd character between u and v)
      for k in range(26):
        target = mask ^ (1 << k)
        if target > mask and target in mask_counts:
          ans += count * mask_counts[target]

    return ans