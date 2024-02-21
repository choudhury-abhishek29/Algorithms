class ChangeCase:
#     String
#     solution(String
#     src) {
#     if (src.length() == 0)
#     return "";
#
#     StringBuilder
#     sr = new
#     StringBuilder();
#     sr.append(src.charAt(0));
#     boolean
#     capNext = false;
#     for (int i = 1; i < src.length() - 1; i++) {
#     if (src.charAt(i) == '_' & & Character.isLetter(src.charAt(i-1)) & & Character.isLetter(src.charAt(i+1))) {
#     capNext = true;
#     }
#     else if (capNext) {
#     sr.append(Character.toUpperCase(src.charAt(i)));
#     capNext = false;
#     }
#     else {
#     sr.append(src.charAt(i));
#     }
#     }
#     sr.append(src.charAt(src.length() - 1));
#     return sr.toString();
#
# }



    def snakeToCamel(self, src)->str:
        str_parts = src.split(' ')
        output_str = ''

        for part in str_parts:
            index = 0
            temp = ''
            while index < len(part):
                if index >= 2 and index < len(part) - 2 and part[index] == '_':
                    temp = part[:index] + str.capitalize(part[index + 1]) + part[index + 2:]
                else:
                    temp += part[index]

                index += 1

            output_str += part + ' '

        return output_str.strip()

        # str_parts = input_str.split(' ')
        # output_str = ''
        # for part in str_parts:
        #     index=0
        #     temp=''
        #     while index < len(part):
        #         if index >= 2 and index < len(part)-2 or part[index] == '_':
        #             part = part[:index]+str.capitalize(part[index+1])+part[index+2:]
        #         else:
        #             temp += part
        #
        #         index += 1
        #
        #     output_str += part+' '
        #
        # return output_str

cs = ChangeCase()
print(cs.snakeToCamel("This is the doc_string for __secret_fun"))
print(cs.snakeToCamel("qvgtNTn gHEnbVu _sriel_ cjk_m uu"))