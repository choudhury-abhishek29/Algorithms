# a_tuple = (0, [1, 2, 3], (4, 5, 6), 7.0)
# print(a_tuple)
# print(type(a_tuple))
# print('The first element:', a_tuple[0])
# print('The last element:', a_tuple[-1])
# print('Middle elements:', a_tuple[2:])
# print('The data type of the second element:', type(a_tuple[1]))
# for t in a_tuple:
#     print(t)

first_names = ('Simon', 'Sarah', 'Mehdi', 'Fatime')
last_names = ('Sinek', 'Smith', 'Lotfinejad', 'Lopes')
ages = (49, 55, 39, 33)
zipped = zip(first_names, last_names,ages)
for entry in zipped:
    print(entry)