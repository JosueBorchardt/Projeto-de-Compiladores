
class Interpretador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv = null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();

			CodeGen2 backend = new CodeGen2();
			int codigo = backend.geraCodigo(arv);
			System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
