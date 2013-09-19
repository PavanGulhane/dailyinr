package com.hourlyinr.json;

public class CurrencyRateText {

	public CurrencyRateText( String ccy, String currencyRate, String inrRate){
		this.ccy = ccy;
		this.baseRate = new Double(currencyRate);
		this.inrRate = new Double(inrRate);
	}
	
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public Double getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(Double baseRate) {
		this.baseRate = baseRate;
	}
	public Double getInrRate() {
		return inrRate;
	}
	public void setInrRate(Double inrRate) {
		this.inrRate = inrRate;
	}

	private String ccy;
	private Double baseRate;
	private Double inrRate;
	
	
}
