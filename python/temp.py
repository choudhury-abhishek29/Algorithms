# nums = [2,5,4,1,6,8,9,0]
#
# for i,a in enumerate(nums):
#     print("i : "+str(i)+" | a : "+str(a))
#
# for i in range(len(nums)):
#     print(i)
#
# books = ['The Kite Runner', 'The Namesake', 'Clean Code', 'Code in Python', 'Clean Javascript',
#          'Clean Java', 'The Kite Runner Stops', 'The Kite Runner Stole']
# book_map={}
# for book in books:
#     # print('======working with book: '+book)
#     words = book.split()
#     for word in words:
#         book_list = book_map.get(word.lower(),[])
#         # print('word : '+word+' || current books : '+str(book_list))
#         book_list.append(book.lower())
#         book_map[word.lower()]=book_list
#         # print('word : '+word+' || current books : '+str(book_map.get(word.lower(),[])))
#
# # print(book_map.get('runner'))
#
# def get_suggestion(search_word):
#     res=[]
#     for srch in search_word.split():
#         keys = book_map.keys()
#         for x in [key for key in keys if srch in key]:
#             filt_list = book_map.get(x)
#             if len(res)==0:
#                 res=filt_list
#             else:
#                 res = set(res).union(filt_list)
#     return [book for book in res if search_word in book]
#
#
#
# # print(get_suggestion("run"))
# # print(get_suggestion("runn"))
# # print(get_suggestion("runne"))
# # print(get_suggestion("runner"))
# # print("============================")
# # print(get_suggestion("runner "))
# # print(get_suggestion("runner s"))
# # print(get_suggestion("runner st"))
# # print(get_suggestion("runner sto"))
# # print("============================")
# # print(get_suggestion("runner stop"))
# # print(get_suggestion("runner stops"))
#
# import re

def snake_to_camel(text):
    words = text.split()

    def convert_word(word):
        if '_' in word:
            if word.startswith('__'):
                print(word)
            parts = word.split('_')
            return parts[0] + ''.join(x.capitalize() for x in parts[1:])
        return word

    converted_words = [convert_word(word) for word in words]
    result = ' '.join(converted_words)
    print(result)

snake_to_camel('__variable_one__ variable_two__ __variable_three variable_four')

