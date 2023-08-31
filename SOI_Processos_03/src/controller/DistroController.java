package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}
	
	private String SO_teste() {
		String os  = System.getProperty("os.name");
		return os;
	}
	
	public void distro_teste() {
		String OS = SO_teste();
		
		if(OS.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("cat /etc/os-release");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha!=null) {
					if(linha.contains("PRETTY_NAME=")) {
						String []vlinha = linha.split("=");
						String []velinha = vlinha[1].split(" ");
						String[]vetlinha = velinha[0].split("/");
						System.out.println(vetlinha[0]);
					}
					linha = buffer.readLine();
					if(linha.contains("VERSION_ID")) {
						String []vlinha2 = linha.split("=");
						System.out.println(vlinha2[1]);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Seu sistema operacional não é Linux");
		}
	}
	
}
