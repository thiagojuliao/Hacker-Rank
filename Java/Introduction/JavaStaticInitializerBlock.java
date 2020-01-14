static int B;
static int H;
static boolean flag = true;

static{

	Scanner scan = new Scanner(System.in);
	B = scan.nextInt();
	H = scan.nextInt();

	if(B<=0 || H<=0){
		System.out.print("java.lang.Exception: Breadth and height must be positive");
		flag = false;
	}
}
