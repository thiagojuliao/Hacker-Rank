class Add{

    public void add(int... nums){
        int sum = 0;
        int cont = 0;

        for (int num : nums){
            cont++;
            if (cont != nums.length){
                System.out.print(num + "+");
            }else{
                System.out.print(num);
            }
            sum += num;
        }
        System.out.println("=" + sum);
    }
}

