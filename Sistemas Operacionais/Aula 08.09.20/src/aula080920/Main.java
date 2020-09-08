package aula080920;
public class Main {
	public static void main(String[] args) {
		boolean repetir = true;
		byte[] memoria = new byte[255];
		int IP = 0;
		int RI, AX = 0, BX, CX, BP, SP; // Registradores da CPU

		// Atribui��es | Correspondem ao "c�digo execut�vel da m�quina"
		memoria[0] = 0;
		memoria[1] = 19;
		memoria[2] = 19;
		memoria[3] = 50;
		memoria[4] = 40;

		while(repetir){
			RI = memoria[IP]; 		// Ciclo de busca | Acessando o barramento que liga a CPU � mem�ria
			switch (RI) { 			// DECODIFICA��O
				case 0:
					AX = 0;
					IP++;
					break;
				case 19: 
					AX++;
					IP++;
					break;
				case 40:
					repetir = false;
					break; // Instru��o halt (desliga o processador)
				default:
					System.out.println("Esse programa executou uma instru��o ilegal e ser� fechado.");
					repetir = false; // INT = 0, por exemplo, para sinalizar "instru��o inv�lida"
					break;
			} // switch
			System.out.println("AX = " + AX);
		} // while
	}	
}