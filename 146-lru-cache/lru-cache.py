class Node:
    def __init__(self, key: int = 0, val: int = 0):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity= capacity
        self.lookup={}

        self.head=Node()
        self.tail=Node()
        self.head.next=self.tail
        self.tail.prev=self.head

    def _remove(self, node: Node) -> None:
        prev_node=node.prev
        next_node=node.next
        prev_node.next=next_node
        next_node.prev=prev_node

    def _add_to_head(self, node: Node) -> None:
        node.next=self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node

    def get(self, key: int) -> int:
        if key in self.lookup:
            node=self.lookup[key]
            self._remove(node)
            self._add_to_head(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.lookup:
            node = self.lookup[key]
            node.val = value
            self._remove(node)
            self._add_to_head(node)
        else:
            if len(self.lookup) >= self.capacity:
                lru_node = self.tail.prev
                self._remove(lru_node)
                del self.lookup[lru_node.key]
            
            new_node = Node(key, value)
            self.lookup[key] = new_node
            self._add_to_head(new_node)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)