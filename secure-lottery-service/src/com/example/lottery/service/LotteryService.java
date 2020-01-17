package com.example.lottery.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ejb.Singleton;

@Singleton
public class LotteryService {

	public List<Integer> draw() {
		return ThreadLocalRandom.current().ints(1,50).distinct().limit(6).sorted().boxed().collect(Collectors.toList());
	}

	public List<List<Integer>> draw(int n) {
		return IntStream.range(0,n).mapToObj(i -> this.draw()).collect(Collectors.toList());
	}

}
