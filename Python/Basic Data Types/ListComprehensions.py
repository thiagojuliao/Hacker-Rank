if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())

    dim_x = range(0, x+1)
    dim_y = range(0, y+1)
    dim_z = range(0, z+1)
    
    lst = [   
        [x, y, z]
        for x in dim_x for y in dim_y for z in dim_z
        if x + y + z != n
    ]

    print(lst)

