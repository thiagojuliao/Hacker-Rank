if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))

    # Ordena a lista
    arr.sort()

    # Pega o ultimo valor da lista e remove todos os valores iguais
    max_score = arr[-1]

    arr_ = [e for e in arr if e != max_score]
    arr_.sort()

    # Retorna o segundo maior valor da lista
    print(arr_[-1])

