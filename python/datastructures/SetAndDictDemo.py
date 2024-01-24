entries = [1,4,3,2,5,6,3,4,5,2,3,4]
count={}
for entry in entries:
    count[entry] = count.get(entry, 0)+1

print(count)
#sort count by values
print(dict(sorted(count.items(), key=lambda x: x[1], reverse=True)))

print(set(entries))

