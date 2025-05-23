import java.io.*;

enum TokenType {NUM, SOMA, MULT, APar, FPar, EOF}

class Token {
    String lexema;
    TokenType token;

    Token(String l, TokenType t) {
        lexema = l;
        token = t;
    }
}

class AnaliseLexica {

    PushbackReader arquivo;

    AnaliseLexica(String a) throws Exception {

        this.arquivo = new PushbackReader(new FileReader(a));

    }

    Token getNextToken() throws Exception {
        Token token;
        int eof = -1;
        char currchar;
        int currcharInt;

        do {
            currcharInt = arquivo.read();
            currchar = (char) currcharInt;
        } while (currchar == '\n' || currchar == ' ' || currchar == '\t' || currchar == '\r');

        if (currcharInt != eof && currcharInt != 10) {

            if (currchar >= '0' && currchar <= '9') {
				StringBuilder numToken = new StringBuilder();
				do {
					numToken.append(currchar);
					currchar = (char) arquivo.read();
				} while(currchar >= '0' && currchar <= '9');
				arquivo.unread(currchar);
				return (new Token(numToken.toString(), TokenType.NUM));
			} else {
				switch (currchar) {
					case '(':
						return (new Token(String.valueOf(currchar), TokenType.APar));
					case ')':
						return (new Token(String.valueOf(currchar), TokenType.FPar));
					case '+':
						return (new Token(String.valueOf(currchar), TokenType.SOMA));
					case '*':
						return (new Token(String.valueOf(currchar), TokenType.MULT));

					default:
						throw (new Exception("Caractere inválido: " + ((int) currchar)));
				}
			}
        }

        arquivo.close();

        return (new Token(String.valueOf(currchar), TokenType.EOF));

    }
}
