def Generator1(n):
    for i in range(n):
        yield i

def Generator2(x,y):
    for j in range(x, y):
        yield j

def Generator3(n, m):
    yield from Generator1(n)
    yield from Generator2(n, m+3)

print( tuple(Generator2(4, 10)))
