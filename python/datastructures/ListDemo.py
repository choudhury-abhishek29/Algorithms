list1 = [1, 2, 3, 5, 6, 7, 8, 9]
list2 = ['London','New York','Los Angeles','San Francisco']
print(list1)

#print list from index to index
print(list1[2:4])

#update list between indices
list1[len(list1) - 1:]=[10, 11, 12, 13]
print(list1)

#append at end of list
list1.append(14)
print(list1)

#insert to list
list1.insert(3, 4)
print(list1)

#iterate through a list
for n in list1:
    print(n)

#iterate with index
for i,n in enumerate(list1):
    print(str(i)+':'+str(n))

for i,n in zip(range(len(list1)), list1):
    print(str(i) + ':' + str(n))

print([(index,city) for (index, city) in zip(range(len(list2)), list2)]) #enumerate(list2)

list1[1:3] = list2
print(list1)

list1.remove

