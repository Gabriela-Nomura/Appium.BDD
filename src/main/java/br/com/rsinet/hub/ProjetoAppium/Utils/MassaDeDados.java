package br.com.rsinet.hub.ProjetoAppium.Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MassaDeDados {
	/**
	 * Classe para fixa��o de atributos constantes. Leitura de dados de excel e
	 * configura��o dos screenshots
	 * @throws Exception 
	 */
	public static final String Path_TestData = "C://Users//gabriela.nomura//Documents//automacao//testData.xlsx";
	
	public static void configExcel() throws Exception{
	ConfigExcel.setExcelFile(Path_TestData, "Teste");
	}


	public static final int Col_NomeBusca = 0;
	public static final int Col_Elemento = 1;

	public static final String userName(int i) throws Exception {
		return ConfigExcel.getCellData(i, 0);
	
	}

	public static final String userEmail() throws Exception {
		return ConfigExcel.getCellData(1, 1);
	}

	public static final String userSenha() throws Exception {
		return ConfigExcel.getCellData(1, 2);
	}

	public static final String userSenhaConfirmacao() throws Exception {
		return ConfigExcel.getCellData(1, 3);
	}

	public static final String userPrimeiroNome() throws Exception {
		return ConfigExcel.getCellData(1, 4);
	}

	public static final String userUltimoNome() throws Exception {
		return ConfigExcel.getCellData(1, 5);
	}

	public static final String userTelefone() throws Exception {
		return ConfigExcel.getCellData(1, 6).toString();
	}

	
}