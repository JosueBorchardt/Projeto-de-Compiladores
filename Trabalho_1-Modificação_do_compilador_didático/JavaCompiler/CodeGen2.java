class CodeGen2 {

	Integer geraCodigo(ArvoreSintatica arv) {
		return (geraCodigo2(arv));
	}

	Integer geraCodigo2(ArvoreSintatica arv) {

		if (arv instanceof Mult) {
			Integer arg1 = geraCodigo2(((Mult) arv).arg1);
			Integer arg2 = geraCodigo2(((Mult) arv).arg2);

			return(arg1 * arg2);
		}

		if (arv instanceof Soma) {
			int arg1 = geraCodigo2(((Soma) arv).arg1);
			int arg2 = geraCodigo2(((Soma) arv).arg2);

			return(arg1 + arg2);
		}

		if (arv instanceof Sub) {
			int arg1 = geraCodigo2(((Sub) arv).arg1);
			int arg2 = geraCodigo2(((Sub) arv).arg2);

			return(arg1 - arg2);
			
		}

		if (arv instanceof Div) {
			int arg1 = geraCodigo2(((Div) arv).arg1);
			int arg2 = geraCodigo2(((Div) arv).arg2);

			if (arg2 == 0) {
				throw new ArithmeticException("Não é permitido divisão por zero.");
			}

			return(arg1 / arg2);
		}

		if (arv instanceof Num) {
			return (((Num) arv).num);
		}

		return 0;

	}
}