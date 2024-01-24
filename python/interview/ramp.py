class ChangeCase:
    def snakeToCamel(self, input_str)->str:
        str_parts = input_str.split(' ')
        output_str = ''
        for part in str_parts:
            index=0
            temp=''
            while index < len(part):
                if index >= 2 and index < len(part)-2 and part[index] == '_':
                    part = part[:index]+str.capitalize(part[index+1])+part[index+2:]
                else:
                    temp += part

                index += 1

            output_str += part+' '

        return output_str

cs = ChangeCase()
print(cs.snakeToCamel("__variable_one__ _variable_two_four__ variable_three"))