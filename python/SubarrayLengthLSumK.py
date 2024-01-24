# int count = 0;
# int[] last = new int[]{-m,-m};
# Map<Integer, Integer> map = new HashMap<>();
#
# for(int i = 0; i < a.length; i++){
#     if(map.containsKey(k-a[i])){
#         if(i-map.get(k-a[i]) < m){
#             last= new int[]{map.get(k-a[i]), i};
#         }
#     }
#     if(m-1 <= i){
#         if(i - last[0] < m) count++;
#     }
#
#     map.put(a[i], i);
# }
# return count;

xs = [()]
# res = [False]*2
#
# if xs:
#     res[0] = True
# if xs[0]:
#     res[1] = True

for e in xs:
    print(type(e))