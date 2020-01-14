package com.example.lottery.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named("lottery")
@SessionScoped
public class LotteryModel implements Serializable {
	private List<List<Integer>> numbers = new ArrayList<>();

	public LotteryModel() {
	}

	public List<List<Integer>> getNumbers() {
		return numbers;
	}

}
