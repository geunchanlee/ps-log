
T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())

    puzzle = [[int(i) for i in input().split()] for _ in range(N)]

    answer = 0

    for y in range(N):
        for x in range(N):
            if puzzle[y][x] == 1:
                if x == 0 or puzzle[y][x-1] == 0:
                    for row in range(1, K):
                        nx = x + row
                        if nx >= N or puzzle[y][nx] == 0:
                            break
                        if row == K - 1 and nx + 1 < N:
                            if puzzle[y][nx + 1] == 1:
                                break
                    else:
                        answer += 1

                if y == 0 or puzzle[y-1][x] == 0:
                    for col in range(1, K):
                        ny = y + col
                        if ny >= N or puzzle[ny][x] == 0:
                            break
                        if col == K - 1 and ny + 1 < N:
                            if puzzle[ny + 1][x] == 1:
                                break
                    else:
                        answer += 1

    print(f"#{test_case} {answer}")