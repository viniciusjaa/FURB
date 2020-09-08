package aula080920;
public class Main {
	public static void main(String[] args) {
		boolean repetir = true;
		byte[] memoria = new byte[255];
		int IP = 0;
		int RI, AX = 0, BX, CX, BP, SP; // Registradores da CPU

		// Atribuições | Correspondem ao "código executável da máquina"
		memoria[0] = 0;
		memoria[1] = 19;
		memoria[2] = 19;
		memoria[3] = 50;
		memoria[4] = 40;

		while(repetir){
			RI = memoria[IP]; 		// Ciclo de busca | Acessando o barramento que liga a CPU à memória
			switch (RI) { 			// DECODIFICAÇÃO
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
					break; // Instrução halt (desliga o processador)
				default:
					System.out.println("Esse programa executou uma instrução ilegal e será fechado.");
					repetir = false; // INT = 0, por exemplo, para sinalizar "instrução inválida"
					break;
			} // switch
			System.out.println("AX = " + AX);
		} // while
	}	
}