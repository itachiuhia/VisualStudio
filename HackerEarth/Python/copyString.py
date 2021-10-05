from collections import OrderedDict

i = "engineer rocks"

dict = OrderedDict.fromkeys(i)
print(dict)


# def copy_str(x, y):
#     if len(y) == 0:
#         return x
#     else:
#         c = copy_str(x, (y[1:-1]))
#         return c

# x = input("helllo")
# y = input("no")
# print(copy_str(x, y))