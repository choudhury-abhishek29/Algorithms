from collections import deque

# queue1 = []
# queue1.append('a')
# queue1.append('b')
# queue1.append('c')
# queue1.append('d')
# queue1.append('e')
# queue1.append('f')
# print("Initial queue")
# print(queue1)
#
# print("\nElements dequeued from queue")
# print(queue1.pop())
# print("\nQueue after removing elements")
# print(queue1)


queue2 = deque()
queue2.append('a')
print(queue2)
queue2.append('b')
print(queue2)
queue2.append('c')
print(queue2)
queue2.append('d')
print(queue2)
queue2.append('e')
print(queue2)
queue2.append('f')
print(queue2)
print("Initial queue")
print(queue2)
print("\nPopleft : ")
print(queue2.popleft())
print(queue2)

#use only pop() to act as a stack
print("\nPop : ")
print(queue2.pop())
print(queue2)

print("\nQueue after removing elements")
print(queue2)