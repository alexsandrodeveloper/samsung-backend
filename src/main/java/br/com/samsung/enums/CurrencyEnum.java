package br.com.samsung.enums;

public enum CurrencyEnum {

	USD("Dolar"), PEN("Soles Peruano"), BRL("Real");

	private String descricao;

	private CurrencyEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static CurrencyEnum valueOfTipo(String tipo) {

		for (CurrencyEnum currency : values()) {
			if (currency.name().equals(tipo)) {
				return currency;
			}
		}
		return null;
	}

}
