class Ferramentas {
	/**
	 * Função que simula a String.replace() e a String.trim()
	 * 
	 * @param frase  Frase para ser formatada
	 * @param antiga Char para ser alterado
	 * @param nova   Novo char para ser adicionado
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String myReplace(String frase, char antiga, char nova) {
		String resp = "";
		if (frase != null) {
			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) == antiga) {
					resp += nova;
				} else {
					// trim para remover espaços
					if (frase.charAt(i) != ' ') {
						resp += frase.charAt(i);
					}
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula o indexOf da classe String
	 * 
	 * @param frase  para procurar o char
	 * @param antiga Char para ser localizado
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static int myIndexOf(String frase, char letra) {
		int resp = -1;
		if (frase != null) {
			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) == letra) {
					resp = i;
					i = frase.length();
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula o trim da classe String
	 * 
	 * @param frase para remover os espaços e realizar formatação
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String myTrim(String frase) {
		String resp = "";
		if (frase != null) {
			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) != ' ') {
					resp += frase.charAt(i);
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula o Substring da classe String
	 * 
	 * @param frase para procurar a String interna
	 * @param inic  index inicial
	 * @param fim   index final
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String mySubstring(String frase, int inic, int fim) {
		String resp = "";
		if (frase != null) {
			if (fim - inic <= frase.length()) {
				for (int i = inic; i < fim; i++) {
					resp += frase.charAt(i);
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula o Substring da classe String
	 * 
	 * @param frase para procurar a String interna
	 * @param cInic char para localizar o index inicial
	 * @param cFim  char para localizar o index final
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String mySubstring(String frase, char cInic, char cFim) {
		String resp = "";
		if (frase != null) {
			int inic = Ferramentas.myIndexOf(frase, cInic);
			int fim = Ferramentas.myIndexOf(frase, cFim);
			if (fim - inic <= frase.length()) {
				for (int i = inic; i < fim + 1; i++) {
					resp += frase.charAt(i);
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula a String.contains() para strings
	 * 
	 * @param frase Frase para ser verificada
	 * @param ver   verificação que vai ser usada
	 * @return Verdade ou falso de acordo com a verificação
	 */
	public static boolean myContains(String frase, String ver) {
		boolean resp = false;
		String aux = "";
		int count = 0;
		if (frase != null) {
			for (int i = 0; i < frase.length(); i++) {
				if (frase.charAt(i) == ver.charAt(0)) {
					if ((frase.length() - i) >= ver.length()) {
						for (int j = i; j < frase.length(); j++) {
							aux += frase.charAt(j);
							count++;
							if (count == ver.length()) {
								j = frase.length();
								count = 0;
							}
						}
						if (myEquals(aux, ver)) {
							resp = true;
							i = frase.length();
						} else {
							aux = "";
							count = 0;
						}
					} else {
						aux = "";
					}
				}
			}
		}
		return resp;
	}

	// Metodo de comparação de duas Strings e retorna sua igualdade em forma de
	// boolean
	public static boolean myEquals(String str1, String str2) {
		boolean resp = false;
		if (str1 != null && str2 != null) {
			if (str1.length() == str2.length()) {
				resp = true;
				for (int i = 0; i < str1.length(); i++) {
					if (str1.charAt(i) != str2.charAt(i)) {
						resp = false;
					}
				}
			}
		}
		return resp;
	}

	/**
	 * Função que simula a String.replace() para strings
	 * 
	 * @param frase  Frase para ser formatada
	 * @param antiga String para ser alterado
	 * @param nova   String para ser adicionado
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String myReplace(String str, String str_old, String str_new) {
		String resp = "", auxresp = "";
		boolean eql = false;
		int j = 0;
		if (str != null && str_new != null && str_old != null) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == str_old.charAt(j)) {
					eql = true;
					j++;
					auxresp += str.charAt(i);
				} else {
					if (eql) {
						j = 0;
						if (str.charAt(i) == str_old.charAt(j)) {
							resp += auxresp;
							auxresp = "";
							eql = true;
							j++;
							auxresp += str.charAt(i);
						} else {
							eql = false;
							resp += auxresp += str.charAt(i);
							auxresp = "";
						}
					} else {
						resp += str.charAt(i);
					}
				}
				if (eql) {
					if (j == str_old.length()) {
						resp += str_new;
						auxresp = "";
						j = 0;
						eql = false;
					}
				}
			}
		}
		return resp;
	}

	/**
	 * Função que remove espaços do inicio de frases
	 * 
	 * @param frase Frase para ser formatada
	 * @param end   char de condição final
	 * @return Frase de expressao formatada e pronta para uso
	 */
	public static String inicioTrim(String line, char end) {
		String resp = "";
		boolean next = false;
		if (line != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == end) {
					next = true;
				}
				if (next)
					resp += line.charAt(i);
			}
		}
		if (resp.length() == 0)
			return line;
		else
			return resp;
	}

	/**
	 * Função que remove tags e puxa tudo que esta entre elas
	 * 
	 * @param frase Frase para ser formatada sem as tags
	 * @return Frase de expressao formatada e pronta para uso com TUDO que está fora
	 *         das tags
	 */
	public static String removeTags(String line) {
		String resp = "";
		boolean next = false;
		if (line != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '>')
					next = true;
				else if (line.charAt(i) == '<')
					next = false;
				else if (next)
					resp += line.charAt(i);
			}
		}
		return resp;
	}

	/**
	 * Função que remove tags e puxa tudo que esta entre elas e adiciona separadores
	 * para palavras
	 * 
	 * @param frase Frase para ser formatada sem as tags
	 * @param frase Separador para distribuir frases e etc
	 * @return Frase de expressao formatada e pronta para uso com TUDO que está fora
	 *         das tags
	 */
	public static String removeTags(String line, char separador) {
		String resp = "";
		int count = 0;
		boolean next = false;
		if (line != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '>')
					next = true;
				else if (line.charAt(i) == '<') {
					next = false;
					if (count != 0)
						resp += separador;
					count = 0;
				} else if (next) {
					count++;
					resp += line.charAt(i);
				}
			}
		}
		return resp;
	}

	// Essa função retorna uma data em String convertida para o objeto de Date do
	// Java
	public static Date getData(String data) {
		Date date = null;
		if (data != null) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				date = format.parse(data);
			} catch (ParseException pe) {
				MyIO.println(pe.getMessage());
				return null;
			}
		}
		return date;
	}

	// funcao que remove letras e gera um horario em formato de minutos pronto para
	// uso
	// realizando o calculo automatico das horas se possível (Horas * 60 = horas em
	// minutos)
	public static int getMinutos(String linha) {
		String hr = "", mn = "";
		int conta = 0;
		boolean chk = false;
		if (linha != null) {
			for (int i = 0; i < linha.length(); i++) {
				if (chk) {
					if (linha.charAt(i) != ' ') {
						mn += linha.charAt(i);
					}
				} else {
					if (linha.charAt(i) != ' ') {
						hr += linha.charAt(i);
					} else {
						chk = true;
					}
				}
			}
			conta = Integer.parseInt(mn);
			if (hr.length() > 0) {
				conta += Integer.parseInt(hr) * 60;
			}
		}
		return conta;
	}

}