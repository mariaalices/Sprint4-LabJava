package sprint4;

import java.util.Scanner;

public class Sprint4 {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int numEquipe = 0;
		// ENTRADA NUM. EQUIPE
		System.out.println("Bem vindo ao RobôCup!");
		do {
			System.out.println("Insira quantas equipes participarão:");
			numEquipe = e.nextInt();
		} while (numEquipe > 10);
		// INSERINDO NOME EQUIPE
		String[] nomeEquipe = new String[numEquipe];

		for (int i = 0; i < nomeEquipe.length; i++) {
			System.out.println("Insira o nome da " + (i + 1) + "° a participar:");
			nomeEquipe[i] = e.next();
		}

		System.out.println("= = = = = = = = = = = = = = = = = = = =");
		// ITEM1
		int equipe1 = 0, equipe2 = 0, notaDesign1 = 0, notaDesign2 = 0;
		int[][] combate = new int[numEquipe][numEquipe];
		for (int l = 0; l < combate.length; l++) {
			for (int c = 0; c < combate.length; c++) {

				// IF PULA COMBATE EQUIPE IGUAL
				if (c == l && c < combate.length - 1) {
					c++;
				}
				// IF PULA COMBATE REPETIDO(INVERTIDO)/ELSEIF PULA ULTIMA EQUIPE IGUAL
				if (c < l) {
					System.out.print("");
				} else if (c == l && l == combate.length - 1) {
					System.out.print("");
				} else {
					equipe1 = (int) (Math.random() * 10);
					equipe2 = (int) (Math.random() * 10);
					// System.out.println(equipe1);
					// System.out.println(equipe2);
					// System.out.println("!!!!!!");
					if (equipe1 > equipe2) {
						System.out.println("COMBATE: EQUIPE[" + nomeEquipe[l] + "]->" + equipe1 + " VS EQUIPE["
								+ nomeEquipe[c] + "]->" + equipe2);
						combate[l][c] = 2;
						// System.out.println(combate[l][c]);
						combate[c][l] = 0;
						// System.out.println(combate[c][l]);
					} else if (equipe1 < equipe2) {
						System.out.println("COMBATE: EQUIPE[" + nomeEquipe[l] + "]->" + equipe1 + " VS EQUIPE["
								+ nomeEquipe[c] + "]->" + equipe2);
						combate[l][c] = 0;
						// System.out.println(combate[l][c]);
						combate[c][l] = 2;
						// System.out.println(combate[c][l]);
					} else {
						do {
							System.out.println("= = = = = = = =");
							System.out.println(
									"COMBATE: (EMPATE) Insira a nota de design da equipe[" + nomeEquipe[l] + "]:");
							notaDesign1 = e.nextInt();
						} while (notaDesign1 > 10);
						do {
							System.out.println("= = = = = = = =");
							System.out.println(
									"COMBATE:(EMPATE) Insira a nota de design da equipe[" + nomeEquipe[c] + "]:");
							notaDesign2 = e.nextInt();
						} while (notaDesign2 > 10);

						if (notaDesign1 > notaDesign2) {
							combate[l][c] = 2;
							combate[c][l] = 0;
						} else if (notaDesign1 < notaDesign2) {
							combate[l][c] = 0;
							combate[c][l] = 2;
						} else {
							// empate 2 vezes-> combate anulado
							System.out.println("COMBATE: ANULADO (DUPLO EMPATE!)");
							combate[l][c] = 0;
							combate[c][l] = 0;
						}
					}
				}

			}
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = =");
		int[] combatePontos = new int[numEquipe];

		// QUANTIFICA PONTOS
		for (int l = 0; l < combate.length; l++) {
			for (int c = 0; c < combate.length; c++) {
				if (combate[l][c] == 2) {
					combatePontos[l] += 2;
				} else if (combate[l][c] == 1) {
					combatePontos[l] += 1;
				} else {
					combatePontos[l] += 0;
				}
			}
		}
		/*
		 * for (int i = 0; i < combatePontos.length; i++) {
		 * System.out.println(combatePontos[i]); }
		 */
		System.out.println("= = = = = = = = RANKING = = = = = = = =");

		for (int c = 0; c < numEquipe; c++) {
			for (int t = 0; t < numEquipe - 1; t++) {
				if (combatePontos[t] < combatePontos[t + 1]) {
					String z = nomeEquipe[t];
					nomeEquipe[t] = nomeEquipe[t + 1];
					nomeEquipe[t + 1] = z;

					int x = combatePontos[t];
					combatePontos[t] = combatePontos[t + 1];
					combatePontos[t + 1] = x;
				}
			}
		}
		for (int i = 0; i < numEquipe; i++) {
			System.out.println((i + 1) + "° LUGAR:" + nomeEquipe[i]+"\t"+"PONTOS:"+combatePontos[i]);
		}

		System.out.println("= = = = = A GRANDE FINAL = = = = =");
		System.out.println("EQUIPES FINALISTAS:");
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "° FINALISTA:" + nomeEquipe[i]);
		}
		System.out.println("- - - - - - - - - - - - - - - -");
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {

				// IF PULA COMBATE EQUIPE IGUAL
				if (c == l && c < combate.length - 1) {
					c++;
				}
				// IF PULA COMBATE REPETIDO(INVERTIDO)/ELSEIF PULA ULTIMA EQUIPE IGUAL
				if (c < l) {
					System.out.print("");
				} else if (c == l && l == combate.length - 1) {
					System.out.print("");
				} else {
					equipe1 = (int) (Math.random() * 10);
					equipe2 = (int) (Math.random() * 10);
					// System.out.println(equipe1);
					// System.out.println(equipe2);
					// System.out.println("!!!!!!");
					if (equipe1 > equipe2) {
						System.out.println("COMBATE: EQUIPE[" + nomeEquipe[l] + "]->" + equipe1 + " VS EQUIPE["
								+ nomeEquipe[c] + "]->" + equipe2);
						combate[l][c] = 2;
						// System.out.println(combate[l][c]);
						combate[c][l] = 0;
						// System.out.println(combate[c][l]);
					} else if (equipe1 < equipe2) {
						System.out.println("COMBATE: EQUIPE[" + nomeEquipe[l] + "]->" + equipe1 + " VS EQUIPE["
								+ nomeEquipe[c] + "]->" + equipe2);
						combate[l][c] = 0;
						// System.out.println(combate[l][c]);
						combate[c][l] = 2;
						// System.out.println(combate[c][l]);
					} else {
						do {
							System.out.println("= = = = = = = =");
							System.out.print(
									"COMBATE: (EMPATE) Insira a nota de design da equipe[" + nomeEquipe[l] + "]:");
							notaDesign1 = e.nextInt();
						} while (notaDesign1 > 10);
						do {
							System.out.println("= = = = = = = =");
							System.out.print(
									"COMBATE:(EMPATE) Insira a nota de design da equipe[" + nomeEquipe[c] + "]:");
							notaDesign2 = e.nextInt();
						} while (notaDesign2 > 10);

						if (notaDesign1 > notaDesign2) {
							combate[l][c] = 2;
							combate[c][l] = 0;
						} else if (notaDesign1 < notaDesign2) {
							combate[l][c] = 0;
							combate[c][l] = 2;
						} else {
							// empate 2 vezes-> combate anulado
							System.out.println("COMBATE: ANULADO (DUPLO EMPATE!)");
							combate[l][c] = 0;
							combate[c][l] = 0;
						}
					}
				}

			}
		}
		
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				if (combate[l][c] == 2) {
					combatePontos[l] += 2;
				} else if (combate[l][c] == 1) {
					combatePontos[l] += 1;
				} else {
					combatePontos[l] += 0;
				}
			}
		}
		System.out.println("= = = = = = = = RANKING FINAL = = = = = = = =");

		for (int c = 0; c < 3; c++) {
			for (int t = 0; t < 3 - 1; t++) {
				if (combatePontos[t] < combatePontos[t + 1]) {
					String z = nomeEquipe[t];
					nomeEquipe[t] = nomeEquipe[t + 1];
					nomeEquipe[t + 1] = z;

					int x = combatePontos[t];
					combatePontos[t] = combatePontos[t + 1];
					combatePontos[t + 1] = x;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.println((i + 1) + "° LUGAR:" + nomeEquipe[i]+"\t"+"PONTOS:"+combatePontos[i]);
		}
		System.out.println("PARABÉNS EQUIPE["+nomeEquipe[0]+"]");
		e.close();
	}

}
