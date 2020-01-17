package com.example.binance.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Trade {
	@JsonbProperty("s")
	private String symbol;
	@JsonbProperty("p")
	private String price;
	@JsonbProperty("q")
	private String quantity;
	@JsonbProperty("t")
	private long sequence;
	@JsonbProperty("E")
	private String timestamp;
	@JsonbProperty("b")
	private long bidId;
	@JsonbProperty("a")
	private long askId;

	public Trade() {
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public long getBidId() {
		return bidId;
	}

	public void setBidId(long bidId) {
		this.bidId = bidId;
	}

	public long getAskId() {
		return askId;
	}

	public void setAskId(long askId) {
		this.askId = askId;
	}

	@Override
	public String toString() {
		return "Trade [symbol=" + symbol + ", price=" + price + ", quantity=" + quantity + ", sequence=" + sequence
				+ ", timestamp=" + timestamp + ", bidId=" + bidId + ", askId=" + askId + "]";
	}

}
