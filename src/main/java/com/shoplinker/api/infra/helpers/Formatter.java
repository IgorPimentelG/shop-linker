package com.shoplinker.api.infra.helpers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Formatter {
	public static String cpf(String value) {
		var formatter = new DecimalFormat("000.000.000-00");
		return formatter.format(Long.parseLong(value));
	}

	public static String datetime(LocalDateTime value) {
		var formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return formatter.format(value);
	}
}
