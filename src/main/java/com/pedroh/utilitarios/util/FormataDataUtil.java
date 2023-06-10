package com.pedroh.utilitarios.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataDataUtil {
	
	public static String formataData(String dataString) {
		LocalDate data = LocalDate.parse(dataString);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}
}
