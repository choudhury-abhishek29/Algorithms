
class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.cahce = {}
        self.head = Node(0,0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head



    def get(self, key: int) -> int:
        if key in self.cahce:
            self.remove(self.cahce[key])
            self.add(self.cahce[key])
            return self.cahce[key].val
        return -1


    def put(self, key: int, value: int) -> None:
        if key in self.cahce:
            self.remove(self.cahce[key])
        else:
            if len(self.cahce)>self.cap:
                lru_node = self.tail.prev
                del self.cahce[lru_node.key]
                self.remove(lru_node)

        self.cahce[key] = Node(key, value)
        self.add(self.cahce[key])

    def add(self, node: Node) -> None:
        next = self.head.next
        self.head.next = node
        next.prev = node
        node.prev = self.head
        node.next = next


    def remove(self, node: Node) -> None:
        next = node.next
        prev = node.prev
        next.prev = prev
        prev.next = next
