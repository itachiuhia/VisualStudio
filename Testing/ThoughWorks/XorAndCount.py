def count_sub_array_xor_sum(N, M, A, queries):
    for l, r in queries:
        count = 0
        X = 0
        for i in range(l-1, r):
            for j in range(i, r):
                for k in range(i, j+1):
                    X ^= A[k]
                if X+1 == X^1:
                    count += 1
                X = 0
        yield count


n = 10
m = 7
a = [88839,961206,772332,452376,297855,310023,916002,817530,29466,480085]
queries = [[6,9],[5,8],[4,7],[9,9],[8,9],[8,8],[2,4]]

for ans in count_sub_array_xor_sum(n,m, a, queries):
    print(ans)

